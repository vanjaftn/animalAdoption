package service

import dao.PhotoDAO
import model.Photo

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PhotoService @Inject()(photoDAO: PhotoDAO
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
  def delete(vetId: String): Future[Int] = {
    photoDAO.delete(vetId)
  }

}

