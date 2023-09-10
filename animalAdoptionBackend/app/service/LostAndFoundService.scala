package service


import dao.{AdminDAO, AnimalDAO, LostAndFoundDAO, PhotoDAO, VideoDAO}
import dto.{AnimalWithPhotosDTO, CreateLostAndFoundDTO}
import model.{Animal, LostAndFound, Photo, Video}

import java.util.{Date, UUID}
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LostAndFoundService @Inject()(lostAndFoundDAO: LostAndFoundDAO,
                           adminDAO: AdminDAO,
                          animalDAO: AnimalDAO,
                                    photoDAO: PhotoDAO,
                                    videoDAO: VideoDAO
                          )(implicit ec : ExecutionContext){

      def createLost(lostAndFound: CreateLostAndFoundDTO, loggedUserId: String): Future[LostAndFound] = {

        val newAnimal: Animal = Animal(Some(UUID.randomUUID().toString), lostAndFound.name, lostAndFound.gender, new Date(), lostAndFound.location, lostAndFound.description, 0, lostAndFound.size, lostAndFound.animalType, lostAndFound.sterilized)
        if (lostAndFound.photos.nonEmpty) {
          lostAndFound.photos.map {
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

          val animal = animalDAO.create(newAnimal)

          animal.flatMap { newLostAndFound =>
            val createLostAndFound: LostAndFound = new LostAndFound(Some(UUID.randomUUID().toString), newLostAndFound.animalId.head, loggedUserId, new Date(), "LOST", false)
            lostAndFoundDAO.create(createLostAndFound)
          }
        } else {
          val animal = animalDAO.create(newAnimal)

          animal.flatMap { newLostAndFound =>
            val createLostAndFound: LostAndFound = new LostAndFound(Some(UUID.randomUUID().toString), newLostAndFound.animalId.head, loggedUserId, new Date(), "FOUND", false)
            lostAndFoundDAO.create(createLostAndFound)
          }
        }
      }

    def createFound(lostAndFound: CreateLostAndFoundDTO, loggedUserId: String): Future[LostAndFound] = {

      val newAnimal: Animal = Animal(Some(UUID.randomUUID().toString), lostAndFound.name, lostAndFound.gender, new Date(), lostAndFound.location, lostAndFound.description, 0, lostAndFound.size, lostAndFound.animalType, lostAndFound.sterilized)
      if (lostAndFound.photos.nonEmpty) {
        lostAndFound.photos.map {
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

        val animal = animalDAO.create(newAnimal)

        animal.flatMap { newLostAndFound =>
          val createLostAndFound: LostAndFound = new LostAndFound(Some(UUID.randomUUID().toString), newLostAndFound.animalId.head, loggedUserId, new Date(), "FOUND", false)
          lostAndFoundDAO.create(createLostAndFound)
        }
      } else {
        val animal = animalDAO.create(newAnimal)

        animal.flatMap { newLostAndFound =>
          val createLostAndFound: LostAndFound = new LostAndFound(Some(UUID.randomUUID().toString), newLostAndFound.animalId.head, loggedUserId, new Date(), "FOUND", false)
          lostAndFoundDAO.create(createLostAndFound)
        }
      }
    }

    def delete(id: String): Future[Int] = {
      lostAndFoundDAO.delete(id)
    }
    def readAll(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAll
    }

    def readAllApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllApproved
    }

    def readAllLostApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllLostApproved
    }

    def readAllFoundApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllFoundApproved
    }

    def readAllNotApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllNotApproved
    }

    def readAllLost(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllLost
    }

    def readAllFound(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllFound
    }

    def readAllFoundNotApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllFoundNotApproved
    }

    def readAllLostNotApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllLostNotApproved
    }

    def read(id: String): Future[LostAndFound] = {
      lostAndFoundDAO.read(id)
    }

    def readByAnimalId(animalId: String): Future[LostAndFound] = {
      lostAndFoundDAO.readByAnimalId(animalId)
    }

    def lostAndFoundExists(animalId: String): Future[Boolean] = {
      lostAndFoundDAO.lostAndFoundExists(animalId)
    }

    def adminApproveLAF(lostAndFound: LostAndFound, loggedInUser: String): Future[LostAndFound] = {
      adminDAO.adminExists(loggedInUser).flatMap {
        case true => lostAndFoundDAO.approve(lostAndFound)
        case false => throw new Exception("User is not admin")
      }

    }
}
