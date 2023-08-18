package dao

import model.{Admin, Vet}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class VetDAO @Inject()(
                        protected val dbConfigProvider: DatabaseConfigProvider
                      )(
                        implicit executionContext: ExecutionContext
                      ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Vets = TableQuery[VetsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(vet: Vet): Future[Vet] = {
    val newVet = vet.copy(vetId = Some(UUID.randomUUID().toString))
    db.run(Vets += newVet).map(_ => newVet)

  }

  def read(id: String): Future[Vet] = {
    db.run(Vets.filter(vet => vet.vetId === id).result.head)
  }

  def readAll: Future[Seq[Vet]] = {
    db.run(Vets.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Vets.filter(_.vetId === id).delete)
  }

  class VetsTable(tag: Tag) extends Table[Vet](tag, "vets") {

    def vetId = column[Option[String]]("VETID", O.PrimaryKey)

    def userId = column[String]("USERID")


    def * = (vetId, userId) <> ((Vet.apply _).tupled, Vet.unapply)

  }


}
