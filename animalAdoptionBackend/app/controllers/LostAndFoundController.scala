package controllers

import auth.AuthAction
import dto.{AnimalWithPhotosDTO, CreateLostAndFoundDTO}
import model.{Animal, LostAndFound}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.LostAndFoundService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LostAndFoundController @Inject() (
                                lostAndFoundService: LostAndFoundService,
                                controllerComponents: ControllerComponents,
                                authAction: AuthAction

                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def createLost = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAnimal = request.body.validate[CreateLostAndFoundDTO]
    newAnimal match {
      case JsSuccess(animalObj, _) =>
        lostAndFoundService.createLost(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def createFound = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAnimal = request.body.validate[CreateLostAndFoundDTO]
    newAnimal match {
      case JsSuccess(animalObj, _) =>
        lostAndFoundService.createFound(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def adminApproveLAF = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val animal = request.body.validate[LostAndFound]
    animal match {
      case JsSuccess(animalObj, _) =>
        lostAndFoundService.adminApproveLAF(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    lostAndFoundService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllApproved = Action.async { implicit request =>
    lostAndFoundService.readAllApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllLostApproved = Action.async { implicit request =>
    lostAndFoundService.readAllLostApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllFoundApproved = Action.async { implicit request =>
    lostAndFoundService.readAllFoundApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllNotApproved = Action.async { implicit request =>
    lostAndFoundService.readAllNotApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllLost = Action.async { implicit request =>
    lostAndFoundService.readAllLost().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllFound = Action.async { implicit request =>
    lostAndFoundService.readAllFound().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllLostNotApproved = Action.async { implicit request =>
    lostAndFoundService.readAllLostNotApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllFoundNotApproved = Action.async { implicit request =>
    lostAndFoundService.readAllFoundNotApproved().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = authAction.async { implicit request =>
    lostAndFoundService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = authAction.async { implicit request =>
    lostAndFoundService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readByAnimalId(id: String) = authAction.async { implicit request =>
    lostAndFoundService.readByAnimalId(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def lostAndFoundExists = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val animal = request.body.validate[String]
    animal match {
      case JsSuccess(animalObj, _) =>
        lostAndFoundService.lostAndFoundExists(animalObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
}
