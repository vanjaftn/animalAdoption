package service

import dao.{AdminDAO, LostAndFoundDAO}
import model.{Admin, LostAndFound}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdminService @Inject()(adminDAO: AdminDAO,
                             )(implicit ec : ExecutionContext){

  def create(userId: String): Future[Admin] = {
    adminDAO.create(userId)
  }

  def readAll(): Future[Seq[Admin]] = {
    adminDAO.readAll
  }

  def delete(adminId: String): Future[Int] = {
    adminDAO.delete(adminId)
  }

  def adminExists(userId: String): Future[Boolean] = {
    adminDAO.adminExists(userId)
  }


}
