package model

import play.api.libs.json.{Format, Json}

case class Subscription(

                 subscriptionId : Option[String],
                 animalId : String,
                 userId : String

               )
object Subscription {
  implicit val format: Format[Subscription] = Json.format[Subscription]
}
