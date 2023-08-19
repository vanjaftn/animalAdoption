package service


import dao.{AdminDAO, AnimalDAO, LostAndFoundDAO}
import model.{Animal, LostAndFound}

import java.util.Date
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LostAndFoundService @Inject()(lostAndFoundDAO: LostAndFoundDAO,
                           adminDAO: AdminDAO,
                          animalDAO: AnimalDAO
                          )(implicit ec : ExecutionContext){

    def createLost(lostAndFound: Animal, loggedUserId: String): Future[LostAndFound] = {
      val animal = animalDAO.create(lostAndFound)

      animal.flatMap { newLostAndFound =>
        val createLostAndFound: LostAndFound = new LostAndFound(Some(""), newLostAndFound.animalId.head, loggedUserId, new Date(), "LOST", false)
        lostAndFoundDAO.create(createLostAndFound)
      }
    }

  def createFound(lostAndFound: Animal, loggedUserId: String): Future[LostAndFound] = {
    val animal = animalDAO.create(lostAndFound)

    animal.flatMap { newLostAndFound =>
      val createLostAndFound: LostAndFound = new LostAndFound(Some(""), newLostAndFound.animalId.head, loggedUserId, new Date(), "FOUND", false)
      lostAndFoundDAO.create(createLostAndFound)
    }
  }

    def readAll(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAll
    }

    def readAllLost(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllLost
    }

    def readAllFound(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllFound
    }

    def readAllFoundNotApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllFoundNotApproved
    }

    def readAllLostNotApproved(): Future[Seq[LostAndFound]] = {
      lostAndFoundDAO.readAllLostNotApproved
    }

    def read(vetId: String): Future[LostAndFound] = {
      lostAndFoundDAO.read(vetId)
    }

    def adminApproveLAF(lostAndFound: LostAndFound, loggedInUser: String): Future[LostAndFound] = {
      adminDAO.adminExists(loggedInUser).flatMap {
        case true => lostAndFoundDAO.approve(lostAndFound)
        case false => throw new Exception("User is not admin")
      }

    }
}
