package model

import play.api.libs.json.{Format, Json}
case class Admin(

                 adminId : Option[String],
                 userId : String
               )
object Admin {
  implicit val format: Format[Admin] = Json.format[Admin]

}
