package model

import play.api.libs.json.{Format, Json}

import java.util.Date

case class Adoption(

                        adoptionId : Option[String],
                         dogId : String,
                         userId : String,
                        adoptionDate : Date

                       )
object Adoption {
  implicit val format: Format[Adoption] = Json.format[Adoption]
}
