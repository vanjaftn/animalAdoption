package dto

import play.api.libs.json.{Format, Json}

case class CreateLostAndFoundDTO (
                                   animalId: Option[String],
                                   name: String,
                                   gender: String,
                                   location: String,
                                   description: String,
                                   size: String,
                                   animalType: String,
                                   sterilized: Boolean,
                                   photos: Seq[String]
                                 )
object CreateLostAndFoundDTO {
  implicit val format: Format[CreateLostAndFoundDTO] = Json.format[CreateLostAndFoundDTO]
}
