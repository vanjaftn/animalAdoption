package controllers

import auth.AuthAction
import model.Animal
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AnimalService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalController @Inject() (
                                animalService: AnimalService,
                                controllerComponents: ControllerComponents,
                                authAction: AuthAction

                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newAnimal = request.body.validate[Animal]
    newAnimal match {
      case JsSuccess(animalObj, _) =>
        animalService.create(animalObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def update = Action.async(parse.json)  { implicit request =>
    val newAnimal = request.body.validate[Animal]

    newAnimal match {
      case JsSuccess(animalObj, _) =>
        animalService.update(animalObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    animalService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async(parse.json) { implicit request =>
    animalService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = authAction.async { implicit request =>
    animalService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAdopted = Action.async { implicit request =>
    animalService.readAllAdoptedAnimals.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllUsersSubscribedAnimals = authAction.async { implicit request =>
    val loggedInUser = request.user

    animalService.readAllUsersSubscribedAnimals(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
