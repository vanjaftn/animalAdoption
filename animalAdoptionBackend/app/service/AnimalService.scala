package service

import dao.{AdminDAO, AdopterDAO, AdoptionDAO, AnimalDAO, PhotoDAO, SubscriptionDAO, VetDAO, VideoDAO}
import dto.AnimalWithPhotosDTO
import model.{Animal, Photo, User, Video}
import slick.lifted.TableQuery

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalService @Inject()(animalDAO: AnimalDAO,
                              adoptionDAO: AdoptionDAO,
                              vetDAO: VetDAO,
                              subscriptionDAO: SubscriptionDAO,
                              photoDAO: PhotoDAO,
                              adminDAO: AdminDAO,
                              videoDAO: VideoDAO
                          )(implicit ec : ExecutionContext){

  def create(animal: AnimalWithPhotosDTO, loggedInUser: String): Future[Animal] = {
    adminDAO.adminExists(loggedInUser).flatMap {
      case true =>
        val newAnimal: Animal = Animal(Some(UUID.randomUUID().toString), animal.name, animal.gender, animal.dateOfBirth, animal.location, animal.description, animal.chipNumber, animal.size, animal.animalType, animal.sterilized)
        if (animal.photos.nonEmpty) {
          animal.photos.map {
            photo =>
              if (photo.endsWith("mp4")) {
                val newVideo: Video = Video(Some(UUID.randomUUID().toString), newAnimal.animalId.head, photo)
                videoDAO.create(newVideo)
              }
              else {
                val newPhoto: Photo = Photo(Some(UUID.randomUUID().toString), newAnimal.animalId.head, photo)
                photoDAO.create(newPhoto)
              }
          }
        }
        animalDAO.create(newAnimal)
      case false => throw new Exception("User is not admin")
    }

  }

  def readAll(): Future[Seq[Animal]] = {
    animalDAO.readAll
  }

  def read(animalId: String): Future[Animal] = {
    animalDAO.read(animalId)
  }

  def update(animal: AnimalWithPhotosDTO, loggedInUser: String): Future[Animal] = {
    adminDAO.adminExists(loggedInUser).flatMap {
      case true =>
        val newAnimal: Animal = Animal(animal.animalId, animal.name, animal.gender, animal.dateOfBirth, animal.location, animal.description, animal.chipNumber, animal.size, animal.animalType, animal.sterilized)
        if (animal.photos.nonEmpty) {
          animal.photos.map {
            photo =>
              if(photo.endsWith("mp4")){
                val newVideo: Video = Video(Some(UUID.randomUUID().toString), newAnimal.animalId.head, photo)
                videoDAO.create(newVideo)
              }
              else{
                val newPhoto: Photo = Photo(Some(UUID.randomUUID().toString), newAnimal.animalId.head, photo)
                photoDAO.create(newPhoto)
              }
          }
        }
        animalDAO.update(newAnimal)
      case false => throw new Exception("User is not admin")
    }  }

  def delete(animalId: String, loggedInUser: String): Future[Int] = {
    adminDAO.adminExists(loggedInUser).flatMap {
      case true =>
        animalDAO.delete(animalId)
      case false => throw new Exception("User is not admin")
    }
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

  def search(searchInput: String, animals: Seq[Animal]): Future[Seq[Animal]] = {
    animalDAO.search(searchInput, animals)
  }


}
