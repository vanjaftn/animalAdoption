package dao


import model.Subscription

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import scala.util.Random


class SubscriptionDAO @Inject()(
                        protected val dbConfigProvider: DatabaseConfigProvider
                      )(
                        implicit executionContext: ExecutionContext
                      ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Subscriptions = TableQuery[SubscriptionsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(subscription: Subscription, loggedInUserId : String): Future[Subscription] = {
    val newSubscription = subscription.copy(subscriptionId = Option(Random.alphanumeric.take(16).mkString), userId = loggedInUserId)
    db.run(Subscriptions += newSubscription).map(_ => newSubscription)

  }

  def delete(id: String): Future[Int] = {
    db.run(Subscriptions.filter(_.subscriptionId === id).delete)
  }

  def read(id: String): Future[Subscription] = {
    db.run(Subscriptions.filter(_.subscriptionId === id).result.head)
  }

  def readAll: Future[Seq[Subscription]] = {
    db.run(Subscriptions.result)
  }
  class SubscriptionsTable(tag: Tag) extends Table[Subscription](tag, "subscriptions") {

    def subscriptionId = column[Option[String]]("SUBSCRIPTIONID", O.PrimaryKey, O.AutoInc)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def * = (subscriptionId, animalId, userId) <> ((Subscription.apply _).tupled, Subscription.unapply)

  }

}
