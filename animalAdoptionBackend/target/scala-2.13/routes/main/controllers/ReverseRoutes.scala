// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:134
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:134
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:118
  class ReversePhotoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:121
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allPhotos")
    }
  
    // @LINE:120
    def adopterAddPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopterAddPhotos")
    }
  
    // @LINE:118
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "photo")
    }
  
    // @LINE:125
    def uploadPhoto: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "uploadPhoto")
    }
  
    // @LINE:127
    def readAllAnimalPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "allAnimalPhotos")
    }
  
    // @LINE:123
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePhoto/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:75
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:76
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdmins")
    }
  
    // @LINE:77
    def adminExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminExists")
    }
  
    // @LINE:79
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdmin/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:130
  class ReverseAnimalTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:130
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalType")
    }
  
    // @LINE:131
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimalTypes")
    }
  
  }

  // @LINE:26
  class ReverseAnimalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimals")
    }
  
    // @LINE:35
    def readAllUsersSubscribedAnimals: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsersSubscribedAnimals")
    }
  
    // @LINE:32
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "animal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:37
    def animalIsSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalIsSterilized")
    }
  
    // @LINE:34
    def readAllUnadopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUnadoptedAnimals")
    }
  
    // @LINE:26
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animal")
    }
  
    // @LINE:33
    def readAllAdopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptedAnimals")
    }
  
    // @LINE:39
    def animalSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalSterilized")
    }
  
    // @LINE:31
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAnimal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:41
    def search: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchAnimal")
    }
  
    // @LINE:29
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAnimal")
    }
  
  }

  // @LINE:64
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allSubscriptions")
    }
  
    // @LINE:70
    def subscriptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionExists")
    }
  
    // @LINE:65
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:64
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscription")
    }
  
    // @LINE:68
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSubscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:72
    def readSubscriptionByAnimalAndUserId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionByAnimalId")
    }
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsers")
    }
  
    // @LINE:10
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:16
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:23
    def readAllAnimalAdminApprovedAdopters: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalAdminApprovedAdopters")
    }
  
    // @LINE:12
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:19
    def readLoggedInUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loggedInUser")
    }
  
    // @LINE:18
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:14
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUser")
    }
  
    // @LINE:21
    def readAllAnimalPendingAdopters: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalPendingAdopters")
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

  // @LINE:88
  class ReverseAdopterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:88
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopter")
    }
  
    // @LINE:89
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdopters")
    }
  
    // @LINE:91
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdopter/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:82
  class ReverseVetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vet")
    }
  
    // @LINE:83
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVets")
    }
  
    // @LINE:85
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:95
    def vetExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vetExists")
    }
  
  }

  // @LINE:44
  class ReverseAdoptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptions")
    }
  
    // @LINE:59
    def animalAdminApproved: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdminApproved")
    }
  
    // @LINE:53
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:44
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoption")
    }
  
    // @LINE:61
    def adoptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoptionExists")
    }
  
    // @LINE:46
    def adminApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApprove")
    }
  
    // @LINE:51
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:48
    def vetApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vetApprove")
    }
  
    // @LINE:57
    def animalAdopted: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdopted")
    }
  
    // @LINE:55
    def readByUserAndAnimalId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readByUserAndAnimalId")
    }
  
  }

  // @LINE:98
  class ReverseVaccineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:98
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vaccine")
    }
  
    // @LINE:99
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVaccines")
    }
  
    // @LINE:101
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVaccine/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:103
    def readAllAnimalVaccines: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalVaccines")
    }
  
  }

  // @LINE:106
  class ReverseLostAndFoundController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:109
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostAndFound")
    }
  
    // @LINE:111
    def readAllFound: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allFound")
    }
  
    // @LINE:108
    def createFound: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "found")
    }
  
    // @LINE:110
    def readAllLost: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLost")
    }
  
    // @LINE:115
    def adminApproveLAF: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApproveLAF")
    }
  
    // @LINE:106
    def createLost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lost")
    }
  
    // @LINE:113
    def readAllFoundNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllFoundNotApproved")
    }
  
    // @LINE:112
    def readAllLostNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllLostNotApproved")
    }
  
  }


}
