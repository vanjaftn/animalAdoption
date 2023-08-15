package service

import dao.SubscriptionDAO
import model.{Subscription}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SubscriptionService @Inject()(subscriptionDAO: SubscriptionDAO,
                               )(implicit ec : ExecutionContext){

  def create(subscription: Subscription, loggedInUserId: String): Future[Subscription] = {

    subscriptionDAO.subscriptionExists(subscription.animalId, loggedInUserId).flatMap {
      case false => subscriptionDAO.create(subscription, loggedInUserId)
      case true => throw new Exception("Subscription already exists")
    }
  }

  def subscriptionExists(animalId: String, userId: String): Future[Boolean] = {
    subscriptionDAO.subscriptionExists(animalId, userId)
  }

  def readSubscriptionByAnimalAndUserId(animalId: String, userId: String): Future[Subscription] = {
    subscriptionDAO.readSubscriptionByAnimalAndUserId(animalId, userId)
  }
  def readAll(): Future[Seq[Subscription]] = {
    subscriptionDAO.readAll
  }

  def read(subscriptionId: String): Future[Subscription] = {
    subscriptionDAO.read(subscriptionId)
  }

  def delete(subscriptionId: String): Future[Int] = {
    subscriptionDAO.delete(subscriptionId)
  }



}
