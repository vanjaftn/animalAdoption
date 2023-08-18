package controllers

import auth.AuthAction
import dto.LoginUserDTO
import model.User
import play.api.libs.json.{JsError, JsSuccess, Json}
import service.UserService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc.{AbstractController, ControllerComponents}

import java.nio.file.Paths
class UserController @Inject() (
                                 userService: UserService,
                                 controllerComponents: ControllerComponents,
                                 authAction: AuthAction
                               )(
                                 implicit executionContext: ExecutionContext
                               ) extends AbstractController(controllerComponents) {

  def loginUser = Action.async(parse.json) { implicit request =>
    val loggedUser = request.body.validate[LoginUserDTO]
    loggedUser match {
      case JsSuccess(userObj, _) =>
        userService.loginUser(userObj).map(res =>
          Ok(res)

        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def create = Action.async(parse.json) { implicit request =>
    val newDog = request.body.validate[User]
    newDog match {
      case JsSuccess(dogObj, _) =>
        userService.create(dogObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def read(id: String) = authAction.async { implicit request =>
    userService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = authAction.async { implicit request =>
    userService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readLoggedInUser = authAction.async { implicit request =>
    val loggedInUser = request.user

    userService.read(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAll = authAction.async { implicit request =>
//    val loggedInUser = request.user
    userService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAnimalPendingAdoptions = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        userService.readAllAnimalPendingAdoptions(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
}
