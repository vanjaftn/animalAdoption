package model

import play.api.libs.json.{Format, Json}
case class AnimalType(
                   animalTypeId : Option[String],
                   animalType : String
                  )
object AnimalType {
  implicit val format: Format[AnimalType] = Json.format[AnimalType]

}
