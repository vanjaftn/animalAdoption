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
import java.util.{Date, UUID}
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
    val newUserId = UUID.randomUUID().toString  // Generate a new UUID for userId
    val newUser = user.copy(userId = Some(newUserId))  // Assign the new userId to the user

    db.run(Users += newUser.copy(password = BCrypt.hashpw(newUser.password, BCrypt.gensalt(12)))).map(_ => newUser)
  }


  def emailExists(email: String): Future[Option[User]] = {
    db.run(Users.filter(_.email === email).result.headOption)
  }

  def readAll: Future[Seq[User]] = {
    db.run(Users.result)
  }

  def read(id: String): Future[User] = {
    db.run(Users.filter(_.userId === id).result.head)
  }

  def update(user: User): Future[User] = {
    val hashPassword = BCrypt.hashpw(user.password, BCrypt.gensalt(12))
    val userWithHashedPassword = user.copy(password = hashPassword)

    db.run(Users.filter(_.userId === user.userId).update(userWithHashedPassword))
      .map(res => userWithHashedPassword)
  }

  def delete(id: String): Future[Int] = {
    db.run(Users.filter(_.userId === id).delete)
  }
  class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def userId = column[Option[String]]("USERID", O.PrimaryKey)

    def email = column[String]("EMAIL")

    def password = column[String]("PASSWORD")

    def firstName = column[String]("FIRSTNAME")

    def lastName = column[String]("LASTNAME")

    def dateOfBirth = column[Date]("DATEOFBIRTH")

    def * = (userId, email, password, firstName, lastName, dateOfBirth) <> ((User.apply _).tupled, User.unapply)
  }
}
