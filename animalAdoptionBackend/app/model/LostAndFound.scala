package model

import play.api.libs.json.{Format, Json}

import java.util.Date

case class LostAndFound(
                     lostAndFoundId : Option[String],
                     animalId : String,
                     userId : String,
                     lostAndFoundDate : Date,
                     lostAndFoundStatus: String,
                     approved: Boolean
                   )
object LostAndFound {
  implicit val format: Format[LostAndFound] = Json.format[LostAndFound]
}
