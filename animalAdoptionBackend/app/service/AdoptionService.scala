package service

import dao.{AdminDAO, AdoptionDAO, AnimalDAO}
import model.Adoption

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdoptionService @Inject()(adoptionDAO: AdoptionDAO,
                                animalDAO : AnimalDAO,
                                  adminDAO : AdminDAO,
                             )(implicit ec : ExecutionContext) {

  def create(adoption: Adoption, loggedUserId : String): Future[Adoption] = {
    adoptionDAO.create(adoption, loggedUserId)

    animalAdopted(adoption.animalId).flatMap {
      case false => adoptionDAO.create(adoption, loggedUserId)
      case true => throw new Exception("This animal is already adopted")
    }
  }

  def readAll(): Future[Seq[Adoption]] = {
    adoptionDAO.readAll
  }

  def read(adoptionId: String): Future[Adoption] = {
    adoptionDAO.read(adoptionId)
  }

  def delete(adoptionId: String): Future[Int] = {
    adoptionDAO.delete(adoptionId)
  }

  def animalAdopted(animalId: String): Future[Boolean] = {
    adoptionDAO.animalAdopted(animalId)
  }

  def readByUserAndAnimalId(animalId: String, userId: String): Future[Adoption] = {
    adoptionDAO.readByUserAndAnimalId(animalId, userId)
  }

  def animalNotAdopted(animalId: String) = {
    readAll().map(_.map(adoption => adoption.animalId != animalId))
  }

  def adminApprove(adoptionId: String, loggedUserId: String) : Future[Adoption] = {
    val futureAdoption: Future[Adoption] = read(adoptionId)

    adminDAO.adminExists(loggedUserId).flatMap{
      case true => futureAdoption.flatMap { adoption =>
        val result: Future[Adoption] = adoptionDAO.adminApprove(adoption)
        result
      }
      case false => throw new Exception("User is not admin")
    }
  }
}
