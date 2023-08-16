// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:49
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:42
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:43
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdmin")
    }
  
    // @LINE:44
    def adminExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminExists")
    }
  
    // @LINE:46
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdmin/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:17
  class ReverseAnimalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimals")
    }
  
    // @LINE:24
    def readAllUsersSubscribedAnimals: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsersSubscribedAnimals")
    }
  
    // @LINE:22
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "animal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animal")
    }
  
    // @LINE:23
    def readAllAdopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptedAnimals")
    }
  
    // @LINE:21
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAnimal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:19
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAnimal")
    }
  
  }

  // @LINE:31
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allSubscriptions")
    }
  
    // @LINE:37
    def subscriptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionExists")
    }
  
    // @LINE:32
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:31
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscription")
    }
  
    // @LINE:35
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSubscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:39
    def readSubscriptionByAnimalAndUserId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionByAnimalId")
    }
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsers")
    }
  
    // @LINE:10
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:13
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:11
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:14
    def readLoggedInUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loggedInUser")
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

  // @LINE:26
  class ReverseAdoptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoption")
    }
  
    // @LINE:27
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptions")
    }
  
    // @LINE:28
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }


}
