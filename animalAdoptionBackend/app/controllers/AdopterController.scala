package controllers

import auth.AuthAction
import model.{Adopter}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.AdopterService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AdopterController @Inject() (
                                    adopterService: AdopterService,
                                    controllerComponents: ControllerComponents,
                                    authAction: AuthAction

                                  )(
                                    implicit executionContext: ExecutionContext
                                  ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newAdopter = request.body.validate[Adopter]
    newAdopter match {
      case JsSuccess(adopterObj, _) =>
        adopterService.create(adopterObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    adopterService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    adopterService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def adopterExist = authAction.async { implicit request =>
    val loggedInUser = request.user

    adopterService.adopterExist(loggedInUser.userId.head).map(res =>
      Ok(Json.toJson(res))
    )
  }

}