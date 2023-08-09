package service

import dao.UserDAO
import dto.LoginUserDTO
import model.User
import org.mindrot.jbcrypt.BCrypt

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userDAO: UserDAO
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
//    userDAO.emailExists(user.email).flatMap {
//      case None =>
        userDAO.create(user)
//      case Some(_) => throw new Exception("Email already exists")
//    }
  }
  def emailExists(email: String): Future[Option[User]] = {
    userDAO.emailExists(email)
  }

  def readAll: Future[Seq[User]] = {
    userDAO.readAll
  }
}