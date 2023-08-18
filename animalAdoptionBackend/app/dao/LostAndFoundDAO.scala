package dao


import model.{LostAndFound}

import scala.concurrent.{ExecutionContext}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


class LostAndFoundDAO @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val LostAndFounds = TableQuery[LostAndFoundsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )


  class LostAndFoundsTable(tag: Tag) extends Table[LostAndFound](tag, "lostAndFounds") {

    def lostAndFoundId = column[Option[String]]("LOSTANDFOUNDID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def lostAndFoundDate = column[Date]("LOSTANDFOUNDDATE")
    def lostAndFoundStatus = column[String]("LOSTANDFOUNDSTATUS")

    def * = (lostAndFoundId, animalId, userId, lostAndFoundDate, lostAndFoundStatus) <> ((LostAndFound.apply _).tupled, LostAndFound.unapply)

  }

}
