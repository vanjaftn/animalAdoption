package controllers

import model.{Animal}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AnimalService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AnimalController @Inject() (
                                animalService: AnimalService,
                                controllerComponents: ControllerComponents,
                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newDog = request.body.validate[Animal]
    newDog match {
      case JsSuccess(dogObj, _) =>
        animalService.create(dogObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def update = Action.async(parse.json)  { implicit request =>
    val newDog = request.body.validate[Animal]

    newDog match {
      case JsSuccess(postObj, _) =>
        animalService.update(postObj).map(res =>
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

  def read(id: String) = Action.async(parse.json) { implicit request =>
    animalService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
