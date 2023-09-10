// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:162
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:162
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:136
  class ReversePhotoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:139
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allPhotos"})
        }
      """
    )
  
    // @LINE:138
    def adopterAddPhotos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.adopterAddPhotos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterAddPhotos"})
        }
      """
    )
  
    // @LINE:136
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "photo"})
        }
      """
    )
  
    // @LINE:145
    def readAllAnimalPhotos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.readAllAnimalPhotos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalPhotos"})
        }
      """
    )
  
    // @LINE:141
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePhoto/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:143
    def uploadMedia: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PhotoController.uploadMedia",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadMedia"})
        }
      """
    )
  
  }

  // @LINE:81
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:81
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:82
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdmins"})
        }
      """
    )
  
    // @LINE:83
    def adminExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.adminExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminExists"})
        }
      """
    )
  
    // @LINE:85
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:158
  class ReverseAnimalTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:158
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalTypeController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalType"})
        }
      """
    )
  
    // @LINE:159
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalTypeController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalTypes"})
        }
      """
    )
  
  }

  // @LINE:28
  class ReverseAnimalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimals"})
        }
      """
    )
  
    // @LINE:37
    def readAllUsersSubscribedAnimals: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUsersSubscribedAnimals",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsersSubscribedAnimals"})
        }
      """
    )
  
    // @LINE:34
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "animal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:39
    def animalIsSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalIsSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalIsSterilized"})
        }
      """
    )
  
    // @LINE:36
    def readAllUnadopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUnadopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUnadoptedAnimals"})
        }
      """
    )
  
    // @LINE:28
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animal"})
        }
      """
    )
  
    // @LINE:35
    def readAllAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllAdopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptedAnimals"})
        }
      """
    )
  
    // @LINE:41
    def animalSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalSterilized"})
        }
      """
    )
  
    // @LINE:33
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAnimal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:43
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.search",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchAnimal"})
        }
      """
    )
  
    // @LINE:31
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAnimal"})
        }
      """
    )
  
  }

  // @LINE:70
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allSubscriptions"})
        }
      """
    )
  
    // @LINE:76
    def subscriptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscriptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionExists"})
        }
      """
    )
  
    // @LINE:71
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:70
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription"})
        }
      """
    )
  
    // @LINE:74
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSubscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:78
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

  
    // @LINE:17
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
  
    // @LINE:18
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
  
    // @LINE:25
    def readAllAnimalAdminApprovedAdopters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAllAnimalAdminApprovedAdopters",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalAdminApprovedAdopters"})
        }
      """
    )
  
    // @LINE:12
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:21
    def readLoggedInUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readLoggedInUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loggedInUser"})
        }
      """
    )
  
    // @LINE:20
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def passwordExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.passwordExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "passwordExists"})
        }
      """
    )
  
    // @LINE:14
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateUser"})
        }
      """
    )
  
    // @LINE:23
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

  // @LINE:148
  class ReverseVideoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:151
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVideos"})
        }
      """
    )
  
    // @LINE:150
    def adopterAddPhotos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.adopterAddPhotos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterAddVideos"})
        }
      """
    )
  
    // @LINE:148
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "video"})
        }
      """
    )
  
    // @LINE:153
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVideo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:155
    def readAllAnimalVideos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VideoController.readAllAnimalVideos",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimalVideos"})
        }
      """
    )
  
  }

  // @LINE:95
  class ReverseAdopterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:95
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopter"})
        }
      """
    )
  
    // @LINE:96
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdopters"})
        }
      """
    )
  
    // @LINE:98
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdopter/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:100
    def adopterExist: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.adopterExist",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adopterExist"})
        }
      """
    )
  
  }

  // @LINE:88
  class ReverseVetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:88
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vet"})
        }
      """
    )
  
    // @LINE:90
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVets"})
        }
      """
    )
  
    // @LINE:92
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:103
    def vetExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.vetExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vetExists"})
        }
      """
    )
  
  }

  // @LINE:46
  class ReverseAdoptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def deleteApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.deleteApproved",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteApproved/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:51
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptions"})
        }
      """
    )
  
    // @LINE:65
    def animalAdminApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdminApproved",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdminApproved"})
        }
      """
    )
  
    // @LINE:59
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:46
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption"})
        }
      """
    )
  
    // @LINE:55
    def deletePending: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.deletePending",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletePending/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:67
    def adoptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adoptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoptionExists"})
        }
      """
    )
  
    // @LINE:48
    def adminApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adminApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApprove"})
        }
      """
    )
  
    // @LINE:53
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:50
    def vetApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.vetApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vetApprove"})
        }
      """
    )
  
    // @LINE:63
    def animalAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdopted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdopted"})
        }
      """
    )
  
    // @LINE:61
    def readByUserAndAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readByUserAndAnimalId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readByUserAndAnimalId"})
        }
      """
    )
  
    // @LINE:68
    def readAllUsersAdoptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAllUsersAdoptions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllUsersAdoptions"})
        }
      """
    )
  
  }

  // @LINE:106
  class ReverseVaccineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:106
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vaccine"})
        }
      """
    )
  
    // @LINE:107
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVaccines"})
        }
      """
    )
  
    // @LINE:109
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVaccine/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:111
    def readAllAnimalVaccines: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAllAnimalVaccines",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalVaccines"})
        }
      """
    )
  
  }

  // @LINE:114
  class ReverseLostAndFoundController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:117
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFound"})
        }
      """
    )
  
    // @LINE:119
    def readAllApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFoundApproved"})
        }
      """
    )
  
    // @LINE:118
    def readAllNotApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllNotApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostAndFoundNotApproved"})
        }
      """
    )
  
    // @LINE:131
    def readByAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readByAnimalId",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFoundByAnimalId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:128
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFound/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:123
    def readAllFound: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFound",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allFound"})
        }
      """
    )
  
    // @LINE:116
    def createFound: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.createFound",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "found"})
        }
      """
    )
  
    // @LINE:120
    def readAllLostApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllLostApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLostApproved"})
        }
      """
    )
  
    // @LINE:133
    def lostAndFoundExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.lostAndFoundExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lostAndFoundExists"})
        }
      """
    )
  
    // @LINE:122
    def readAllLost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllLost",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allLost"})
        }
      """
    )
  
    // @LINE:127
    def adminApproveLAF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.adminApproveLAF",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApproveLAF"})
        }
      """
    )
  
    // @LINE:130
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteLostAndFound/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:114
    def createLost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.createLost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lost"})
        }
      """
    )
  
    // @LINE:121
    def readAllFoundApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFoundApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allFoundApproved"})
        }
      """
    )
  
    // @LINE:125
    def readAllFoundNotApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LostAndFoundController.readAllFoundNotApproved",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllFoundNotApproved"})
        }
      """
    )
  
    // @LINE:124
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
