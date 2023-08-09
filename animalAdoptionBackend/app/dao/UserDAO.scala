package dao

import model.User

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


class UserDAO @Inject()(
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Users = TableQuery[UsersTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def userId = column[Option[String]]("USERID", O.PrimaryKey, O.AutoInc)

    def email = column[String]("EMAIL")

    def password = column[String]("PASSWORD")

    def firstName = column[String]("FIRSTNAME")

    def lastName = column[String]("LASTNAME")

    def dateOfBirth = column[Date]("DATEOFBIRTH")

    def * = (userId, email, password, firstName, lastName, dateOfBirth) <> ((User.apply _).tupled, User.unapply)
  }
}
