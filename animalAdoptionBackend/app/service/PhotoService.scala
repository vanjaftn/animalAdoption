package service

import dao.{AdoptionDAO, PhotoDAO}
import model.Photo

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PhotoService @Inject()(photoDAO: PhotoDAO,
                             adoptionDAO: AdoptionDAO
                              )(implicit ec : ExecutionContext){

  def create(photo: Photo): Future[Photo] = {
    photoDAO.create(photo)
  }

  def readAll(): Future[Seq[Photo]] = {
    photoDAO.readAll
  }

  def readAllAnimalPhotos(animalId: String): Future[Seq[Photo]] = {
    photoDAO.readAllAnimalPhotos(animalId)
  }
  def delete(id: String): Future[Int] = {
    photoDAO.delete(id)
  }

  def adopterAddPhotos(photo: Photo, loggedInUser: String) = {
    adoptionDAO.approvedAdoptionExists(photo.animalId, loggedInUser).flatMap {
      case true =>
        create(photo)
      case false => throw new Exception("User is not adopter")
    }
  }

}

