package controllers

import auth.AuthAction
import model.Photo
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{AbstractController, ControllerComponents}
import service.PhotoService

import java.nio.file.Paths
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PhotoController @Inject() (
                                  photoService: PhotoService,
                                    controllerComponents: ControllerComponents,
                                    authAction: AuthAction

                                  )(
                                    implicit executionContext: ExecutionContext
                                  ) extends AbstractController(controllerComponents) {

  def create = Action.async(parse.json) { implicit request =>
    val newPhoto = request.body.validate[Photo]
    newPhoto match {
      case JsSuccess(photoObj, _) =>
        photoService.create(photoObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def readAll = Action.async { implicit request =>
    photoService.readAll.map(res =>
      Ok(Json.toJson(res))
    )
  }

  def delete(id: String) = Action.async { implicit request =>
    photoService.delete(id).map(res =>
      Ok(Json.toJson(res))
    )
  }

  def readAllAnimalPhotos = Action.async(parse.json) { implicit request =>
    val animalId = request.body.validate[String]
    animalId match {
      case JsSuccess(animalIdObj, _) =>
        photoService.readAllAnimalPhotos(animalIdObj).map(res =>
          Ok(Json.toJson(res))
        )
      case JsError(errors) => Future.successful(BadRequest(errors.toString))
    }
  }

  def uploadPhoto = authAction(parse.multipartFormData) { request =>
    val loggedInUser = request.user
    request.body.files.map { picture =>
      val filename = Paths.get(picture.filename).getFileName
      picture.ref.copyTo(Paths.get(s"C:/Users/vanja/Desktop/diplomski/animalAdoption/animalAdoptionBackend/public/images/$filename"), replace = true)
      picture.ref.copyTo(Paths.get(s"C:/Users/vanja/Desktop/diplomski/animalAdoption/animalAdoptionFrontend/src/assets/images/$filename"), replace = true)
//      userService.changePhoto(loggedInUser.userId, filename.toString)
    }
    Ok("File uploaded")
  }

}