package controllers

import auth.AuthAction
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

    val newAnimal = request.body.validate[Animal]
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

    val newAnimal = request.body.validate[Animal]
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
}
