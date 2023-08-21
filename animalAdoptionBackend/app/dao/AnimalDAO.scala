package dao

import model.Animal

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import scala.util.Random


class AnimalDAO @Inject()(
                         adoptionDAO: AdoptionDAO,
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Animals = TableQuery[AnimalsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
  )

  implicit val seqStringMapper: BaseColumnType[Seq[String]] =
    MappedColumnType.base[Seq[String], String](
      seq => seq.mkString(","), // Convert Seq[String] to String
      str => str.split(",").toSeq // Convert String to Seq[String]
    )

  def create(animal: Animal): Future[Animal] = {
//    val newAnimal = animal.copy(animalId = Some(UUID.randomUUID().toString))
    db.run(Animals += animal).map(_ => animal)

  }

  def delete(id: String): Future[Int] = {
    db.run(Animals.filter(_.animalId === id).delete)
  }

  def read(id: String): Future[Animal] = {
    db.run(Animals.filter(animal => animal.animalId === id).result.head)
  }

  def readAll: Future[Seq[Animal]] = {
    db.run(Animals.sortBy(_.dateOfBirth).result)
  }

  def update(animal: Animal): Future[Animal] = {
    db.run(Animals.filter(_.animalId === animal.animalId).map(_.description).update(animal.description))
      .map(res => animal)
  }

//  def addNewPhotos(animal: Animal): Future[Animal] = {
//    db.run(Animals.filter(_.animalId === animal.animalId).map(_.photoURLs).update(animal.photoURLs))
//      .map(res => animal)
//  }

  def animalIsSterilized(animal: Animal): Future[Animal] = {
    db.run(Animals.filter(a => a.animalId === animal.animalId).map(_.sterilized).update(true))
      .map(res => animal)
  }

  def animalSterilized(animalId: String): Future[Boolean] = {
    db.run(Animals.filter(animal => (animal.animalId === animalId) && animal.sterilized === true).exists.result)
  }

  def search(searchInput: String): Future[Seq[Animal]] = {
    db.run(Animals.filter(animal => animal.name.like(s"%${searchInput}%") || animal.location.like(s"%${searchInput}%") ).result)
  }

  class AnimalsTable(tag: Tag) extends Table[Animal](tag, "animals") {
    def animalId = column[Option[String]]("ANIMALID", O.PrimaryKey)

    def name = column[String]("NAME")

    def dateOfBirth = column[Date]("DATEOFBIRTH")

    def location = column[String]("LOCATION")

    def description = column[String]("DESCRIPTION")
    def chipNumber = column[Int]("CHIPNUMBER")
    def size = column[String]("SIZE")
    def animalType = column[String]("ANIMALTYPE")
    def sterilized = column[Boolean]("STERILIZED")


    def * = (animalId, name, dateOfBirth, location, description, chipNumber, size, animalType, sterilized) <> ((Animal.apply _).tupled, Animal.unapply)
  }
}
