package controllers

import auth.AuthAction
import model.{AnimalType}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AnimalTypeService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalTypeController @Inject() (
                                  animalTypeService: AnimalTypeService,
                                  controllerComponents: ControllerComponents,
                                  authAction: AuthAction

                                )(
                                  implicit executionContext: ExecutionContext
                                ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAdmin = request.body.validate[AnimalType]
    newAdmin match {
      case JsSuccess(animalObj, _) =>
        animalTypeService.create(animalObj, loggedInUser).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    animalTypeService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    animalTypeService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def adminExists = authAction.async { implicit request =>
    val loggedInUser = request.user

    animalTypeService.animalTypeExists(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
