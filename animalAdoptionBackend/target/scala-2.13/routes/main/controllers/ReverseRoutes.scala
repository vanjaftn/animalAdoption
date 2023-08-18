// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:90
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:90
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:60
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:61
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdmins")
    }
  
    // @LINE:62
    def adminExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminExists")
    }
  
    // @LINE:64
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdmin/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:22
  class ReverseAnimalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimals")
    }
  
    // @LINE:29
    def readAllUsersSubscribedAnimals: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsersSubscribedAnimals")
    }
  
    // @LINE:27
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "animal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:31
    def animalIsSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalIsSterilized")
    }
  
    // @LINE:22
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animal")
    }
  
    // @LINE:28
    def readAllAdopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptedAnimals")
    }
  
    // @LINE:33
    def animalSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalSterilized")
    }
  
    // @LINE:26
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAnimal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:24
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAnimal")
    }
  
  }

  // @LINE:49
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:51
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allSubscriptions")
    }
  
    // @LINE:55
    def subscriptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionExists")
    }
  
    // @LINE:50
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:49
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscription")
    }
  
    // @LINE:53
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSubscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:57
    def readSubscriptionByAnimalAndUserId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionByAnimalId")
    }
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsers")
    }
  
    // @LINE:10
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:14
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:12
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:19
    def readAllAnimalPendingAdoptions: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalPendingAdoptions")
    }
  
    // @LINE:17
    def readLoggedInUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loggedInUser")
    }
  
    // @LINE:16
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:73
  class ReverseAdopterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:73
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopter")
    }
  
    // @LINE:74
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdopters")
    }
  
    // @LINE:76
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdopter/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:67
  class ReverseVetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:67
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vet")
    }
  
    // @LINE:68
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVets")
    }
  
    // @LINE:70
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:79
    def vetExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vetExists")
    }
  
  }

  // @LINE:35
  class ReverseAdoptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptions")
    }
  
    // @LINE:42
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:35
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoption")
    }
  
    // @LINE:37
    def adminApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApprove")
    }
  
    // @LINE:40
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:46
    def animalAdopted: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdopted")
    }
  
    // @LINE:44
    def readByUserAndAnimalId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readByUserAndAnimalId")
    }
  
  }

  // @LINE:82
  class ReverseVaccineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vaccine")
    }
  
    // @LINE:83
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVaccines")
    }
  
    // @LINE:85
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVaccine/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:87
    def readAllAnimalVaccines: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalVaccines")
    }
  
  }


}
