package service

import dao.SubscriptionDAO
import model.{Subscription}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SubscriptionService @Inject()(subscriptionDAO: SubscriptionDAO,
                               )(implicit ec : ExecutionContext){

  def create(subscription: Subscription, loggedInUserId: String): Future[Subscription] = {

    subscriptionDAO.create(subscription, loggedInUserId)
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
