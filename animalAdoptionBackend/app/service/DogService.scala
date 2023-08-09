package service

import dao.DogDAO
import model.Dog

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DogService @Inject()(dogDAO: DogDAO
                          )(implicit ec : ExecutionContext){

  def create(dog: Dog): Future[Dog] = {
    dogDAO.create(dog)
  }

  def readAll(): Future[Seq[Dog]] = {
    dogDAO.readAll
  }

  def read(dogId: String): Future[Dog] = {
    dogDAO.read(dogId)
  }

  def update(dog: Dog): Future[Dog] = {
    dogDAO.update(dog)
  }

  def delete(dogId: String): Future[Int] = {
    dogDAO.delete(dogId)
  }
}
