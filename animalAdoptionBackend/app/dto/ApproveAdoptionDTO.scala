package dto
import model.User
import play.api.libs.json.{Format, Json}

case class ApproveAdoptionDTO(
                         animalId: String,
                         userId : String,
                       )

object ApproveAdoptionDTO {

  implicit val format: Format[ApproveAdoptionDTO] = Json.format[ApproveAdoptionDTO]
}
