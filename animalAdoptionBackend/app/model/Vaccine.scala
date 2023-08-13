package model

import play.api.libs.json.{Format, Json}
import org.mindrot.jbcrypt.BCrypt

import java.util.Date

case class Vaccine(

                 vaccineId : Option[String],
                 vaccineType : String,
                 animalId : String,
                 vetId : String,
                 vaccineDate : Date,

               )
object Vaccine {
  implicit val format: Format[Vaccine] = Json.format[Vaccine]


}
