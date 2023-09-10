package dao


import model.LostAndFound

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}


class LostAndFoundDAO @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val LostAndFounds = TableQuery[LostAndFoundsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(lostAndFound: LostAndFound): Future[LostAndFound] = {
    db.run(LostAndFounds += lostAndFound).map(_ => lostAndFound)
  }

  def read(id: String): Future[LostAndFound] = {
    db.run(LostAndFounds.filter(_.lostAndFoundId === id).result.head)
  }

  def readByAnimalId(id: String): Future[LostAndFound] = {
    db.run(LostAndFounds.filter(_.animalId === id).result.head)
  }

  def approve(lostAndFound: LostAndFound): Future[LostAndFound] = {
    db.run(LostAndFounds.filter(_.lostAndFoundId === lostAndFound.lostAndFoundId).map(_.approved).update(true))
      .map(res => lostAndFound)
  }

  def readAll: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(LostAndFounds.filter(_.lostAndFoundId === id).delete)
  }
  def readAllApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(_.approved === true).result)
  }

  def readAllLostApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(lostAndFound => lostAndFound.approved === true && lostAndFound.lostAndFoundStatus=== "LOST" ).result)
  }

  def readAllFoundApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(lostAndFound => lostAndFound.approved === true && lostAndFound.lostAndFoundStatus=== "FOUND" ).result)
  }

  def readAllNotApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(_.approved === false).result)
  }

  def readAllLostNotApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(lost => lost.lostAndFoundStatus === "LOST" && lost.approved === false).result)
  }

  def readAllFoundNotApproved: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(found => found.lostAndFoundStatus === "FOUND" && found.approved === false).result)
  }
  def readAllLost: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(lost => lost.lostAndFoundStatus === "LOST" && lost.approved === true).result)
  }

  def readAllFound: Future[Seq[LostAndFound]] = {
    db.run(LostAndFounds.filter(found => found.lostAndFoundStatus === "FOUND" && found.approved === true).result)
  }

  def lostAndFoundExists(animalId: String): Future[Boolean] = {
    db.run(LostAndFounds.filter(_.animalId === animalId).exists.result)
  }

  class LostAndFoundsTable(tag: Tag) extends Table[LostAndFound](tag, "lostAndFounds") {

    def lostAndFoundId = column[Option[String]]("LOSTANDFOUNDID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def lostAndFoundDate = column[Date]("LOSTANDFOUNDDATE")
    def lostAndFoundStatus = column[String]("LOSTANDFOUNDSTATUS")
    def approved = column[Boolean]("APPROVED")

    def * = (lostAndFoundId, animalId, userId, lostAndFoundDate, lostAndFoundStatus, approved) <> ((LostAndFound.apply _).tupled, LostAndFound.unapply)

  }

}
