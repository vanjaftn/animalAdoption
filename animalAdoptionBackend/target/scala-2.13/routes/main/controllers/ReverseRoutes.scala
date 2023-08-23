// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:150
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:150
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:124
  class ReversePhotoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:127
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allPhotos")
    }
  
    // @LINE:126
    def adopterAddPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopterAddPhotos")
    }
  
    // @LINE:124
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "photo")
    }
  
    // @LINE:133
    def readAllAnimalPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "allAnimalPhotos")
    }
  
    // @LINE:129
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePhoto/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:131
    def uploadMedia: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "uploadMedia")
    }
  
  }

  // @LINE:81
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:81
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:82
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdmins")
    }
  
    // @LINE:83
    def adminExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminExists")
    }
  
    // @LINE:85
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdmin/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:146
  class ReverseAnimalTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:146
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalType")
    }
  
    // @LINE:147
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimalTypes")
    }
  
  }

  // @LINE:28
  class ReverseAnimalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimals")
    }
  
    // @LINE:37
    def readAllUsersSubscribedAnimals: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsersSubscribedAnimals")
    }
  
    // @LINE:34
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "animal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:39
    def animalIsSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalIsSterilized")
    }
  
    // @LINE:36
    def readAllUnadopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUnadoptedAnimals")
    }
  
    // @LINE:28
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animal")
    }
  
    // @LINE:35
    def readAllAdopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptedAnimals")
    }
  
    // @LINE:41
    def animalSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalSterilized")
    }
  
    // @LINE:33
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAnimal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:43
    def search: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchAnimal")
    }
  
    // @LINE:31
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAnimal")
    }
  
  }

  // @LINE:70
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allSubscriptions")
    }
  
    // @LINE:76
    def subscriptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionExists")
    }
  
    // @LINE:71
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:70
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscription")
    }
  
    // @LINE:74
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSubscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:78
    def readSubscriptionByAnimalAndUserId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionByAnimalId")
    }
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsers")
    }
  
    // @LINE:10
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:18
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:25
    def readAllAnimalAdminApprovedAdopters: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalAdminApprovedAdopters")
    }
  
    // @LINE:12
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:21
    def readLoggedInUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loggedInUser")
    }
  
    // @LINE:20
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:16
    def passwordExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "passwordExists")
    }
  
    // @LINE:14
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUser")
    }
  
    // @LINE:23
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

  // @LINE:136
  class ReverseVideoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:139
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVideos")
    }
  
    // @LINE:138
    def adopterAddPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopterAddVideos")
    }
  
    // @LINE:136
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "video")
    }
  
    // @LINE:141
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVideo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:143
    def readAllAnimalVideos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "allAnimalVideos")
    }
  
  }

  // @LINE:94
  class ReverseAdopterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:94
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopter")
    }
  
    // @LINE:95
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdopters")
    }
  
    // @LINE:97
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdopter/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:88
  class ReverseVetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:88
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vet")
    }
  
    // @LINE:89
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVets")
    }
  
    // @LINE:91
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:101
    def vetExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vetExists")
    }
  
  }

  // @LINE:46
  class ReverseAdoptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def deleteApproved(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteApproved/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:51
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptions")
    }
  
    // @LINE:65
    def animalAdminApproved: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdminApproved")
    }
  
    // @LINE:59
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:46
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoption")
    }
  
    // @LINE:55
    def deletePending(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePending/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:67
    def adoptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoptionExists")
    }
  
    // @LINE:48
    def adminApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApprove")
    }
  
    // @LINE:53
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:50
    def vetApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vetApprove")
    }
  
    // @LINE:63
    def animalAdopted: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdopted")
    }
  
    // @LINE:61
    def readByUserAndAnimalId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readByUserAndAnimalId")
    }
  
  }

  // @LINE:104
  class ReverseVaccineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:104
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vaccine")
    }
  
    // @LINE:105
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVaccines")
    }
  
    // @LINE:107
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVaccine/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:109
    def readAllAnimalVaccines: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalVaccines")
    }
  
  }

  // @LINE:112
  class ReverseLostAndFoundController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:115
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostAndFound")
    }
  
    // @LINE:117
    def readAllFound: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allFound")
    }
  
    // @LINE:114
    def createFound: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "found")
    }
  
    // @LINE:116
    def readAllLost: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLost")
    }
  
    // @LINE:121
    def adminApproveLAF: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApproveLAF")
    }
  
    // @LINE:112
    def createLost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lost")
    }
  
    // @LINE:119
    def readAllFoundNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllFoundNotApproved")
    }
  
    // @LINE:118
    def readAllLostNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllLostNotApproved")
    }
  
  }


}
