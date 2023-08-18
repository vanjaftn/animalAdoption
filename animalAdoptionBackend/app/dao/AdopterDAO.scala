package dao

import model.{Admin, Adopter, Vet}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class AdopterDAO @Inject()(
                        protected val dbConfigProvider: DatabaseConfigProvider
                      )(
                        implicit executionContext: ExecutionContext
                      ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Adopters = TableQuery[AdoptersTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(adopter: Adopter): Future[Adopter] = {
    val newAdopterId = Option(Random.alphanumeric.take(16).mkString)
    val newAdopter = adopter.copy(adopterId = newAdopterId)
    db.run(Adopters += adopter.copy(adopterId = Option(Random.alphanumeric.take(16).mkString))).map(_ => newAdopter)

  }

  def readAll: Future[Seq[Adopter]] = {
    db.run(Adopters.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Adopters.filter(_.adopterId === id).delete)
  }

  class AdoptersTable(tag: Tag) extends Table[Adopter](tag, "adopters") {

    def adopterId = column[Option[String]]("ADOPTERID", O.PrimaryKey)

    def userId = column[String]("USERID")


    def * = (adopterId, userId) <> ((Adopter.apply _).tupled, Adopter.unapply)

  }


}
