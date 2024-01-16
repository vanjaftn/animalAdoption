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
                                emailService: EmailService,
                                smsService: SMSService,
                                userService: UserService,
                                animalService: AnimalService
                             )(implicit ec : ExecutionContext) {

  def create(adoption: Adoption, loggedUserId : String): Future[Adoption] = {
    animalAdopted(adoption.animalId).flatMap {
      case false =>
        val user = userService.read(loggedUserId)
        val animal = animalService.read(adoption.animalId)
        animal.map(a => user.map(u => emailService.sendEmail("animaladoption.sabac@gmail.com", s"New adoption request", s"There has been new request for the adoption of ${a.name}, by ${u.email}.")))

        adoptionDAO.create(adoption, loggedUserId)
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
      case true =>
        val futureAdoption: Future[Adoption] = read(adoptionId)

        val user = futureAdoption.map(adoption => userService.read(adoption.userId))
        val animal = futureAdoption.map(adoption => animalService.read(adoption.animalId))
        animal.map(_.map(a => user.map(_.map(u => smsService.sendSms(u.phoneNumber, s"We regret to inform you that you have been rejected as the adopter for ${a.name}")))))
        animal.map(_.map(a => user.map(_.map(u => emailService.sendEmail(u.email, s"Mail regarding ${a.name}'s adoption", s"We regret to inform you that you have been rejected as the adopter for ${a.name}")))))

        adoptionDAO.deletePending(adoptionId)
      case false => throw new Exception("User is not admin")
    }
  }

  def deleteApproved(adoptionId: String, loggedInUser: String): Future[Int] = {

    vetDAO.vetExists(loggedInUser).flatMap {
      case true =>
        val futureAdoption: Future[Adoption] = read(adoptionId)

        val user = futureAdoption.map(adoption => userService.read(adoption.userId))
        val animal = futureAdoption.map(adoption => animalService.read(adoption.animalId))
        animal.map(_.map(a => user.map(_.map(u => smsService.sendSms(u.phoneNumber, s"We regret to inform you that you have been rejected as the adopter for ${a.name}")))))
        animal.map(_.map(a => user.map(_.map(u => emailService.sendEmail(u.email, s"Mail regarding ${a.name}'s adoption", s"We regret to inform you that you have been rejected as the adopter for ${a.name}")))))

        adoptionDAO.deleteApproved(adoptionId)
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
        val user = futureAdoption.map(adoption => userService.read(adoption.userId))
        val animal = futureAdoption.map(adoption => animalService.read(adoption.animalId))
        animal.map(_.map(a => user.map(_.map(u => smsService.sendSms(u.phoneNumber,s"We're happy to inform you that you have been accepted as the adopter for ${a.name}")))))
        animal.map(_.map(a => user.map(_.map(u => emailService.sendEmail(u.email, s"Mail regarding ${a.name}'s adoption", s"We're happy to inform you that you have been accepted as the adopter for ${a.name}")))))

        adoptionDAO.adminApprove(adoption)
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

        val user = futureAdoption.map(adoption => userService.read(adoption.userId))
        val animal = futureAdoption.map(adoption => animalService.read(adoption.animalId))
        animal.map(_.map(a => user.map(_.map(u => smsService.sendSms(u.phoneNumber, s"You have officially become the adopter of ${a.name}. You can post new photos and videos of ${a.name} for everyone to see!")))))
        animal.map(_.map(a => user.map(_.map(u => emailService.sendEmail(u.email, s"Mail regarding ${a.name}'s adoption", s"You have officially become the adopter of ${a.name}. You can post new photos and videos of ${a.name} for everyone to see!")))))

        result
      }
      case false => throw new Exception("User is not vet")
    }

  }

  def adoptionExists(animalId: String, loggedUserId: String): Future[Boolean] = {
    adoptionDAO.adoptionExists(animalId, loggedUserId)
  }

  def readAllUsersAdoptions(userId: String): Future[Seq[Adoption]] = {
    adoptionDAO.readAllUsersAdoptions(userId)
  }

  def readAllUsersApprovedAdoptions(userId: String): Future[Seq[Adoption]] = {
    adoptionDAO.readAllUsersApprovedAdoptions(userId)
  }

}
