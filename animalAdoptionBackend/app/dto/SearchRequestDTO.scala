package dto
import model.{Animal}
import play.api.libs.json.{Format, Json}

case class SearchRequestDTO(
                         searchInput: String,
                         animals : Seq[Animal],
                       )

object SearchRequestDTO {

  implicit val format: Format[SearchRequestDTO] = Json.format[SearchRequestDTO]
}
