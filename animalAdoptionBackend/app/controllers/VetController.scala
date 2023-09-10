package controllers

import auth.AuthAction
import model.{Admin, User, Vet}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.VetService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VetController @Inject() (
                                vetService: VetService,
                                controllerComponents: ControllerComponents,
                                authAction: AuthAction

                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newVet = request.body.validate[User]
    newVet match {
      case JsSuccess(vetObj, _) =>
        vetService.create(vetObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def read(id: String) = Action.async { implicit request =>
    vetService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAll = Action.async { implicit request =>
    vetService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    vetService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def vetExists = authAction.async { implicit request =>
    val loggedInUser = request.user

    vetService.vetExists(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

}
