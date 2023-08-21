package service

import dao.{AdoptionDAO, AnimalDAO, UserDAO}
import dto.LoginUserDTO
import model.User
import org.mindrot.jbcrypt.BCrypt

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userDAO: UserDAO,
                            adoptionDAO: AdoptionDAO
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

  def create(user: User): Future[User] = {
    userDAO.emailExists(user.email).flatMap {
      case None =>
        userDAO.create(user)
      case Some(_) => throw new Exception("Email already exists")
    }
  }
  def emailExists(email: String): Future[Option[User]] = {
    userDAO.emailExists(email)
  }

  def read(id: String): Future[User] = {
    userDAO.read(id)
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

}
