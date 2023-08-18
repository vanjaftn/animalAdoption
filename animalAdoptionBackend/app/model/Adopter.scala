package model

import play.api.libs.json.{Format, Json}
case class Adopter(
                adopterId : Option[String],
                userId : String
              )
object Adopter {
  implicit val format: Format[Adopter] = Json.format[Adopter]

}
