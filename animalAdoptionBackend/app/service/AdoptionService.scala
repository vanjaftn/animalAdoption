package service

import dao.{AdminDAO, AdopterDAO, AdoptionDAO, AnimalDAO, VetDAO}
import model.{Adopter, Adoption}

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdoptionService @Inject()(adoptionDAO: AdoptionDAO,
                                vetDAO: VetDAO,
                                  adminDAO: AdminDAO,
                                adopterDAO: AdopterDAO,
                             )(implicit ec : ExecutionContext) {

  def create(adoption: Adoption, loggedUserId : String): Future[Adoption] = {

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

  def deletePending(adoptionId: String, loggedInUser: String): Future[Int] = {

    adminDAO.adminExists(loggedInUser).flatMap {
      case true => adoptionDAO.deletePending(adoptionId)
      case false => throw new Exception("User is not admin")
    }
  }

  def deleteApproved(adoptionId: String, loggedInUser: String): Future[Int] = {

    vetDAO.vetExists(loggedInUser).flatMap {
      case true => adoptionDAO.deleteApproved(adoptionId)
      case false => throw new Exception("User is not vet")
    }
  }

  def animalAdopted(animalId: String): Future[Boolean] = {
    adoptionDAO.animalAdopted(animalId)
  }

  def animalAdminApproved(animalId: String): Future[Boolean] = {
    adoptionDAO.animalAdminApproved(animalId)
  }

  def readByUserAndAnimalId(animalId: String, userId: String): Future[Adoption] = {
    adoptionDAO.readByUserAndAnimalId(animalId, userId)
  }

  def readAllApprovedAdoptions(): Future[Seq[Adoption]] = {
    adoptionDAO.readAllApprovedAdoptions
  }

  def adminApprove(adoptionId: String, loggedInUser: String) : Future[Adoption] = {
    val futureAdoption: Future[Adoption] = read(adoptionId)

    adminDAO.adminExists(loggedInUser).flatMap{
      case true => futureAdoption.flatMap { adoption =>
        val result: Future[Adoption] = adoptionDAO.adminApprove(adoption)
        result
      }
      case false => throw new Exception("User is not admin")
    }
  }

  def vetApprove(adoptionId: String, loggedInUser: String): Future[Adoption] = {
    val futureAdoption: Future[Adoption] = read(adoptionId)

    vetDAO.vetExists(loggedInUser).flatMap {
      case true => futureAdoption.flatMap { adoption =>
        val result: Future[Adoption] = adoptionDAO.vetApprove(adoption)
        val adopter = new Adopter(Some(UUID.randomUUID().toString), adoption.userId)
        adopterDAO.create(adopter)

        adoptionDAO.readAllAnimalAdminApprovedAdoptions(adoption.animalId).map(_.map { adoption =>
          adoptionDAO.delete(adoption.adoptionId.head)
        })

        result
      }
      case false => throw new Exception("User is not vet")
    }

  }

  def adoptionExists(animalId: String, loggedUserId: String): Future[Boolean] = {
    adoptionDAO.adoptionExists(animalId, loggedUserId)
  }

}
