// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:96
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:96
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:66
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:67
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdmins"})
        }
      """
    )
  
    // @LINE:68
    def adminExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.adminExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminExists"})
        }
      """
    )
  
    // @LINE:70
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseAnimalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAnimals"})
        }
      """
    )
  
    // @LINE:31
    def readAllUsersSubscribedAnimals: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllUsersSubscribedAnimals",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allUsersSubscribedAnimals"})
        }
      """
    )
  
    // @LINE:29
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "animal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:33
    def animalIsSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalIsSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalIsSterilized"})
        }
      """
    )
  
    // @LINE:24
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animal"})
        }
      """
    )
  
    // @LINE:30
    def readAllAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.readAllAdopted",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptedAnimals"})
        }
      """
    )
  
    // @LINE:35
    def animalSterilized: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.animalSterilized",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalSterilized"})
        }
      """
    )
  
    // @LINE:28
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAnimal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AnimalController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateAnimal"})
        }
      """
    )
  
  }

  // @LINE:55
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allSubscriptions"})
        }
      """
    )
  
    // @LINE:61
    def subscriptionExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscriptionExists",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscriptionExists"})
        }
      """
    )
  
    // @LINE:56
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:55
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subscription"})
        }
      """
    )
  
    // @LINE:59
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSubscription/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:63
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
  
    // @LINE:21
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
  
    // @LINE:19
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

  // @LINE:79
  class ReverseAdopterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:79
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adopter"})
        }
      """
    )
  
    // @LINE:80
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdopters"})
        }
      """
    )
  
    // @LINE:82
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdopterController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdopter/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:73
  class ReverseVetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:73
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vet"})
        }
      """
    )
  
    // @LINE:74
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVets"})
        }
      """
    )
  
    // @LINE:76
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:85
    def vetExists: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VetController.vetExists",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vetExists"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseAdoptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allAdoptions"})
        }
      """
    )
  
    // @LINE:52
    def animalAdminApproved: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdminApproved",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdminApproved"})
        }
      """
    )
  
    // @LINE:46
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.read",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:37
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adoption"})
        }
      """
    )
  
    // @LINE:39
    def adminApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.adminApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adminApprove"})
        }
      """
    )
  
    // @LINE:44
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteAdoption/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:41
    def vetApprove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.vetApprove",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vetApprove"})
        }
      """
    )
  
    // @LINE:50
    def animalAdopted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.animalAdopted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "animalAdopted"})
        }
      """
    )
  
    // @LINE:48
    def readByUserAndAnimalId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdoptionController.readByUserAndAnimalId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readByUserAndAnimalId"})
        }
      """
    )
  
  }

  // @LINE:88
  class ReverseVaccineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:88
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vaccine"})
        }
      """
    )
  
    // @LINE:89
    def readAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allVaccines"})
        }
      """
    )
  
    // @LINE:91
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.delete",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVaccine/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:93
    def readAllAnimalVaccines: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VaccineController.readAllAnimalVaccines",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "readAllAnimalVaccines"})
        }
      """
    )
  
  }


}
