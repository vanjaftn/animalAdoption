package service


import dao.{AdminDAO, UserDAO, VetDAO}
import model.{User, Vet}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VetService @Inject()(vetDAO: VetDAO,
                           adminDAO: AdminDAO,
                           userDAO: UserDAO
                          )(implicit ec : ExecutionContext){

  def create(vet: User, loggedUserId: String): Future[Vet] = {

    val user = userDAO.create(vet)

      adminDAO.adminExists(loggedUserId).flatMap {
      case true => user.flatMap{ newVet =>
          val createVet : Vet = new Vet(Some(""), newVet.userId.head)
          vetDAO.create(createVet)
      }
      case false => throw new Exception("User is not admin")
    }
  }

  def vetExists(userId: String): Future[Boolean] = {
    vetDAO.vetExists(userId)
  }

  def readAll(): Future[Seq[Vet]] = {
    vetDAO.readAll
  }

  def read(vetId: String): Future[Vet] = {
    vetDAO.read(vetId)
  }

  def delete(vetId: String): Future[Int] = {
    vetDAO.delete(vetId)
  }

}
