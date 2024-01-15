package dto

import play.api.libs.json.{Format, Json}
import java.util.Date

case class AnimalWithPhotosDTO(

                   animalId : Option[String],
                   name : String,
                   gender : String,
                   dateOfBirth : Date,
                   location : String,
                   description : String,
                   chipNumber : String,
                   size : String,
                   animalType : String,
                   sterilized : Boolean,
                   photos : Seq[String]

                 )
object AnimalWithPhotosDTO {
  implicit val format: Format[AnimalWithPhotosDTO] = Json.format[AnimalWithPhotosDTO]
}
