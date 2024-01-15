package dto

import play.api.libs.json.{Format, Json}
import org.mindrot.jbcrypt.BCrypt
import java.util.Date

case class CreateUserDTO(

                 userId : Option[String],
                 email : String,
                 password : String,
                 firstName : String,
                 lastName : String,
                 dateOfBirth : Date,
                 phoneNumber : String,
                 personalId : String,
                 confirmationCode: String
               )

object CreateUserDTO {
  implicit val format: Format[CreateUserDTO] = Json.format[CreateUserDTO]

  implicit def hashPassword(password: String) = BCrypt.hashpw(password, "")

}
