package dao

import model.Dog

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import scala.util.Random


class DogDAO @Inject()(
                         protected val dbConfigProvider: DatabaseConfigProvider
                       )(
                         implicit executionContext: ExecutionContext
                       ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Dogs = TableQuery[DogsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
  )

  def create(dog: Dog): Future[Dog] = {
    val newDogId =  Option(Random.alphanumeric.take(16).mkString)
    val newDog = dog.copy(dogId = newDogId)
    db.run(Dogs += dog.copy(dogId =  Option(Random.alphanumeric.take(16).mkString))).map(_ => newDog)

  }

  def delete(id: String): Future[Int] = {
    db.run(Dogs.filter(_.dogId === id).delete)
  }

  def read(id: String): Future[Dog] = {
    db.run(Dogs.filter(_.dogId === id).result.head)
  }

  def readAll: Future[Seq[Dog]] = {
    db.run(Dogs.result)
  }

  def update(dog: Dog): Future[Dog] = {
    db.run(Dogs.filter(_.dogId === dog.dogId).map(_.description).update(dog.description))
      .map(res => dog)
  }

  class DogsTable(tag: Tag) extends Table[Dog](tag, "dogs") {
    def dogId = column[Option[String]]("DOGID", O.PrimaryKey, O.AutoInc)

    def name = column[String]("NAME")

    def dateOfBirth = column[Date]("DATEOFBIRTH")

    def location = column[String]("LOCATION")

    def photoURLs = column[String]("PHOTOURLS")

    def description = column[String]("DESCRIPTION")


    def * = (dogId, name, dateOfBirth, location, photoURLs, description) <> ((Dog.apply _).tupled, Dog.unapply)
  }
}
