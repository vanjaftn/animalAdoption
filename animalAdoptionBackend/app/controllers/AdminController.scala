package controllers

import auth.AuthAction
import model.{Admin}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AdminService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdminController @Inject() (
                                   adminService: AdminService,
                                   controllerComponents: ControllerComponents,
                                   authAction: AuthAction

                                 )(
                                   implicit executionContext: ExecutionContext
                                 ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newAdmin = request.body.validate[Admin]
    newAdmin match {
      case JsSuccess(animalObj, _) =>
        adminService.create(animalObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    adminService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    adminService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def adminExists = authAction.async { implicit request =>
    val loggedInUser = request.user

    adminService.adminExists(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
