package controllers

import model.Dog
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.DogService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DogController @Inject() (
                                dogService: DogService,
                                controllerComponents: ControllerComponents,
                              )(
                                implicit executionContext: ExecutionContext
                              ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newDog = request.body.validate[Dog]
    newDog match {
      case JsSuccess(dogObj, _) =>
        dogService.create(dogObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def update = Action.async(parse.json)  { implicit request =>
    val newDog = request.body.validate[Dog]

    newDog match {
      case JsSuccess(postObj, _) =>
        dogService.update(postObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    dogService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async(parse.json) { implicit request =>
    dogService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = Action.async(parse.json) { implicit request =>
    dogService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
