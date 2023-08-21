package service

import dao.{AnimalTypeDAO}
import model.{AnimalType}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalTypeService @Inject()(animalTypeDAO: AnimalTypeDAO,
                            )(implicit ec : ExecutionContext){

  def create(animalType: AnimalType): Future[AnimalType] = {
    animalTypeDAO.create(animalType)
  }

  def readAll(): Future[Seq[AnimalType]] = {
    animalTypeDAO.readAll
  }

  def delete(animalTypeId: String): Future[Int] = {
    animalTypeDAO.delete(animalTypeId)
  }

  def animalTypeExists(animalType: String): Future[Boolean] = {
    animalTypeDAO.animalTypeExists(animalType)
  }


}
