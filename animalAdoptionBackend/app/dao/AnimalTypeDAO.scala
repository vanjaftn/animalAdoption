package dao

import model.{AnimalType}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class AnimalTypeDAO @Inject()(
                            protected val dbConfigProvider: DatabaseConfigProvider
                          )(
                            implicit executionContext: ExecutionContext
                          ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val AnimalTypes = TableQuery[AnimalTypesTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(animalType: AnimalType): Future[AnimalType] = {
    val newAnimalTypeId = UUID.randomUUID().toString
    val newAnimalType = animalType.copy(animalTypeId = Some(newAnimalTypeId))
    db.run(AnimalTypes += newAnimalType).map(_ => newAnimalType)

  }

  def readAll: Future[Seq[AnimalType]] = {
    db.run(AnimalTypes.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(AnimalTypes.filter(_.animalTypeId === id).delete)
  }

  def animalTypeExists(animalType: String): Future[Boolean] = {
    db.run(AnimalTypes.filter(_.animalType === animalType).exists.result)
  }

  class AnimalTypesTable(tag: Tag) extends Table[AnimalType](tag, "animalTypes") {

    def animalTypeId = column[Option[String]]("ANIMALTYPEID", O.PrimaryKey)

    def animalType = column[String]("ANIMALTYPE")


    def * = (animalTypeId, animalType) <> ((AnimalType.apply _).tupled, AnimalType.unapply)

  }


}
