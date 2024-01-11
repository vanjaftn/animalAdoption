package dto

import play.api.libs.json.{Format, Json}
import org.mindrot.jbcrypt.BCrypt
import play.api.data.Forms.email

import java.util.Date

case class CreateUserDTO(

                 userId : Option[String],
                 email : String,
                 firstName : String,
                 lastName : String,
                 dateOfBirth : Date,
                 phoneNumber : Int,
                 personalId : Int
               )
object CreateUserDTO {
  implicit val format: Format[CreateUserDTO] = Json.format[CreateUserDTO]
}
