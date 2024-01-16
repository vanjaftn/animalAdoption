package dao


import model.Adoption

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.sql.Timestamp
import java.util.Date
import scala.util.Random


class AdoptionDAO @Inject()(
                                 protected val dbConfigProvider: DatabaseConfigProvider
                               )(
                                 implicit executionContext: ExecutionContext
                               ) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val Adoptions = TableQuery[AdoptionsTable]

  implicit val dateMapper =
    MappedColumnType.base[Date, Timestamp](
      d => new Timestamp(d.getTime),
      d => new Date(d.getTime)
    )

  def create(adoption: Adoption, loggedUserId: String): Future[Adoption] = {
    val newAdoption = adoption.copy(adoptionId = Option(Random.alphanumeric.take(16).mkString), adoptionStatus = "PENDING", userId = loggedUserId)
    db.run(Adoptions += newAdoption).map(_ => newAdoption)
  }

  def adminApprove(adoption: Adoption): Future[Adoption] = {
    db.run(Adoptions.filter(_.adoptionId === adoption.adoptionId).map(_.adoptionStatus).update("ADMINAPPROVED"))
      .map(res => adoption)
  }

  def vetApprove(adoption: Adoption): Future[Adoption] = {
    db.run(Adoptions.filter(_.adoptionId === adoption.adoptionId).map(_.adoptionStatus).update("APPROVED"))
      .map(res => adoption)
  }

  def animalAdopted(animalId: String): Future[Boolean] = {
    db.run(Adoptions.filter(adoption => (adoption.animalId === animalId) && adoption.adoptionStatus === "APPROVED").exists.result)
  }

  def animalAdminApproved(animalId: String): Future[Boolean] = {
    db.run(Adoptions.filter(adoption => (adoption.animalId === animalId) && adoption.adoptionStatus === "ADMINAPPROVED").exists.result)
  }

  def approvedAdoptionExists(animalId: String, userId: String): Future[Boolean] = {
    db.run(Adoptions.filter(adoption => adoption.animalId === animalId && adoption.userId === userId && adoption.adoptionStatus === "APPROVED").exists.result)
  }

  def adoptionExists(animalId: String, userId: String): Future[Boolean] = {
    db.run(Adoptions.filter(adoption => adoption.animalId === animalId && adoption.userId === userId).exists.result)
  }

  def delete(id: String): Future[Int] = {
    db.run(Adoptions.filter(_.adoptionId === id).delete)
  }

  def deletePending(id: String): Future[Int] = {
    db.run(Adoptions.filter(adoption => adoption.adoptionId === id && adoption.adoptionStatus === "PENDING").delete)
  }

  def deleteApproved(id: String): Future[Int] = {
    db.run(Adoptions.filter(adoption => adoption.adoptionId === id && adoption.adoptionStatus === "ADMINAPPROVED").delete)
  }

  def read(id: String): Future[Adoption] = {
    db.run(Adoptions.filter(_.adoptionId === id).result.head)
  }

  def readAll: Future[Seq[Adoption]] = {
    db.run(Adoptions.result)
  }

  def readAllUsersAdoptions(userId: String): Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(_.userId === userId).result)
  }

  def readAllUsersApprovedAdoptions(userId: String): Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(adoption => adoption.userId === userId && adoption.adoptionStatus === "APPROVED").result)
  }

  def readByUserAndAnimalId(animalId: String, userId: String): Future[Adoption] = {
    db.run(Adoptions.filter(adoption => adoption.userId === userId && adoption.animalId=== animalId).result.head)
  }

  def readAllAdoptedAnimalIds(): Future[Seq[String]] = {
    val query = Adoptions.filter(animal => animal.adoptionStatus === "APPROVED").map(_.animalId).result
    db.run(query)
  }

  def readAllApprovedAdoptions : Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(_.adoptionStatus === "APPROVED").sortBy(_.adoptionDate).result)
  }

  def readAllAnimalPendingAdoptions(animalId: String): Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(adoption => adoption.adoptionStatus === "PENDING" && adoption.animalId === animalId).result)
  }

  def readAllAnimalAdminApprovedAdoptions(animalId: String): Future[Seq[Adoption]] = {
    db.run(Adoptions.filter(adoption => adoption.adoptionStatus === "ADMINAPPROVED" && adoption.animalId === animalId).result)
  }


  class AdoptionsTable(tag: Tag) extends Table[Adoption](tag, "adoptions") {

    def adoptionId = column[Option[String]]("ADOPTIONID", O.PrimaryKey)

    def animalId = column[String]("ANIMALID")

    def userId = column[String]("USERID")

    def adoptionDate = column[Date]("ADOPTIONDATE")
    def adoptionStatus = column[String]("ADOPTIONSTATUS")

    def * = (adoptionId, animalId, userId, adoptionDate, adoptionStatus) <> ((Adoption.apply _).tupled, Adoption.unapply)

  }

}
