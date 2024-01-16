// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:166
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:166
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:140
  class ReversePhotoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:143
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allPhotos")
    }
  
    // @LINE:142
    def adopterAddPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopterAddPhotos")
    }
  
    // @LINE:140
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "photo")
    }
  
    // @LINE:149
    def readAllAnimalPhotos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "allAnimalPhotos")
    }
  
    // @LINE:145
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePhoto/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:147
    def uploadMedia: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "uploadMedia")
    }
  
  }

  // @LINE:85
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:85
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:86
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdmins")
    }
  
    // @LINE:87
    def adminExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adminExists")
    }
  
    // @LINE:89
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdmin/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:162
  class ReverseAnimalTypeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:162
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalType")
    }
  
    // @LINE:163
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimalTypes")
    }
  
  }

  // @LINE:31
  class ReverseAnimalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAnimals")
    }
  
    // @LINE:40
    def readAllUsersSubscribedAnimals: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsersSubscribedAnimals")
    }
  
    // @LINE:37
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "animal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:42
    def animalIsSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalIsSterilized")
    }
  
    // @LINE:39
    def readAllUnadopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUnadoptedAnimals")
    }
  
    // @LINE:31
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animal")
    }
  
    // @LINE:38
    def readAllAdopted: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptedAnimals")
    }
  
    // @LINE:44
    def animalSterilized: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalSterilized")
    }
  
    // @LINE:36
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAnimal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:46
    def search: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchAnimal")
    }
  
    // @LINE:34
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateAnimal")
    }
  
  }

  // @LINE:74
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:76
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allSubscriptions")
    }
  
    // @LINE:80
    def subscriptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionExists")
    }
  
    // @LINE:75
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:74
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscription")
    }
  
    // @LINE:78
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteSubscription/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:82
    def readSubscriptionByAnimalAndUserId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "subscriptionByAnimalId")
    }
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allUsers")
    }
  
    // @LINE:10
    def loginUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:19
    def read(id:String): Call = {
    
      (id: @unchecked) match {
      
        // @LINE:19
        case (id)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
      
      }
    
    }
  
    // @LINE:26
    def readAllAnimalAdminApprovedAdopters: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalAdminApprovedAdopters")
    }
  
    // @LINE:28
    def forgotPassword: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "forgotPassword")
    }
  
    // @LINE:12
    def confirm: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "confirm")
    }
  
    // @LINE:13
    def create(confirmationCode:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("confirmationCode", confirmationCode)))
    }
  
    // @LINE:22
    def readLoggedInUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "loggedInUser")
    }
  
    // @LINE:21
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def passwordExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "passwordExists")
    }
  
    // @LINE:15
    def update: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateUser")
    }
  
    // @LINE:24
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

  // @LINE:152
  class ReverseVideoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:155
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVideos")
    }
  
    // @LINE:152
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "video")
    }
  
    // @LINE:157
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVideo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:154
    def adopterAddVideos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopterAddVideos")
    }
  
    // @LINE:159
    def readAllAnimalVideos: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "allAnimalVideos")
    }
  
  }

  // @LINE:99
  class ReverseAdopterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:99
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adopter")
    }
  
    // @LINE:100
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdopters")
    }
  
    // @LINE:102
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdopter/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:104
    def adopterExist: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adopterExist")
    }
  
  }

  // @LINE:92
  class ReverseVetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:92
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vet")
    }
  
    // @LINE:94
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVets")
    }
  
    // @LINE:96
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:107
    def vetExists: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vetExists")
    }
  
  }

  // @LINE:49
  class ReverseAdoptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def deleteApproved(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteApproved/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:54
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allAdoptions")
    }
  
    // @LINE:68
    def animalAdminApproved: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdminApproved")
    }
  
    // @LINE:62
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:49
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adoption")
    }
  
    // @LINE:58
    def deletePending(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deletePending/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:72
    def readAllUsersApprovedAdoptions: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllUsersApprovedAdoptions")
    }
  
    // @LINE:51
    def adminApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApprove")
    }
  
    // @LINE:56
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteAdoption/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:53
    def vetApprove: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vetApprove")
    }
  
    // @LINE:70
    def approvedAdoptionExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "approvedAdoptionExists")
    }
  
    // @LINE:66
    def animalAdopted: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "animalAdopted")
    }
  
    // @LINE:64
    def readByUserAndAnimalId: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readByUserAndAnimalId")
    }
  
    // @LINE:71
    def readAllUsersAdoptions: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllUsersAdoptions")
    }
  
  }

  // @LINE:110
  class ReverseVaccineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:110
    def create: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vaccine")
    }
  
    // @LINE:111
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allVaccines")
    }
  
    // @LINE:113
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteVaccine/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:115
    def readAllAnimalVaccines: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "readAllAnimalVaccines")
    }
  
  }

  // @LINE:118
  class ReverseLostAndFoundController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:121
    def readAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostAndFound")
    }
  
    // @LINE:123
    def readAllApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostAndFoundApproved")
    }
  
    // @LINE:122
    def readAllNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostAndFoundNotApproved")
    }
  
    // @LINE:135
    def readByAnimalId(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lostAndFoundByAnimalId/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:132
    def read(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lostAndFound/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:127
    def readAllFound: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allFound")
    }
  
    // @LINE:120
    def createFound: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "found")
    }
  
    // @LINE:124
    def readAllLostApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLostApproved")
    }
  
    // @LINE:137
    def lostAndFoundExists: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lostAndFoundExists")
    }
  
    // @LINE:126
    def readAllLost: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allLost")
    }
  
    // @LINE:131
    def adminApproveLAF: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adminApproveLAF")
    }
  
    // @LINE:134
    def delete(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "deleteLostAndFound/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:118
    def createLost: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "lost")
    }
  
    // @LINE:125
    def readAllFoundApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allFoundApproved")
    }
  
    // @LINE:129
    def readAllFoundNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllFoundNotApproved")
    }
  
    // @LINE:128
    def readAllLostNotApproved: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readAllLostNotApproved")
    }
  
  }


}
