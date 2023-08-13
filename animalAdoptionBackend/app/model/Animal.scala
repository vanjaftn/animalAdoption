package model

import play.api.libs.json.{Format, Json}
import java.util.Date

case class Animal(

                 animalId : Option[String],
                 name : String,
                 dateOfBirth : Date,
                 location : String,
                 photoURLs : String,
                 description : String,
                 chipNumber : Int,
                 size : String,
                 animalTypeId : String,
                 sterilized : Boolean

               )
object Animal {
  implicit val format: Format[Animal] = Json.format[Animal]
}
