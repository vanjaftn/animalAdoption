package model

import play.api.libs.json.{Format, Json}
import java.util.Date

case class Dog(

                 dogId : Option[String],
                 name : String,
                 dateOfBirth : Date,
                 location : String,
                 photoURLs : String,
                 description : String

               )
object Dog {
  implicit val format: Format[Dog] = Json.format[Dog]
}
