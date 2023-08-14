package controllers

import model.Adoption
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.{AdoptionService}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdoptionController @Inject() (
                                   adoptionService: AdoptionService,
                                   controllerComponents: ControllerComponents,
                                 )(
                                   implicit executionContext: ExecutionContext
                                 ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newAdoption = request.body.validate[Adoption]
    newAdoption match {
      case JsSuccess(adoptionObj, _) =>
        adoptionService.create(adoptionObj).map(res =>
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
}
