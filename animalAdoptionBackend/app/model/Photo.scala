package model

import play.api.libs.json.{Format, Json}
import java.util.Date

case class Photo(

                   photoId: Option[String],
                   animalId: String,
                   photoURL: String

                 )
object Photo {
  implicit val format: Format[Photo] = Json.format[Photo]
}
