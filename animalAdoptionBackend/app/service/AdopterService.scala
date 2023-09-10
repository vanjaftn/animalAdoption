package service

import dao.AdopterDAO
import model.Adopter

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdopterService @Inject()(adopterDAO: AdopterDAO
                              )(implicit ec : ExecutionContext){

  def create(adopter: Adopter): Future[Adopter] = {
    adopterDAO.create(adopter)
  }

  def readAll(): Future[Seq[Adopter]] = {
    adopterDAO.readAll
  }

  def delete(vetId: String): Future[Int] = {
    adopterDAO.delete(vetId)
  }

  def adopterExist(userId: String): Future[Boolean] = {
    adopterDAO.adopterExist(userId)
  }

}

