package dao

import auth.JwtUtil
import dto.{CreateUserDTO, LoginUserDTO}
import model.User
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}

class CreateUserDAO @Inject()(
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val CreateUsers = TableQuery[CreateUsersTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(user: CreateUserDTO): Future[CreateUserDTO] = {
    if(UsersTable.validateEmailFormat(user.email)){
      val newUserId = UUID.randomUUID().toString
      val newUser = user.copy(userId = Some(newUserId))

      db.run(CreateUsers += newUser.copy(password = BCrypt.hashpw(newUser.password, BCrypt.gensalt(12)))).map(_ => newUser)
    }
    else{
      throw new Exception("Invalid email form")
    }
  }

  def readByConfirmationCode(confirmationCode: String): Future[CreateUserDTO] = {
    db.run(CreateUsers.filter(_.confirmationCode === confirmationCode).result.head)
  }

  def delete(id: String): Future[Int] = {
    db.run(CreateUsers.filter(_.userId === id).delete)
  }

  class CreateUsersTable(tag: Tag) extends Table[CreateUserDTO](tag, "createUsers") {
    def userId = column[Option[String]]("USERID", O.PrimaryKey)

    def email = column[String]("EMAIL")

    def password = column[String]("PASSWORD")

    def firstName = column[String]("FIRSTNAME")

    def lastName = column[String]("LASTNAME")

    def dateOfBirth = column[Date]("DATEOFBIRTH")

    def phoneNumber = column[String]("PHONENUMBER")

    def personalId = column[String]("PERSONALID")

    def confirmationCode = column[String]("CONFIRMATIONCODE")


    def * = (userId, email, password, firstName, lastName, dateOfBirth, phoneNumber, personalId, confirmationCode) <> ((CreateUserDTO.apply _).tupled, CreateUserDTO.unapply)
  }

  object UsersTable {
    // Validate email format before inserting data into the database
    def validateEmailFormat(email: String): Boolean = {
      val emailRegex = ".+@.+\\..+"
      email.matches(emailRegex)
    }
  }
}
