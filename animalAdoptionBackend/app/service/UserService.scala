package service

import dao.{AdoptionDAO, CreateUserDAO, UserDAO}
import dto.{CreateUserDTO, LoginUserDTO}
import model.User
import org.mindrot.jbcrypt.BCrypt

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class UserService @Inject()(userDAO: UserDAO,
                            createUserDAO: CreateUserDAO,
                            adoptionDAO: AdoptionDAO,
                            emailService: EmailService,
                            smsService: SMSService
                           )(implicit ec : ExecutionContext) {

  def loginUser(loggedUser: LoginUserDTO): Future[String] = {
    userDAO.emailExists(loggedUser.email).flatMap {
      case None => throw new Exception("Email doesn't exist")
      case Some(userObj) =>
        if (BCrypt.checkpw(loggedUser.password, userObj.password)) {
          userDAO.loginUser(loggedUser)
        } else
          throw new Exception("Wrong password")
    }
  }

  def confirm(user: User) = {
    userDAO.emailExists(user.email).flatMap {
      case None =>
        val random = new Random
        val userDTOWithConfirmation = new CreateUserDTO(userId = user.userId, email = user.email,
          password = user.password, firstName = user.firstName, lastName = user.lastName,
          dateOfBirth = user.dateOfBirth, phoneNumber = user.phoneNumber, personalId = user.personalId,
          confirmationCode = random.alphanumeric.take(15).mkString)

        smsService.sendSms(user.phoneNumber, "Welcome to our application! Enjoy!")
        emailService.sendEmail(user.email, "Confirmation mail", "Click to confirm your email" + " " + "http://localhost:9000/user/" + userDTOWithConfirmation.confirmationCode)
        createUserDAO.create(userDTOWithConfirmation)

      case Some(_) => throw new Exception("Email already exists")
    }
  }

  def create(confirmationCode: String): Future[User] = {
    val userWithConfirmationCode = createUserDAO.readByConfirmationCode(confirmationCode)
    userWithConfirmationCode.flatMap(userDTO => createUserDAO.delete(userDTO.userId.head))
    userWithConfirmationCode.flatMap(userDTO => userDAO.create(new User(userId = userDTO.userId, email = userDTO.email, password = userDTO.password, firstName = userDTO.firstName, lastName = userDTO.lastName, dateOfBirth = userDTO.dateOfBirth, phoneNumber = userDTO.phoneNumber, personalId = userDTO.personalId)))
  }

  def emailExists(email: String): Future[Option[User]] = {
    userDAO.emailExists(email)
  }

  def passwordExists(password: String, loggedInUser: String) = {
    val readUser = read(loggedInUser)
    readUser.flatMap( user =>
      if(BCrypt.checkpw(password, user.password)){
        val result = userDAO.passwordExists(password, loggedInUser)
        result
      }
      else{
        throw new Exception("Wrong password")
      })

  }

  def read(id: String): Future[User] = {
    userDAO.read(id)
  }

  def update(user: User): Future[User] = {
    val userWithHashedPassword = user.copy(password = BCrypt.hashpw(user.password, BCrypt.gensalt(12)))

    userDAO.update(userWithHashedPassword)
  }

  def delete(id: String): Future[Int] = {
    userDAO.delete(id)
  }

  def readAll: Future[Seq[User]] = {
    userDAO.readAll
  }

  def readAllAnimalPendingAdopters(animalId: String): Future[Seq[User]] = {
    for {
      pendingAdoptions <- adoptionDAO.readAllAnimalPendingAdoptions(animalId)
      users <- Future.sequence(pendingAdoptions.map(pendingAdoption => read(pendingAdoption.userId)))
    } yield {
      val res = users
      res
    }
  }

  def readAllAnimalAdminApprovedAdopters(animalId: String): Future[Seq[User]] = {
    for {
      approvedAdoptions <- adoptionDAO.readAllAnimalAdminApprovedAdoptions(animalId)
      users <- Future.sequence(approvedAdoptions.map(approvedAdoption => read(approvedAdoption.userId)))
    } yield {
      val res = users
      res
    }
  }

  def forgotPassword(userEmail: String): Unit = {
    val random = new Random
    val newUserPassword = random.alphanumeric.take(7).mkString

    val user = userDAO.emailExists(userEmail)
    val newUser = user.map(_.map(u => u.copy(password = newUserPassword)))

    newUser.map(_.map(u => update(u)))

    emailService.sendEmail(userEmail, "Forgot password", s"Your new password is \"${newUserPassword}\", but you can change it later on.")
  }
}
