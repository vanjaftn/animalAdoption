package controllers

import auth.AuthAction
import dto.{CreateUserDTO, LoginUserDTO}
import model.User
import play.api.libs.json.{JsError, JsSuccess, Json}
import service.UserService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc.{AbstractController, ControllerComponents}

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

  def confirm = Action.async(parse.json) { implicit request =>
    val newUser = request.body.validate[User]
    newUser match {
      case JsSuccess(userObj, _) =>
        userService.confirm(userObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def create(confirmationCode: String) = Action.async { implicit request =>
    userService.create(confirmationCode).map(res =>
      Ok(Json.toJson("You have confirmed your email, now you can sign in to our application. Enjoy!"))
    )
  }

  def update = authAction.async(parse.json) { implicit request =>
    val newUser = request.body.validate[User]
    newUser match {
      case JsSuccess(userObj, _) =>
        userService.update(userObj).map(res =>
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

  def readAll = Action.async { implicit request =>
//    val loggedInUser = request.user
    userService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAnimalPendingAdopters = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        userService.readAllAnimalPendingAdopters(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAllAnimalAdminApprovedAdopters = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        userService.readAllAnimalAdminApprovedAdopters(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def passwordExists = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val password = request.body.validate[String]
    password match {
      case JsSuccess(passwordObj, _) =>
        userService.passwordExists(passwordObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def forgotPassword = Action.async(parse.json) { implicit request =>
    val email = request.body.validate[String]

    email match {
      case JsSuccess(emailObj, _) =>
        userService.forgotPassword(emailObj)
        Future.successful(Ok)
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

}
