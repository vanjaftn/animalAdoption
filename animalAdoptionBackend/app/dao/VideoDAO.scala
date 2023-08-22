package dao

import model.{Video}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.{Date, UUID}
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class VideoDAO @Inject()(
                          protected val dbConfigProvider: DatabaseConfigProvider
                        )(
                          implicit executionContext: ExecutionContext
                        ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Videos = TableQuery[VideosTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(video: Video): Future[Video] = {
    db.run(Videos += video).map(_ => video)
  }

  def read(id: String): Future[Video] = {
    db.run(Videos.filter(_.videoId === id).result.head)
  }

  def readAllAnimalVideos(animalId: String): Future[Seq[Video]] = {
    db.run(Videos.filter(_.animalId === animalId).result)
  }

  def readAll: Future[Seq[Video]] = {
    db.run(Videos.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Videos.filter(_.videoId === id).delete)
  }

  class VideosTable(tag: Tag) extends Table[Video](tag, "videos") {

    def videoId = column[Option[String]]("VIDEOID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")
    def videoURL = column[String]("VIDEOURL")


    def * = (videoId, animalId, videoURL) <> ((Video.apply _).tupled, Video.unapply)

  }


}
