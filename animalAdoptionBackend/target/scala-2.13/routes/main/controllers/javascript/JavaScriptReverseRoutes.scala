// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:61
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:61
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:54
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:54
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:55
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdmin"})
        }
      """
    )
  
    // @LINE:56
    def adminExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.adminExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminExists"})
        }
      """
    )
  
    // @LINE:58
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseAnimalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimals"})
        }
      """
    )
  
    // @LINE:26
    def readAllUsersSubscribedAnimals: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUsersSubscribedAnimals",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsersSubscribedAnimals"})
        }
      """
    )
  
    // @LINE:24
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "animal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animal"})
        }
      """
    )
  
    // @LINE:25
    def readAllAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllAdopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptedAnimals"})
        }
      """
    )
  
    // @LINE:23
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAnimal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:21
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAnimal"})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allSubscriptions"})
        }
      """
    )
  
    // @LINE:49
    def subscriptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscriptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionExists"})
        }
      """
    )
  
    // @LINE:44
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:43
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription"})
        }
      """
    )
  
    // @LINE:47
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSubscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:51
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

  
    // @LINE:12
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
  
    // @LINE:13
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:16
    def readAllAnimalPendingAdoptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readAllAnimalPendingAdoptions",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalPendingAdoptions"})
        }
      """
    )
  
    // @LINE:14
    def readLoggedInUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.readLoggedInUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loggedInUser"})
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

  // @LINE:29
  class ReverseAdoptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptions"})
        }
      """
    )
  
    // @LINE:36
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:29
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption"})
        }
      """
    )
  
    // @LINE:31
    def adminApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adminApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApprove"})
        }
      """
    )
  
    // @LINE:34
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:40
    def animalAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdopted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdopted"})
        }
      """
    )
  
    // @LINE:38
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
