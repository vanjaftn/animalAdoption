package service

import dao.{AdopterDAO, AdoptionDAO, AnimalDAO, PhotoDAO, SubscriptionDAO, VetDAO}
import dto.AnimalWithPhotosDTO
import model.{Animal, Photo, User}

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalService @Inject()(animalDAO: AnimalDAO,
                              adoptionDAO: AdoptionDAO,
                              vetDAO: VetDAO,
                              subscriptionDAO: SubscriptionDAO,
                              photoDAO: PhotoDAO
                          )(implicit ec : ExecutionContext){

  def create(animal: AnimalWithPhotosDTO): Future[Animal] = {
    val newAnimal : Animal = Animal(Some(UUID.randomUUID().toString), animal.name, animal.dateOfBirth, animal.location, animal.description, animal.chipNumber, animal.size, animal.animalTypeId, animal.sterilized)
    if (animal.photos.nonEmpty) {
      animal.photos.map {
        photo =>
          val newPhoto: Photo = Photo(Some(""), newAnimal.animalId.head, photo)
          photoDAO.create(newPhoto)
      }
    }
    animalDAO.create(newAnimal)
  }

  def readAll(): Future[Seq[Animal]] = {
    animalDAO.readAll
  }

  def read(animalId: String): Future[Animal] = {
    animalDAO.read(animalId)
  }

  def update(animal: Animal): Future[Animal] = {
    animalDAO.update(animal)
  }

  def delete(animalId: String): Future[Int] = {
    animalDAO.delete(animalId)
  }

  def readAllAdoptedAnimals : Future[Seq[Animal]] = {
      adoptionDAO.readAllApprovedAdoptions.map(_.map(adoption => read(adoption.animalId))).flatMap(animals => Future.sequence(animals))
  }

  def readAllUsersSubscribedAnimals(userId : String): Future[Seq[Animal]] = {
    subscriptionDAO.readAllUsersSubscriptions(userId).map(_.map(subscription => read(subscription.animalId))).flatMap(animals => Future.sequence(animals))
  }

  def animalIsSterilized(animal: Animal, loggedInUser: String): Future[Animal] = {
    vetDAO.vetExists(loggedInUser).flatMap {
      case true => animalDAO.animalSterilized(animal.animalId.head).flatMap {
        case true => throw new Exception("Animal is already sterilized")
        case false => animalDAO.animalIsSterilized(animal)
      }
      case false => throw new Exception("User is not vet")
    }
  }

  def animalSterilized(animalId: String): Future[Boolean] = {
    animalDAO.animalSterilized(animalId)
  }

  def readAllUnadoptedAnimals(): Future[Seq[Animal]] = {

    for {
      allAnimals <- readAll()
      adoptedAnimalIds <- adoptionDAO.readAllAdoptedAnimalIds()
    } yield {
      // Filter out animals whose IDs are in the list of adopted animal IDs
      allAnimals.filterNot(animal => adoptedAnimalIds.contains(animal.animalId.head)).sortBy(_.dateOfBirth)
    }
  }

//  def addNewPhoto(animal: Animal, loggedInUser: String): Future[Animal] = {
//    adopterDAO.adopterExists(loggedInUser).flatMap {
//      case true => animalDAO.addNewPhotos(animal)
//      case false => throw new Exception("User is not adopter")
//    }
//  }

  def search(searchInput: String): Future[Seq[Animal]] = {
    animalDAO.search(searchInput)
  }
}
