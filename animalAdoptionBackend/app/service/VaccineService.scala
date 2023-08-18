package service

import dao.{VaccineDAO, VetDAO}
import model.Vaccine

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VaccineService @Inject()(vaccineDAO: VaccineDAO,
                               vetDAO: VetDAO
                            )(implicit ec : ExecutionContext){

  def create(vaccine: Vaccine, loggedInUser: String): Future[Vaccine] = {

    vetDAO.vetExists(loggedInUser).flatMap {
      case true => vaccineDAO.create(vaccine, loggedInUser)
      case false => throw new Exception("User is not vet")
    }
  }

  def readAll(): Future[Seq[Vaccine]] = {
    vaccineDAO.readAll
  }

  def delete(vaccineId: String): Future[Int] = {
    vaccineDAO.delete(vaccineId)
  }

  def readAllAnimalVaccines(vaccineId: String): Future[Seq[Vaccine]] = {
    vaccineDAO.readAllAnimalVaccines(vaccineId)
  }

}
