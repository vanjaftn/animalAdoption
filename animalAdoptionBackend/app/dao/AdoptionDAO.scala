package dao


import model.{Adoption}

import scala.concurrent.{ExecutionContext}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


class AdoptionDAO @Inject()(
                                 protected val dbConfigProvider: DatabaseConfigProvider
                               )(
                                 implicit executionContext: ExecutionContext
                               ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Adoptions = TableQuery[AdoptionsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )


  class AdoptionsTable(tag: Tag) extends Table[Adoption](tag, "adoptions") {

    def adoptionId = column[Option[String]]("ADOPTIONID", O.PrimaryKey, O.AutoInc)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def adoptionDate = column[Date]("ADOPTIONDATE")
    def adoptionStatus = column[String]("ADOPTIONSTATUS")

    def * = (adoptionId, animalId, userId, adoptionDate, adoptionStatus) <> ((Adoption.apply _).tupled, Adoption.unapply)

  }

}
