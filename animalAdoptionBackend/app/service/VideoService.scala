package service

import dao.{AdoptionDAO, VideoDAO}
import model.Video

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VideoService @Inject()(videoDAO: VideoDAO,
                             adoptionDAO: AdoptionDAO
                            )(implicit ec : ExecutionContext){

  def create(video: Video): Future[Video] = {
    videoDAO.create(video)
  }

  def readAll(): Future[Seq[Video]] = {
    videoDAO.readAll
  }

  def readAllAnimalVideos(animalId: String): Future[Seq[Video]] = {
    videoDAO.readAllAnimalVideos(animalId)
  }
  def delete(videoId: String): Future[Int] = {
    videoDAO.delete(videoId)
  }

  def adopterAddVideos(video: Video, loggedInUser: String) = {
    adoptionDAO.approvedAdoptionExists(video.animalId, loggedInUser).flatMap {
      case true =>
        create(video)
      case false => throw new Exception("User is not adopter")
    }
  }

}

