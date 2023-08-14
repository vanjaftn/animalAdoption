package service

import dao.{AdoptionDAO, AnimalDAO, SubscriptionDAO}
import model.Animal

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalService @Inject()(animalDAO: AnimalDAO,
                              adoptionDAO: AdoptionDAO,
                              subscriptionDAO: SubscriptionDAO
                          )(implicit ec : ExecutionContext){

  def create(animal: Animal): Future[Animal] = {
    animalDAO.create(animal)
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

}
