package controllers

import auth.AuthAction
import dto.{AnimalWithPhotosDTO, SearchRequestDTO}
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

  def create = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newAnimal = request.body.validate[AnimalWithPhotosDTO]
    newAnimal match {
      case JsSuccess(animalObj, _) =>
        animalService.create(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def update = authAction.async(parse.json)  { implicit request =>
    val loggedInUser = request.user
    val newAnimal = request.body.validate[AnimalWithPhotosDTO]

    newAnimal match {
      case JsSuccess(animalObj, _) =>
        animalService.update(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    animalService.readAll().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = authAction.async { implicit request =>
    val loggedInUser = request.user

    animalService.delete(id, loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = Action.async { implicit request =>
    animalService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAdopted = Action.async { implicit request =>
    animalService.readAllAdoptedAnimals.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllUnadopted = Action.async { implicit request =>
    animalService.readAllUnadoptedAnimals().map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllUsersSubscribedAnimals = authAction.async { implicit request =>
    val loggedInUser = request.user

    animalService.readAllUsersSubscribedAnimals(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def animalIsSterilized = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user
    val newAnimal = request.body.validate[Animal]

    newAnimal match {
      case JsSuccess(animalObj, _) =>
        animalService.animalIsSterilized(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def animalSterilized = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        animalService.animalSterilized(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def search = authAction.async(parse.json) { request =>
    val loggedInUser = request.user
    val searchRequest = request.body.validate[SearchRequestDTO]
    searchRequest match {
      case JsSuccess(searchRequestObj, _) =>
        animalService.search(searchRequestObj.searchInput, searchRequestObj.animals).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }

  }



}
