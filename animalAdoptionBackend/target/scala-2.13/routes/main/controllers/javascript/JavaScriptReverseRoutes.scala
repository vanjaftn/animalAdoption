// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:165
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:165
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:139
  class ReversePhotoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:142
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allPhotos"})
        }
      """
    )
  
    // @LINE:141
    def adopterAddPhotos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.adopterAddPhotos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterAddPhotos"})
        }
      """
    )
  
    // @LINE:139
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "photo"})
        }
      """
    )
  
    // @LINE:148
    def readAllAnimalPhotos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.readAllAnimalPhotos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalPhotos"})
        }
      """
    )
  
    // @LINE:144
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePhoto/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:146
    def uploadMedia: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.uploadMedia",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadMedia"})
        }
      """
    )
  
  }

  // @LINE:84
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:84
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:85
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdmins"})
        }
      """
    )
  
    // @LINE:86
    def adminExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.adminExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminExists"})
        }
      """
    )
  
    // @LINE:88
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:161
  class ReverseAnimalTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:161
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalTypeController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalType"})
        }
      """
    )
  
    // @LINE:162
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalTypeController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalTypes"})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseAnimalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimals"})
        }
      """
    )
  
    // @LINE:40
    def readAllUsersSubscribedAnimals: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUsersSubscribedAnimals",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsersSubscribedAnimals"})
        }
      """
    )
  
    // @LINE:37
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "animal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:42
    def animalIsSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalIsSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalIsSterilized"})
        }
      """
    )
  
    // @LINE:39
    def readAllUnadopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUnadopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUnadoptedAnimals"})
        }
      """
    )
  
    // @LINE:31
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animal"})
        }
      """
    )
  
    // @LINE:38
    def readAllAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllAdopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptedAnimals"})
        }
      """
    )
  
    // @LINE:44
    def animalSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalSterilized"})
        }
      """
    )
  
    // @LINE:36
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAnimal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:46
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.search",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchAnimal"})
        }
      """
    )
  
    // @LINE:34
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAnimal"})
        }
      """
    )
  
  }

  // @LINE:73
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allSubscriptions"})
        }
      """
    )
  
    // @LINE:79
    def subscriptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscriptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionExists"})
        }
      """
    )
  
    // @LINE:74
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:73
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription"})
        }
      """
    )
  
    // @LINE:77
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSubscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:81
    def readSubscriptionByAnimalAndUserId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readSubscriptionByAnimalAndUserId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionByAnimalId"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsers"})
        }
      """
    )
  
    // @LINE:10
    def loginUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.loginUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:19
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.read",
      """
        function(id0) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
          }
        
        }
      """
    )
  
    // @LINE:26
    def readAllAnimalAdminApprovedAdopters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAllAnimalAdminApprovedAdopters",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalAdminApprovedAdopters"})
        }
      """
    )
  
    // @LINE:28
    def forgotPassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.forgotPassword",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotPassword"})
        }
      """
    )
  
    // @LINE:12
    def confirm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.confirm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "confirm"})
        }
      """
    )
  
    // @LINE:13
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.create",
      """
        function(confirmationCode0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("confirmationCode", confirmationCode0))})
        }
      """
    )
  
    // @LINE:22
    def readLoggedInUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readLoggedInUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loggedInUser"})
        }
      """
    )
  
    // @LINE:21
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def passwordExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.passwordExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "passwordExists"})
        }
      """
    )
  
    // @LINE:15
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUser"})
        }
      """
    )
  
    // @LINE:24
    def readAllAnimalPendingAdopters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAllAnimalPendingAdopters",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalPendingAdopters"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:151
  class ReverseVideoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:154
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVideos"})
        }
      """
    )
  
    // @LINE:151
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "video"})
        }
      """
    )
  
    // @LINE:156
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVideo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:153
    def adopterAddVideos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.adopterAddVideos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterAddVideos"})
        }
      """
    )
  
    // @LINE:158
    def readAllAnimalVideos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.readAllAnimalVideos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalVideos"})
        }
      """
    )
  
  }

  // @LINE:98
  class ReverseAdopterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:98
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopter"})
        }
      """
    )
  
    // @LINE:99
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdopters"})
        }
      """
    )
  
    // @LINE:101
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdopter/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:103
    def adopterExist: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.adopterExist",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterExist"})
        }
      """
    )
  
  }

  // @LINE:91
  class ReverseVetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:91
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vet"})
        }
      """
    )
  
    // @LINE:93
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVets"})
        }
      """
    )
  
    // @LINE:95
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:106
    def vetExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.vetExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vetExists"})
        }
      """
    )
  
  }

  // @LINE:49
  class ReverseAdoptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def deleteApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.deleteApproved",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteApproved/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:54
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptions"})
        }
      """
    )
  
    // @LINE:68
    def animalAdminApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdminApproved",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdminApproved"})
        }
      """
    )
  
    // @LINE:62
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:49
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption"})
        }
      """
    )
  
    // @LINE:58
    def deletePending: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.deletePending",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePending/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:70
    def adoptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adoptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoptionExists"})
        }
      """
    )
  
    // @LINE:51
    def adminApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adminApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApprove"})
        }
      """
    )
  
    // @LINE:56
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:53
    def vetApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.vetApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vetApprove"})
        }
      """
    )
  
    // @LINE:66
    def animalAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdopted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdopted"})
        }
      """
    )
  
    // @LINE:64
    def readByUserAndAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readByUserAndAnimalId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readByUserAndAnimalId"})
        }
      """
    )
  
    // @LINE:71
    def readAllUsersAdoptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAllUsersAdoptions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllUsersAdoptions"})
        }
      """
    )
  
  }

  // @LINE:109
  class ReverseVaccineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:109
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vaccine"})
        }
      """
    )
  
    // @LINE:110
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVaccines"})
        }
      """
    )
  
    // @LINE:112
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVaccine/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:114
    def readAllAnimalVaccines: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAllAnimalVaccines",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalVaccines"})
        }
      """
    )
  
  }

  // @LINE:117
  class ReverseLostAndFoundController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:120
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFound"})
        }
      """
    )
  
    // @LINE:122
    def readAllApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFoundApproved"})
        }
      """
    )
  
    // @LINE:121
    def readAllNotApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllNotApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFoundNotApproved"})
        }
      """
    )
  
    // @LINE:134
    def readByAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readByAnimalId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFoundByAnimalId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:131
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFound/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:126
    def readAllFound: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFound",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allFound"})
        }
      """
    )
  
    // @LINE:119
    def createFound: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.createFound",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "found"})
        }
      """
    )
  
    // @LINE:123
    def readAllLostApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllLostApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostApproved"})
        }
      """
    )
  
    // @LINE:136
    def lostAndFoundExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.lostAndFoundExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFoundExists"})
        }
      """
    )
  
    // @LINE:125
    def readAllLost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllLost",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLost"})
        }
      """
    )
  
    // @LINE:130
    def adminApproveLAF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.adminApproveLAF",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApproveLAF"})
        }
      """
    )
  
    // @LINE:133
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteLostAndFound/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:117
    def createLost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.createLost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lost"})
        }
      """
    )
  
    // @LINE:124
    def readAllFoundApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFoundApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allFoundApproved"})
        }
      """
    )
  
    // @LINE:128
    def readAllFoundNotApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFoundNotApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllFoundNotApproved"})
        }
      """
    )
  
    // @LINE:127
    def readAllLostNotApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllLostNotApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllLostNotApproved"})
        }
      """
    )
  
  }


}
