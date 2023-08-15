package controllers

import auth.AuthAction
import model.Subscription
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.SubscriptionService

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SubscriptionController @Inject() (
                                         subscriptionService: SubscriptionService,
                                     controllerComponents: ControllerComponents,
                                         authAction: AuthAction

                                   )(
                                     implicit executionContext: ExecutionContext
                                   ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[Subscription]
    val loggedInUser = request.user

    animalId match {
      case JsSuccess(subscriptionObj, _) =>
        subscriptionService.create(subscriptionObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def subscriptionExists = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    val loggedInUser = request.user

    animalId match {
      case JsSuccess(animalObj, _) =>
        subscriptionService.subscriptionExists(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readSubscriptionByAnimalAndUserId = authAction.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    val loggedInUser = request.user

    animalId match {
      case JsSuccess(animalObj, _) =>
        subscriptionService.readSubscriptionByAnimalAndUserId(animalObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    subscriptionService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
//    val loggedInUser = request.user

    subscriptionService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def read(id: String) = authAction.async { implicit request =>
    val loggedInUser = request.user

    subscriptionService.read(id).map(res =>
      Ok(Json.toJson(res))
    )
  }
}
