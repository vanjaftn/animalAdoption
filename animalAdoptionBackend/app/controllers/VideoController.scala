package controllers

import auth.AuthAction
import model.{Video}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.VideoService

import java.nio.file.Paths
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class VideoController @Inject() (
                                  videoService: VideoService,
                                  controllerComponents: ControllerComponents,
                                  authAction: AuthAction

                                )(
                                  implicit executionContext: ExecutionContext
                                ) extends AbstractController(controllerComponents) {

  def create = authAction.async(parse.json) { implicit request =>
    val newVideo = request.body.validate[Video]
    newVideo match {
      case JsSuccess(videoObj, _) =>
        videoService.create(videoObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    videoService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    videoService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAnimalVideos = Action.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        videoService.readAllAnimalVideos(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def adopterAddVideos = authAction.async(parse.json) { implicit request =>
    val loggedInUser = request.user

    val newVideo = request.body.validate[Video]
    newVideo match {
      case JsSuccess(videoObj, _) =>
        videoService.adopterAddVideos(videoObj, loggedInUser.userId.head).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }


}