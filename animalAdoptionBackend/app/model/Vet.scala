package model

import play.api.libs.json.{Format, Json}
case class Vet(

                  vetId : Option[String],
                  userId : String
                )
object Vet {
  implicit val format: Format[Vet] = Json.format[Vet]

}
