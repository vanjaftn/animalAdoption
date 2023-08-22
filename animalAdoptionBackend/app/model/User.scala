package model

import play.api.libs.json.{Format, Json}
import org.mindrot.jbcrypt.BCrypt
import play.api.data.Forms.email

import java.util.Date

case class User(

                 userId : Option[String],
                 email : String,
                 password : String,
                 firstName : String,
                 lastName : String,
                 dateOfBirth : Date,

               )
object User {
  implicit val format: Format[User] = Json.format[User]

  implicit def hashPassword(password: String) = BCrypt.hashpw(password, "")

}
