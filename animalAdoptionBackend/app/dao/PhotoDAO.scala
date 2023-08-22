package dao

import model.{Admin, Photo, Vet}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class PhotoDAO @Inject()(
                        protected val dbConfigProvider: DatabaseConfigProvider
                      )(
                        implicit executionContext: ExecutionContext
                      ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Photos = TableQuery[PhotosTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(photo: Photo): Future[Photo] = {
    db.run(Photos += photo).map(_ => photo)
  }

  def read(id: String): Future[Photo] = {
    db.run(Photos.filter(_.photoId === id).result.head)
  }

  def readAllAnimalPhotos(id: String): Future[Seq[Photo]] = {
    db.run(Photos.filter(_.animalId === id).result)
  }

  def readAll: Future[Seq[Photo]] = {
    db.run(Photos.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Photos.filter(_.photoId === id).delete)
  }

  class PhotosTable(tag: Tag) extends Table[Photo](tag, "photos") {

    def photoId = column[Option[String]]("PHOTOID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")
    def photoURL = column[String]("PHOTOURL")


    def * = (photoId, animalId, photoURL) <> ((Photo.apply _).tupled, Photo.unapply)

  }


}
