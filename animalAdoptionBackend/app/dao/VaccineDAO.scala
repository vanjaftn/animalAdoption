package dao


import model.{Vaccine}

import scala.concurrent.{ExecutionContext}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


class VaccineDAO @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Vaccines = TableQuery[VaccinesTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )


  class VaccinesTable(tag: Tag) extends Table[Vaccine](tag, "vaccines") {

    def vaccineId = column[Option[String]]("VACCINEID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")

    def vetId = column[String]("VETID")
    def vaccineType = column[String]("VACCINETYPE")

    def vaccineDate = column[Date]("VACCINEDATE")

    def * = (vaccineId, vaccineType, animalId, vetId, vaccineDate) <> ((Vaccine.apply _).tupled, Vaccine.unapply)

  }

}
