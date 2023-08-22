package service

import dao.{AdminDAO, AnimalTypeDAO}
import model.AnimalType

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalTypeService @Inject()(animalTypeDAO: AnimalTypeDAO,
                                  adminDAO: AdminDAO
                            )(implicit ec : ExecutionContext){

  def create(animalType: AnimalType, loggedInUser: String): Future[AnimalType] = {

    adminDAO.adminExists(loggedInUser).flatMap{
      case true => animalTypeDAO.create(animalType)
      case false => throw new Exception("User is not admin")
    }

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
