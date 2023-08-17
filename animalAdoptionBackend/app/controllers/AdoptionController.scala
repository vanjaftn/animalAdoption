package controllers

import auth.AuthAction
import model.Adoption
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AdoptionService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdoptionController @Inject() (
                                   adoptionService: AdoptionService,
                                   controllerComponents: ControllerComponents,
                                   authAction: AuthAction
                                 )(
                                   implicit executionContext: ExecutionContext
                                 ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAdoption = request.body.validate[Adoption]
    newAdoption match {
      case JsSuccess(adoptionObj, _) =>
        adoptionService.create(adoptionObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    adoptionService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async(parse.json) { implicit request =>
    adoptionService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = Action.async(parse.json) { implicit request =>
    adoptionService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def adminApprove = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAdoptionId = request.body.validate[String]
    newAdoptionId match {
      case JsSuccess(adoptionIdObj, _) =>
        adoptionService.adminApprove(adoptionIdObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def animalAdopted = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        adoptionService.animalAdopted(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
}
