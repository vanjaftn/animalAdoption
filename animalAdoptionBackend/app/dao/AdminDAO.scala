package dao


import model.{Admin}

import scala.concurrent.{ExecutionContext}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date


class AdminDAO @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Admins = TableQuery[AdminsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )


  class AdminsTable(tag: Tag) extends Table[Admin](tag, "admins") {

    def adminId = column[Option[String]]("ADMINID", O.PrimaryKey, O.AutoInc)

    def userId = column[String]("USERID")


    def * = (adminId, userId) <> ((Admin.apply _).tupled, Admin.unapply)

  }

}
