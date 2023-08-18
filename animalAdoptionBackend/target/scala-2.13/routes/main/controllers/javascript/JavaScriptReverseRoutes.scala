// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:76
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:76
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:57
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:58
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdmins"})
        }
      """
    )
  
    // @LINE:59
    def adminExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.adminExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminExists"})
        }
      """
    )
  
    // @LINE:61
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseAnimalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimals"})
        }
      """
    )
  
    // @LINE:29
    def readAllUsersSubscribedAnimals: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUsersSubscribedAnimals",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsersSubscribedAnimals"})
        }
      """
    )
  
    // @LINE:27
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "animal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:22
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animal"})
        }
      """
    )
  
    // @LINE:28
    def readAllAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllAdopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptedAnimals"})
        }
      """
    )
  
    // @LINE:26
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAnimal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:24
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAnimal"})
        }
      """
    )
  
  }

  // @LINE:46
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allSubscriptions"})
        }
      """
    )
  
    // @LINE:52
    def subscriptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscriptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionExists"})
        }
      """
    )
  
    // @LINE:47
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:46
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription"})
        }
      """
    )
  
    // @LINE:50
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSubscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:54
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

  
    // @LINE:13
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
  
    // @LINE:14
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
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
  
    // @LINE:19
    def readAllAnimalPendingAdoptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAllAnimalPendingAdoptions",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalPendingAdoptions"})
        }
      """
    )
  
    // @LINE:17
    def readLoggedInUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readLoggedInUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loggedInUser"})
        }
      """
    )
  
    // @LINE:16
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
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

  // @LINE:70
  class ReverseAdopterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:70
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopter"})
        }
      """
    )
  
    // @LINE:71
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdopters"})
        }
      """
    )
  
    // @LINE:73
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdopter/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:64
  class ReverseVetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:64
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vet"})
        }
      """
    )
  
    // @LINE:65
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVets"})
        }
      """
    )
  
    // @LINE:67
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:32
  class ReverseAdoptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptions"})
        }
      """
    )
  
    // @LINE:39
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:32
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption"})
        }
      """
    )
  
    // @LINE:34
    def adminApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adminApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApprove"})
        }
      """
    )
  
    // @LINE:37
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:43
    def animalAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdopted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdopted"})
        }
      """
    )
  
    // @LINE:41
    def readByUserAndAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readByUserAndAnimalId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readByUserAndAnimalId"})
        }
      """
    )
  
  }


}
