package controllers

import auth.AuthAction
import model.{Vaccine}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.VaccineService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VaccineController @Inject() (
                                  vaccineService: VaccineService,
                                  controllerComponents: ControllerComponents,
                                  authAction: AuthAction

                                )(
                                  implicit executionContext: ExecutionContext
                                ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newVaccine = request.body.validate[Vaccine]
    newVaccine match {
      case JsSuccess(vaccineObj, _) =>
        vaccineService.create(vaccineObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    vaccineService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    vaccineService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAnimalVaccines = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        vaccineService.readAllAnimalVaccines(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }
}
