package service

import dao.{AdoptionDAO, AnimalDAO}
import model.Adoption

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdoptionService @Inject()(adoptionDAO: AdoptionDAO,
                                animalDAO : AnimalDAO
                             )(implicit ec : ExecutionContext){

  def create(adoption: Adoption): Future[Adoption] = {
    adoptionDAO.create(adoption)
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

  def animalAdopted(animalId : String) : Future[Option[Adoption]] = {
    adoptionDAO.animalAdopted(animalId)
  }

  def animalNotAdopted(animalId : String) = {
    readAll().map(_.map(adoption => adoption.animalId != animalId))
  }

}
