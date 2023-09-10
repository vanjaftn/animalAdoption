package dao

import model.{Admin, Adopter, Vet}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
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
    db.run(Adopters += adopter).map(_ => adopter)

  }

  def readAll: Future[Seq[Adopter]] = {
    db.run(Adopters.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Adopters.filter(_.adopterId === id).delete)
  }

  def adopterExist(userId: String): Future[Boolean] = {
    db.run(Adopters.filter(_.userId === userId).exists.result)
  }

  class AdoptersTable(tag: Tag) extends Table[Adopter](tag, "adopters") {

    def adopterId = column[Option[String]]("ADOPTERID", O.PrimaryKey)

    def userId = column[String]("USERID")


    def * = (adopterId, userId) <> ((Adopter.apply _).tupled, Adopter.unapply)

  }


}
