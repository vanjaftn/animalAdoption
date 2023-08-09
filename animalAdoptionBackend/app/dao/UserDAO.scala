package dao

import auth.JwtUtil
import dto.LoginUserDTO
import model.User
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import scala.util.Random


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

  def loginUser(loggedUser: LoginUserDTO): Future[String] = {
    val jwt = JwtUtil.createToken(loggedUser)

    db.run(Users.result.head.map(res => jwt)).recover {
      case ex: Exception => "Wrong password"
    }
  }

  def create(user: User): Future[User] = {
    val newUserId = Option(Random.alphanumeric.take(16).mkString)
    val newUser = user.copy(userId = newUserId)
    db.run(Users += user.copy(userId = Option(Random.alphanumeric.take(16).mkString)).copy(password = BCrypt.hashpw(newUser.password, BCrypt.gensalt(12)))).map(_ => newUser)

  }

  def emailExists(email: String): Future[Option[User]] = {
    db.run(Users.filter(_.email === email).result.headOption)
  }

  def readAll: Future[Seq[User]] = {
    db.run(Users.result)
  }

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
