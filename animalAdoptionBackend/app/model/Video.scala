package model

import play.api.libs.json.{Format, Json}
case class Video(

                  videoId: Option[String],
                  animalId: String,
                  videoURL: String

                )
object Video {
  implicit val format: Format[Video] = Json.format[Video]
}
