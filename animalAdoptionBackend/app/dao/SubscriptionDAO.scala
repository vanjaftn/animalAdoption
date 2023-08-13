package dao


import model.{Subscription}

import scala.concurrent.{ExecutionContext}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


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


  class SubscriptionsTable(tag: Tag) extends Table[Subscription](tag, "subscriptions") {

    def subscriptionId = column[Option[String]]("SUBSCRIPTIONID", O.PrimaryKey, O.AutoInc)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def * = (subscriptionId, animalId, userId) <> ((Subscription.apply _).tupled, Subscription.unapply)

  }

}
