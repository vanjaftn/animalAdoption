package dao


import model.Admin
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import scala.util.Random


class AdminDAO @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Admins = TableQuery[AdminsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(userId: String): Future[Admin] = {
    val newAdminId = Option(UUID.randomUUID().toString)
    val newAdmin = new Admin(newAdminId, userId)

    db.run(Admins += newAdmin).map(_ => newAdmin)
  }

  def readAll: Future[Seq[Admin]] = {
    db.run(Admins.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Admins.filter(_.adminId === id).delete)
  }

  def adminExists(userId: String): Future[Boolean] = {
    db.run(Admins.filter(_.userId === userId).exists.result)
  }


  class AdminsTable(tag: Tag) extends Table[Admin](tag, "admins") {

    def adminId = column[Option[String]]("ADMINID", O.PrimaryKey)

    def userId = column[String]("USERID")


    def * = (adminId, userId) <> ((Admin.apply _).tupled, Admin.unapply)

  }

}
