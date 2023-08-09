package dto
import model.User
import play.api.libs.json.{Format, Json}

case class LoginUserDTO(
                          email: String,
                          password : String,
                        )

object LoginUserDTO {
  implicit def userToLoggedUserDTO(user: User): LoginUserDTO = LoginUserDTO(user.email, user.password)

  implicit val format: Format[LoginUserDTO] = Json.format[LoginUserDTO]
}
