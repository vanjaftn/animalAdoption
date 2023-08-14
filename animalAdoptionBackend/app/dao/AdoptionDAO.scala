package dao


import model.Adoption

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import scala.util.Random


class AdoptionDAO @Inject()(
                                 protected val dbConfigProvider: DatabaseConfigProvider
                               )(
                                 implicit executionContext: ExecutionContext
                               ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Adoptions = TableQuery[AdoptionsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(adoption: Adoption): Future[Adoption] = {
    val newAdoptionId = Option(Random.alphanumeric.take(16).mkString)
    val newAdoption = adoption.copy(adoptionId = newAdoptionId)
    db.run(Adoptions += adoption.copy(adoptionId = Option(Random.alphanumeric.take(16).mkString))).map(_ => newAdoption)

  }

  def delete(id: String): Future[Int] = {
    db.run(Adoptions.filter(_.adoptionId === id).delete)
  }

  def read(id: String): Future[Adoption] = {
    db.run(Adoptions.filter(_.adoptionId === id).result.head)
  }

  def readAll: Future[Seq[Adoption]] = {
    db.run(Adoptions.result)
  }

  def animalAdopted(animalId: String): Future[Option[Adoption]] = {
    db.run(Adoptions.filter(adoption => (adoption.animalId === animalId) && adoption.adoptionStatus === "APPROVED").result.headOption)
  }

//  def animalNotAdopted(animalId: Option[String]): Future[Option[Adoption]] = {
//    db.run(Adoptions.filter(adoption => (adoption.animalId === animalId) || (adoption.animalId === animalId && adoption.adoptionStatus === "PENDING")).result.headOption)
//  }
  def readAllApprovedAdoptions : Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(_.adoptionStatus === "APPROVED").result)
  }

  class AdoptionsTable(tag: Tag) extends Table[Adoption](tag, "adoptions") {

    def adoptionId = column[Option[String]]("ADOPTIONID", O.PrimaryKey, O.AutoInc)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def adoptionDate = column[Date]("ADOPTIONDATE")
    def adoptionStatus = column[String]("ADOPTIONSTATUS")

    def * = (adoptionId, animalId, userId, adoptionDate, adoptionStatus) <> ((Adoption.apply _).tupled, Adoption.unapply)

  }

}
