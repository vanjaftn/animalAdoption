// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_13: controllers.HomeController,
  // @LINE:10
  UserController_11: controllers.UserController,
  // @LINE:31
  AnimalController_7: controllers.AnimalController,
  // @LINE:49
  AdoptionController_6: controllers.AdoptionController,
  // @LINE:74
  SubscriptionController_5: controllers.SubscriptionController,
  // @LINE:85
  AdminController_9: controllers.AdminController,
  // @LINE:92
  VetController_8: controllers.VetController,
  // @LINE:99
  AdopterController_2: controllers.AdopterController,
  // @LINE:110
  VaccineController_1: controllers.VaccineController,
  // @LINE:118
  LostAndFoundController_4: controllers.LostAndFoundController,
  // @LINE:140
  PhotoController_10: controllers.PhotoController,
  // @LINE:152
  VideoController_0: controllers.VideoController,
  // @LINE:162
  AnimalTypeController_3: controllers.AnimalTypeController,
  // @LINE:166
  Assets_12: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_13: controllers.HomeController,
    // @LINE:10
    UserController_11: controllers.UserController,
    // @LINE:31
    AnimalController_7: controllers.AnimalController,
    // @LINE:49
    AdoptionController_6: controllers.AdoptionController,
    // @LINE:74
    SubscriptionController_5: controllers.SubscriptionController,
    // @LINE:85
    AdminController_9: controllers.AdminController,
    // @LINE:92
    VetController_8: controllers.VetController,
    // @LINE:99
    AdopterController_2: controllers.AdopterController,
    // @LINE:110
    VaccineController_1: controllers.VaccineController,
    // @LINE:118
    LostAndFoundController_4: controllers.LostAndFoundController,
    // @LINE:140
    PhotoController_10: controllers.PhotoController,
    // @LINE:152
    VideoController_0: controllers.VideoController,
    // @LINE:162
    AnimalTypeController_3: controllers.AnimalTypeController,
    // @LINE:166
    Assets_12: controllers.Assets
  ) = this(errorHandler, HomeController_13, UserController_11, AnimalController_7, AdoptionController_6, SubscriptionController_5, AdminController_9, VetController_8, AdopterController_2, VaccineController_1, LostAndFoundController_4, PhotoController_10, VideoController_0, AnimalTypeController_3, Assets_12, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_13, UserController_11, AnimalController_7, AdoptionController_6, SubscriptionController_5, AdminController_9, VetController_8, AdopterController_2, VaccineController_1, LostAndFoundController_4, PhotoController_10, VideoController_0, AnimalTypeController_3, Assets_12, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.loginUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """confirm""", """controllers.UserController.confirm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """confirmationCode<[^/]+>""", """controllers.UserController.create(confirmationCode:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateUser""", """controllers.UserController.update"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """passwordExists""", """controllers.UserController.passwordExists"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUsers""", """controllers.UserController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteUser/""" + "$" + """id<[^/]+>""", """controllers.UserController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loggedInUser""", """controllers.UserController.readLoggedInUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalPendingAdopters""", """controllers.UserController.readAllAnimalPendingAdopters"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalAdminApprovedAdopters""", """controllers.UserController.readAllAnimalAdminApprovedAdopters"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotPassword""", """controllers.UserController.forgotPassword"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal""", """controllers.AnimalController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimals""", """controllers.AnimalController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateAnimal""", """controllers.AnimalController.update"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAnimal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.read(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdoptedAnimals""", """controllers.AnimalController.readAllAdopted"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUnadoptedAnimals""", """controllers.AnimalController.readAllUnadopted"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUsersSubscribedAnimals""", """controllers.AnimalController.readAllUsersSubscribedAnimals"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalIsSterilized""", """controllers.AnimalController.animalIsSterilized"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalSterilized""", """controllers.AnimalController.animalSterilized"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchAnimal""", """controllers.AnimalController.search"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoption""", """controllers.AdoptionController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminApprove""", """controllers.AdoptionController.adminApprove"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vetApprove""", """controllers.AdoptionController.vetApprove"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdoptions""", """controllers.AdoptionController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdoption/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletePending/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.deletePending(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteApproved/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.deleteApproved(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoption/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readByUserAndAnimalId""", """controllers.AdoptionController.readByUserAndAnimalId"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalAdopted""", """controllers.AdoptionController.animalAdopted"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalAdminApproved""", """controllers.AdoptionController.animalAdminApproved"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoptionExists""", """controllers.AdoptionController.adoptionExists"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllUsersAdoptions""", """controllers.AdoptionController.readAllUsersAdoptions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllUsersApprovedAdoptions""", """controllers.AdoptionController.readAllUsersApprovedAdoptions"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscription""", """controllers.SubscriptionController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscription/""" + "$" + """id<[^/]+>""", """controllers.SubscriptionController.read(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allSubscriptions""", """controllers.SubscriptionController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteSubscription/""" + "$" + """id<[^/]+>""", """controllers.SubscriptionController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscriptionExists""", """controllers.SubscriptionController.subscriptionExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscriptionByAnimalId""", """controllers.SubscriptionController.readSubscriptionByAnimalAndUserId"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin""", """controllers.AdminController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdmins""", """controllers.AdminController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminExists""", """controllers.AdminController.adminExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdmin/""" + "$" + """id<[^/]+>""", """controllers.AdminController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vet""", """controllers.VetController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vet/""" + "$" + """id<[^/]+>""", """controllers.UserController.read(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allVets""", """controllers.VetController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVet/""" + "$" + """id<[^/]+>""", """controllers.VetController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adopter""", """controllers.AdopterController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdopters""", """controllers.AdopterController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdopter/""" + "$" + """id<[^/]+>""", """controllers.AdopterController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adopterExist""", """controllers.AdopterController.adopterExist"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vetExists""", """controllers.VetController.vetExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vaccine""", """controllers.VaccineController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allVaccines""", """controllers.VaccineController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVaccine/""" + "$" + """id<[^/]+>""", """controllers.VaccineController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalVaccines""", """controllers.VaccineController.readAllAnimalVaccines"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lost""", """controllers.LostAndFoundController.createLost"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """found""", """controllers.LostAndFoundController.createFound"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLostAndFound""", """controllers.LostAndFoundController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLostAndFoundNotApproved""", """controllers.LostAndFoundController.readAllNotApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLostAndFoundApproved""", """controllers.LostAndFoundController.readAllApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLostApproved""", """controllers.LostAndFoundController.readAllLostApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allFoundApproved""", """controllers.LostAndFoundController.readAllFoundApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLost""", """controllers.LostAndFoundController.readAllLost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allFound""", """controllers.LostAndFoundController.readAllFound"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllLostNotApproved""", """controllers.LostAndFoundController.readAllLostNotApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllFoundNotApproved""", """controllers.LostAndFoundController.readAllFoundNotApproved"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminApproveLAF""", """controllers.LostAndFoundController.adminApproveLAF"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lostAndFound/""" + "$" + """id<[^/]+>""", """controllers.LostAndFoundController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteLostAndFound/""" + "$" + """id<[^/]+>""", """controllers.LostAndFoundController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lostAndFoundByAnimalId/""" + "$" + """id<[^/]+>""", """controllers.LostAndFoundController.readByAnimalId(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lostAndFoundExists""", """controllers.LostAndFoundController.lostAndFoundExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """photo""", """controllers.PhotoController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adopterAddPhotos""", """controllers.PhotoController.adopterAddPhotos"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allPhotos""", """controllers.PhotoController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletePhoto/""" + "$" + """id<[^/]+>""", """controllers.PhotoController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uploadMedia""", """controllers.PhotoController.uploadMedia"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimalPhotos""", """controllers.PhotoController.readAllAnimalPhotos"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """video""", """controllers.VideoController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adopterAddVideos""", """controllers.VideoController.adopterAddVideos"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allVideos""", """controllers.VideoController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVideo/""" + "$" + """id<[^/]+>""", """controllers.VideoController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimalVideos""", """controllers.VideoController.readAllAnimalVideos"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalType""", """controllers.AnimalTypeController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimalTypes""", """controllers.AnimalTypeController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_13.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_loginUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_loginUser1_invoker = createInvoker(
    UserController_11.loginUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "loginUser",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_confirm2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("confirm")))
  )
  private[this] lazy val controllers_UserController_confirm2_invoker = createInvoker(
    UserController_11.confirm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "confirm",
      Nil,
      "POST",
      this.prefix + """confirm""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_create3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("confirmationCode", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_create3_invoker = createInvoker(
    UserController_11.create(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "create",
      Seq(classOf[String]),
      "GET",
      this.prefix + """user/""" + "$" + """confirmationCode<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_update4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateUser")))
  )
  private[this] lazy val controllers_UserController_update4_invoker = createInvoker(
    UserController_11.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "update",
      Nil,
      "POST",
      this.prefix + """updateUser""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UserController_passwordExists5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("passwordExists")))
  )
  private[this] lazy val controllers_UserController_passwordExists5_invoker = createInvoker(
    UserController_11.passwordExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "passwordExists",
      Nil,
      "POST",
      this.prefix + """passwordExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UserController_readAll6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsers")))
  )
  private[this] lazy val controllers_UserController_readAll6_invoker = createInvoker(
    UserController_11.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allUsers""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UserController_read7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_read7_invoker = createInvoker(
    UserController_11.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UserController_delete8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_delete8_invoker = createInvoker(
    UserController_11.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteUser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UserController_readLoggedInUser9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loggedInUser")))
  )
  private[this] lazy val controllers_UserController_readLoggedInUser9_invoker = createInvoker(
    UserController_11.readLoggedInUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "readLoggedInUser",
      Nil,
      "GET",
      this.prefix + """loggedInUser""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdopters10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalPendingAdopters")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdopters10_invoker = createInvoker(
    UserController_11.readAllAnimalPendingAdopters,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "readAllAnimalPendingAdopters",
      Nil,
      "POST",
      this.prefix + """readAllAnimalPendingAdopters""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:26
  private[this] lazy val controllers_UserController_readAllAnimalAdminApprovedAdopters11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalAdminApprovedAdopters")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalAdminApprovedAdopters11_invoker = createInvoker(
    UserController_11.readAllAnimalAdminApprovedAdopters,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "readAllAnimalAdminApprovedAdopters",
      Nil,
      "POST",
      this.prefix + """readAllAnimalAdminApprovedAdopters""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:28
  private[this] lazy val controllers_UserController_forgotPassword12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPassword")))
  )
  private[this] lazy val controllers_UserController_forgotPassword12_invoker = createInvoker(
    UserController_11.forgotPassword,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "forgotPassword",
      Nil,
      "POST",
      this.prefix + """forgotPassword""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:31
  private[this] lazy val controllers_AnimalController_create13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal")))
  )
  private[this] lazy val controllers_AnimalController_create13_invoker = createInvoker(
    AnimalController_7.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "create",
      Nil,
      "POST",
      this.prefix + """animal""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:32
  private[this] lazy val controllers_AnimalController_readAll14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAll14_invoker = createInvoker(
    AnimalController_7.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAnimals""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_AnimalController_update15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateAnimal")))
  )
  private[this] lazy val controllers_AnimalController_update15_invoker = createInvoker(
    AnimalController_7.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "update",
      Nil,
      "POST",
      this.prefix + """updateAnimal""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:36
  private[this] lazy val controllers_AnimalController_delete16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAnimal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_delete16_invoker = createInvoker(
    AnimalController_7.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteAnimal/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:37
  private[this] lazy val controllers_AnimalController_read17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_read17_invoker = createInvoker(
    AnimalController_7.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """animal/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_AnimalController_readAllAdopted18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllAdopted18_invoker = createInvoker(
    AnimalController_7.readAllAdopted,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "readAllAdopted",
      Nil,
      "GET",
      this.prefix + """allAdoptedAnimals""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_AnimalController_readAllUnadopted19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUnadoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUnadopted19_invoker = createInvoker(
    AnimalController_7.readAllUnadopted,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "readAllUnadopted",
      Nil,
      "GET",
      this.prefix + """allUnadoptedAnimals""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsersSubscribedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals20_invoker = createInvoker(
    AnimalController_7.readAllUsersSubscribedAnimals,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "readAllUsersSubscribedAnimals",
      Nil,
      "GET",
      this.prefix + """allUsersSubscribedAnimals""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_AnimalController_animalIsSterilized21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalIsSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalIsSterilized21_invoker = createInvoker(
    AnimalController_7.animalIsSterilized,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "animalIsSterilized",
      Nil,
      "POST",
      this.prefix + """animalIsSterilized""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:44
  private[this] lazy val controllers_AnimalController_animalSterilized22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalSterilized22_invoker = createInvoker(
    AnimalController_7.animalSterilized,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "animalSterilized",
      Nil,
      "POST",
      this.prefix + """animalSterilized""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:46
  private[this] lazy val controllers_AnimalController_search23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchAnimal")))
  )
  private[this] lazy val controllers_AnimalController_search23_invoker = createInvoker(
    AnimalController_7.search,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "search",
      Nil,
      "POST",
      this.prefix + """searchAnimal""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:49
  private[this] lazy val controllers_AdoptionController_create24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption")))
  )
  private[this] lazy val controllers_AdoptionController_create24_invoker = createInvoker(
    AdoptionController_6.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "create",
      Nil,
      "POST",
      this.prefix + """adoption""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:51
  private[this] lazy val controllers_AdoptionController_adminApprove25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApprove")))
  )
  private[this] lazy val controllers_AdoptionController_adminApprove25_invoker = createInvoker(
    AdoptionController_6.adminApprove,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "adminApprove",
      Nil,
      "POST",
      this.prefix + """adminApprove""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:53
  private[this] lazy val controllers_AdoptionController_vetApprove26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vetApprove")))
  )
  private[this] lazy val controllers_AdoptionController_vetApprove26_invoker = createInvoker(
    AdoptionController_6.vetApprove,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "vetApprove",
      Nil,
      "POST",
      this.prefix + """vetApprove""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:54
  private[this] lazy val controllers_AdoptionController_readAll27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAll27_invoker = createInvoker(
    AdoptionController_6.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAdoptions""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_AdoptionController_delete28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_delete28_invoker = createInvoker(
    AdoptionController_6.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteAdoption/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:58
  private[this] lazy val controllers_AdoptionController_deletePending29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletePending/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_deletePending29_invoker = createInvoker(
    AdoptionController_6.deletePending(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "deletePending",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deletePending/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:60
  private[this] lazy val controllers_AdoptionController_deleteApproved30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteApproved/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_deleteApproved30_invoker = createInvoker(
    AdoptionController_6.deleteApproved(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "deleteApproved",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteApproved/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:62
  private[this] lazy val controllers_AdoptionController_read31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_read31_invoker = createInvoker(
    AdoptionController_6.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """adoption/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:64
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readByUserAndAnimalId")))
  )
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId32_invoker = createInvoker(
    AdoptionController_6.readByUserAndAnimalId,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "readByUserAndAnimalId",
      Nil,
      "POST",
      this.prefix + """readByUserAndAnimalId""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:66
  private[this] lazy val controllers_AdoptionController_animalAdopted33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdopted")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdopted33_invoker = createInvoker(
    AdoptionController_6.animalAdopted,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "animalAdopted",
      Nil,
      "POST",
      this.prefix + """animalAdopted""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:68
  private[this] lazy val controllers_AdoptionController_animalAdminApproved34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdminApproved")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdminApproved34_invoker = createInvoker(
    AdoptionController_6.animalAdminApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "animalAdminApproved",
      Nil,
      "POST",
      this.prefix + """animalAdminApproved""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:70
  private[this] lazy val controllers_AdoptionController_adoptionExists35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoptionExists")))
  )
  private[this] lazy val controllers_AdoptionController_adoptionExists35_invoker = createInvoker(
    AdoptionController_6.adoptionExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "adoptionExists",
      Nil,
      "POST",
      this.prefix + """adoptionExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:71
  private[this] lazy val controllers_AdoptionController_readAllUsersAdoptions36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllUsersAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAllUsersAdoptions36_invoker = createInvoker(
    AdoptionController_6.readAllUsersAdoptions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "readAllUsersAdoptions",
      Nil,
      "GET",
      this.prefix + """readAllUsersAdoptions""",
      """""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_AdoptionController_readAllUsersApprovedAdoptions37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllUsersApprovedAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAllUsersApprovedAdoptions37_invoker = createInvoker(
    AdoptionController_6.readAllUsersApprovedAdoptions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdoptionController",
      "readAllUsersApprovedAdoptions",
      Nil,
      "GET",
      this.prefix + """readAllUsersApprovedAdoptions""",
      """""",
      Seq()
    )
  )

  // @LINE:74
  private[this] lazy val controllers_SubscriptionController_create38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription")))
  )
  private[this] lazy val controllers_SubscriptionController_create38_invoker = createInvoker(
    SubscriptionController_5.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "create",
      Nil,
      "POST",
      this.prefix + """subscription""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:75
  private[this] lazy val controllers_SubscriptionController_read39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_read39_invoker = createInvoker(
    SubscriptionController_5.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """subscription/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_SubscriptionController_readAll40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allSubscriptions")))
  )
  private[this] lazy val controllers_SubscriptionController_readAll40_invoker = createInvoker(
    SubscriptionController_5.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allSubscriptions""",
      """""",
      Seq()
    )
  )

  // @LINE:78
  private[this] lazy val controllers_SubscriptionController_delete41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSubscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_delete41_invoker = createInvoker(
    SubscriptionController_5.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteSubscription/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:80
  private[this] lazy val controllers_SubscriptionController_subscriptionExists42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionExists")))
  )
  private[this] lazy val controllers_SubscriptionController_subscriptionExists42_invoker = createInvoker(
    SubscriptionController_5.subscriptionExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "subscriptionExists",
      Nil,
      "POST",
      this.prefix + """subscriptionExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:82
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionByAnimalId")))
  )
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId43_invoker = createInvoker(
    SubscriptionController_5.readSubscriptionByAnimalAndUserId,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "readSubscriptionByAnimalAndUserId",
      Nil,
      "POST",
      this.prefix + """subscriptionByAnimalId""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:85
  private[this] lazy val controllers_AdminController_create44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_AdminController_create44_invoker = createInvoker(
    AdminController_9.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "create",
      Nil,
      "POST",
      this.prefix + """admin""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:86
  private[this] lazy val controllers_AdminController_readAll45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdmins")))
  )
  private[this] lazy val controllers_AdminController_readAll45_invoker = createInvoker(
    AdminController_9.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAdmins""",
      """""",
      Seq()
    )
  )

  // @LINE:87
  private[this] lazy val controllers_AdminController_adminExists46_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminExists")))
  )
  private[this] lazy val controllers_AdminController_adminExists46_invoker = createInvoker(
    AdminController_9.adminExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "adminExists",
      Nil,
      "GET",
      this.prefix + """adminExists""",
      """""",
      Seq()
    )
  )

  // @LINE:89
  private[this] lazy val controllers_AdminController_delete47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdmin/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_delete47_invoker = createInvoker(
    AdminController_9.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteAdmin/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:92
  private[this] lazy val controllers_VetController_create48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vet")))
  )
  private[this] lazy val controllers_VetController_create48_invoker = createInvoker(
    VetController_8.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VetController",
      "create",
      Nil,
      "POST",
      this.prefix + """vet""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:93
  private[this] lazy val controllers_UserController_read49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vet/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_read49_invoker = createInvoker(
    UserController_11.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """vet/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_VetController_readAll50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVets")))
  )
  private[this] lazy val controllers_VetController_readAll50_invoker = createInvoker(
    VetController_8.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VetController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allVets""",
      """""",
      Seq()
    )
  )

  // @LINE:96
  private[this] lazy val controllers_VetController_delete51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVet/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VetController_delete51_invoker = createInvoker(
    VetController_8.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VetController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteVet/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:99
  private[this] lazy val controllers_AdopterController_create52_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopter")))
  )
  private[this] lazy val controllers_AdopterController_create52_invoker = createInvoker(
    AdopterController_2.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdopterController",
      "create",
      Nil,
      "POST",
      this.prefix + """adopter""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:100
  private[this] lazy val controllers_AdopterController_readAll53_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdopters")))
  )
  private[this] lazy val controllers_AdopterController_readAll53_invoker = createInvoker(
    AdopterController_2.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdopterController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAdopters""",
      """""",
      Seq()
    )
  )

  // @LINE:102
  private[this] lazy val controllers_AdopterController_delete54_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdopter/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdopterController_delete54_invoker = createInvoker(
    AdopterController_2.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdopterController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteAdopter/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:104
  private[this] lazy val controllers_AdopterController_adopterExist55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopterExist")))
  )
  private[this] lazy val controllers_AdopterController_adopterExist55_invoker = createInvoker(
    AdopterController_2.adopterExist,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdopterController",
      "adopterExist",
      Nil,
      "GET",
      this.prefix + """adopterExist""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:107
  private[this] lazy val controllers_VetController_vetExists56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vetExists")))
  )
  private[this] lazy val controllers_VetController_vetExists56_invoker = createInvoker(
    VetController_8.vetExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VetController",
      "vetExists",
      Nil,
      "GET",
      this.prefix + """vetExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:110
  private[this] lazy val controllers_VaccineController_create57_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vaccine")))
  )
  private[this] lazy val controllers_VaccineController_create57_invoker = createInvoker(
    VaccineController_1.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VaccineController",
      "create",
      Nil,
      "POST",
      this.prefix + """vaccine""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:111
  private[this] lazy val controllers_VaccineController_readAll58_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAll58_invoker = createInvoker(
    VaccineController_1.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VaccineController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allVaccines""",
      """""",
      Seq()
    )
  )

  // @LINE:113
  private[this] lazy val controllers_VaccineController_delete59_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVaccine/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VaccineController_delete59_invoker = createInvoker(
    VaccineController_1.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VaccineController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteVaccine/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:115
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines60_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines60_invoker = createInvoker(
    VaccineController_1.readAllAnimalVaccines,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VaccineController",
      "readAllAnimalVaccines",
      Nil,
      "POST",
      this.prefix + """readAllAnimalVaccines""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:118
  private[this] lazy val controllers_LostAndFoundController_createLost61_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lost")))
  )
  private[this] lazy val controllers_LostAndFoundController_createLost61_invoker = createInvoker(
    LostAndFoundController_4.createLost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "createLost",
      Nil,
      "POST",
      this.prefix + """lost""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:120
  private[this] lazy val controllers_LostAndFoundController_createFound62_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("found")))
  )
  private[this] lazy val controllers_LostAndFoundController_createFound62_invoker = createInvoker(
    LostAndFoundController_4.createFound,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "createFound",
      Nil,
      "POST",
      this.prefix + """found""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:121
  private[this] lazy val controllers_LostAndFoundController_readAll63_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLostAndFound")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAll63_invoker = createInvoker(
    LostAndFoundController_4.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allLostAndFound""",
      """""",
      Seq()
    )
  )

  // @LINE:122
  private[this] lazy val controllers_LostAndFoundController_readAllNotApproved64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLostAndFoundNotApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllNotApproved64_invoker = createInvoker(
    LostAndFoundController_4.readAllNotApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllNotApproved",
      Nil,
      "GET",
      this.prefix + """allLostAndFoundNotApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:123
  private[this] lazy val controllers_LostAndFoundController_readAllApproved65_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLostAndFoundApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllApproved65_invoker = createInvoker(
    LostAndFoundController_4.readAllApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllApproved",
      Nil,
      "GET",
      this.prefix + """allLostAndFoundApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:124
  private[this] lazy val controllers_LostAndFoundController_readAllLostApproved66_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLostApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllLostApproved66_invoker = createInvoker(
    LostAndFoundController_4.readAllLostApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllLostApproved",
      Nil,
      "GET",
      this.prefix + """allLostApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:125
  private[this] lazy val controllers_LostAndFoundController_readAllFoundApproved67_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allFoundApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllFoundApproved67_invoker = createInvoker(
    LostAndFoundController_4.readAllFoundApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllFoundApproved",
      Nil,
      "GET",
      this.prefix + """allFoundApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:126
  private[this] lazy val controllers_LostAndFoundController_readAllLost68_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLost")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllLost68_invoker = createInvoker(
    LostAndFoundController_4.readAllLost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllLost",
      Nil,
      "GET",
      this.prefix + """allLost""",
      """""",
      Seq()
    )
  )

  // @LINE:127
  private[this] lazy val controllers_LostAndFoundController_readAllFound69_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allFound")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllFound69_invoker = createInvoker(
    LostAndFoundController_4.readAllFound,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllFound",
      Nil,
      "GET",
      this.prefix + """allFound""",
      """""",
      Seq()
    )
  )

  // @LINE:128
  private[this] lazy val controllers_LostAndFoundController_readAllLostNotApproved70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllLostNotApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllLostNotApproved70_invoker = createInvoker(
    LostAndFoundController_4.readAllLostNotApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllLostNotApproved",
      Nil,
      "GET",
      this.prefix + """readAllLostNotApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:129
  private[this] lazy val controllers_LostAndFoundController_readAllFoundNotApproved71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllFoundNotApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllFoundNotApproved71_invoker = createInvoker(
    LostAndFoundController_4.readAllFoundNotApproved,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readAllFoundNotApproved",
      Nil,
      "GET",
      this.prefix + """readAllFoundNotApproved""",
      """""",
      Seq()
    )
  )

  // @LINE:131
  private[this] lazy val controllers_LostAndFoundController_adminApproveLAF72_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApproveLAF")))
  )
  private[this] lazy val controllers_LostAndFoundController_adminApproveLAF72_invoker = createInvoker(
    LostAndFoundController_4.adminApproveLAF,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "adminApproveLAF",
      Nil,
      "POST",
      this.prefix + """adminApproveLAF""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:132
  private[this] lazy val controllers_LostAndFoundController_read73_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lostAndFound/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LostAndFoundController_read73_invoker = createInvoker(
    LostAndFoundController_4.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """lostAndFound/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:134
  private[this] lazy val controllers_LostAndFoundController_delete74_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteLostAndFound/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LostAndFoundController_delete74_invoker = createInvoker(
    LostAndFoundController_4.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteLostAndFound/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:135
  private[this] lazy val controllers_LostAndFoundController_readByAnimalId75_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lostAndFoundByAnimalId/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LostAndFoundController_readByAnimalId75_invoker = createInvoker(
    LostAndFoundController_4.readByAnimalId(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "readByAnimalId",
      Seq(classOf[String]),
      "GET",
      this.prefix + """lostAndFoundByAnimalId/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_LostAndFoundController_lostAndFoundExists76_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lostAndFoundExists")))
  )
  private[this] lazy val controllers_LostAndFoundController_lostAndFoundExists76_invoker = createInvoker(
    LostAndFoundController_4.lostAndFoundExists,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LostAndFoundController",
      "lostAndFoundExists",
      Nil,
      "POST",
      this.prefix + """lostAndFoundExists""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:140
  private[this] lazy val controllers_PhotoController_create77_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("photo")))
  )
  private[this] lazy val controllers_PhotoController_create77_invoker = createInvoker(
    PhotoController_10.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "create",
      Nil,
      "POST",
      this.prefix + """photo""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:142
  private[this] lazy val controllers_PhotoController_adopterAddPhotos78_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopterAddPhotos")))
  )
  private[this] lazy val controllers_PhotoController_adopterAddPhotos78_invoker = createInvoker(
    PhotoController_10.adopterAddPhotos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "adopterAddPhotos",
      Nil,
      "POST",
      this.prefix + """adopterAddPhotos""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:143
  private[this] lazy val controllers_PhotoController_readAll79_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allPhotos")))
  )
  private[this] lazy val controllers_PhotoController_readAll79_invoker = createInvoker(
    PhotoController_10.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allPhotos""",
      """""",
      Seq()
    )
  )

  // @LINE:145
  private[this] lazy val controllers_PhotoController_delete80_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletePhoto/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PhotoController_delete80_invoker = createInvoker(
    PhotoController_10.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deletePhoto/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:147
  private[this] lazy val controllers_PhotoController_uploadMedia81_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadMedia")))
  )
  private[this] lazy val controllers_PhotoController_uploadMedia81_invoker = createInvoker(
    PhotoController_10.uploadMedia,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "uploadMedia",
      Nil,
      "POST",
      this.prefix + """uploadMedia""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:149
  private[this] lazy val controllers_PhotoController_readAllAnimalPhotos82_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimalPhotos")))
  )
  private[this] lazy val controllers_PhotoController_readAllAnimalPhotos82_invoker = createInvoker(
    PhotoController_10.readAllAnimalPhotos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "readAllAnimalPhotos",
      Nil,
      "POST",
      this.prefix + """allAnimalPhotos""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:152
  private[this] lazy val controllers_VideoController_create83_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("video")))
  )
  private[this] lazy val controllers_VideoController_create83_invoker = createInvoker(
    VideoController_0.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VideoController",
      "create",
      Nil,
      "POST",
      this.prefix + """video""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:154
  private[this] lazy val controllers_VideoController_adopterAddVideos84_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopterAddVideos")))
  )
  private[this] lazy val controllers_VideoController_adopterAddVideos84_invoker = createInvoker(
    VideoController_0.adopterAddVideos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VideoController",
      "adopterAddVideos",
      Nil,
      "POST",
      this.prefix + """adopterAddVideos""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:155
  private[this] lazy val controllers_VideoController_readAll85_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVideos")))
  )
  private[this] lazy val controllers_VideoController_readAll85_invoker = createInvoker(
    VideoController_0.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VideoController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allVideos""",
      """""",
      Seq()
    )
  )

  // @LINE:157
  private[this] lazy val controllers_VideoController_delete86_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVideo/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VideoController_delete86_invoker = createInvoker(
    VideoController_0.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VideoController",
      "delete",
      Seq(classOf[String]),
      "POST",
      this.prefix + """deleteVideo/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:159
  private[this] lazy val controllers_VideoController_readAllAnimalVideos87_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimalVideos")))
  )
  private[this] lazy val controllers_VideoController_readAllAnimalVideos87_invoker = createInvoker(
    VideoController_0.readAllAnimalVideos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VideoController",
      "readAllAnimalVideos",
      Nil,
      "POST",
      this.prefix + """allAnimalVideos""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:162
  private[this] lazy val controllers_AnimalTypeController_create88_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalType")))
  )
  private[this] lazy val controllers_AnimalTypeController_create88_invoker = createInvoker(
    AnimalTypeController_3.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalTypeController",
      "create",
      Nil,
      "POST",
      this.prefix + """animalType""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:163
  private[this] lazy val controllers_AnimalTypeController_readAll89_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimalTypes")))
  )
  private[this] lazy val controllers_AnimalTypeController_readAll89_invoker = createInvoker(
    AnimalTypeController_3.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalTypeController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAnimalTypes""",
      """""",
      Seq()
    )
  )

  // @LINE:166
  private[this] lazy val controllers_Assets_versioned90_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned90_invoker = createInvoker(
    Assets_12.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_13.index())
      }
  
    // @LINE:10
    case controllers_UserController_loginUser1_route(params@_) =>
      call { 
        controllers_UserController_loginUser1_invoker.call(UserController_11.loginUser)
      }
  
    // @LINE:12
    case controllers_UserController_confirm2_route(params@_) =>
      call { 
        controllers_UserController_confirm2_invoker.call(UserController_11.confirm)
      }
  
    // @LINE:13
    case controllers_UserController_create3_route(params@_) =>
      call(params.fromPath[String]("confirmationCode", None)) { (confirmationCode) =>
        controllers_UserController_create3_invoker.call(UserController_11.create(confirmationCode))
      }
  
    // @LINE:15
    case controllers_UserController_update4_route(params@_) =>
      call { 
        controllers_UserController_update4_invoker.call(UserController_11.update)
      }
  
    // @LINE:17
    case controllers_UserController_passwordExists5_route(params@_) =>
      call { 
        controllers_UserController_passwordExists5_invoker.call(UserController_11.passwordExists)
      }
  
    // @LINE:18
    case controllers_UserController_readAll6_route(params@_) =>
      call { 
        controllers_UserController_readAll6_invoker.call(UserController_11.readAll)
      }
  
    // @LINE:19
    case controllers_UserController_read7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_read7_invoker.call(UserController_11.read(id))
      }
  
    // @LINE:21
    case controllers_UserController_delete8_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_delete8_invoker.call(UserController_11.delete(id))
      }
  
    // @LINE:22
    case controllers_UserController_readLoggedInUser9_route(params@_) =>
      call { 
        controllers_UserController_readLoggedInUser9_invoker.call(UserController_11.readLoggedInUser)
      }
  
    // @LINE:24
    case controllers_UserController_readAllAnimalPendingAdopters10_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalPendingAdopters10_invoker.call(UserController_11.readAllAnimalPendingAdopters)
      }
  
    // @LINE:26
    case controllers_UserController_readAllAnimalAdminApprovedAdopters11_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalAdminApprovedAdopters11_invoker.call(UserController_11.readAllAnimalAdminApprovedAdopters)
      }
  
    // @LINE:28
    case controllers_UserController_forgotPassword12_route(params@_) =>
      call { 
        controllers_UserController_forgotPassword12_invoker.call(UserController_11.forgotPassword)
      }
  
    // @LINE:31
    case controllers_AnimalController_create13_route(params@_) =>
      call { 
        controllers_AnimalController_create13_invoker.call(AnimalController_7.create)
      }
  
    // @LINE:32
    case controllers_AnimalController_readAll14_route(params@_) =>
      call { 
        controllers_AnimalController_readAll14_invoker.call(AnimalController_7.readAll)
      }
  
    // @LINE:34
    case controllers_AnimalController_update15_route(params@_) =>
      call { 
        controllers_AnimalController_update15_invoker.call(AnimalController_7.update)
      }
  
    // @LINE:36
    case controllers_AnimalController_delete16_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_delete16_invoker.call(AnimalController_7.delete(id))
      }
  
    // @LINE:37
    case controllers_AnimalController_read17_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_read17_invoker.call(AnimalController_7.read(id))
      }
  
    // @LINE:38
    case controllers_AnimalController_readAllAdopted18_route(params@_) =>
      call { 
        controllers_AnimalController_readAllAdopted18_invoker.call(AnimalController_7.readAllAdopted)
      }
  
    // @LINE:39
    case controllers_AnimalController_readAllUnadopted19_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUnadopted19_invoker.call(AnimalController_7.readAllUnadopted)
      }
  
    // @LINE:40
    case controllers_AnimalController_readAllUsersSubscribedAnimals20_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUsersSubscribedAnimals20_invoker.call(AnimalController_7.readAllUsersSubscribedAnimals)
      }
  
    // @LINE:42
    case controllers_AnimalController_animalIsSterilized21_route(params@_) =>
      call { 
        controllers_AnimalController_animalIsSterilized21_invoker.call(AnimalController_7.animalIsSterilized)
      }
  
    // @LINE:44
    case controllers_AnimalController_animalSterilized22_route(params@_) =>
      call { 
        controllers_AnimalController_animalSterilized22_invoker.call(AnimalController_7.animalSterilized)
      }
  
    // @LINE:46
    case controllers_AnimalController_search23_route(params@_) =>
      call { 
        controllers_AnimalController_search23_invoker.call(AnimalController_7.search)
      }
  
    // @LINE:49
    case controllers_AdoptionController_create24_route(params@_) =>
      call { 
        controllers_AdoptionController_create24_invoker.call(AdoptionController_6.create)
      }
  
    // @LINE:51
    case controllers_AdoptionController_adminApprove25_route(params@_) =>
      call { 
        controllers_AdoptionController_adminApprove25_invoker.call(AdoptionController_6.adminApprove)
      }
  
    // @LINE:53
    case controllers_AdoptionController_vetApprove26_route(params@_) =>
      call { 
        controllers_AdoptionController_vetApprove26_invoker.call(AdoptionController_6.vetApprove)
      }
  
    // @LINE:54
    case controllers_AdoptionController_readAll27_route(params@_) =>
      call { 
        controllers_AdoptionController_readAll27_invoker.call(AdoptionController_6.readAll)
      }
  
    // @LINE:56
    case controllers_AdoptionController_delete28_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_delete28_invoker.call(AdoptionController_6.delete(id))
      }
  
    // @LINE:58
    case controllers_AdoptionController_deletePending29_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_deletePending29_invoker.call(AdoptionController_6.deletePending(id))
      }
  
    // @LINE:60
    case controllers_AdoptionController_deleteApproved30_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_deleteApproved30_invoker.call(AdoptionController_6.deleteApproved(id))
      }
  
    // @LINE:62
    case controllers_AdoptionController_read31_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_read31_invoker.call(AdoptionController_6.read(id))
      }
  
    // @LINE:64
    case controllers_AdoptionController_readByUserAndAnimalId32_route(params@_) =>
      call { 
        controllers_AdoptionController_readByUserAndAnimalId32_invoker.call(AdoptionController_6.readByUserAndAnimalId)
      }
  
    // @LINE:66
    case controllers_AdoptionController_animalAdopted33_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdopted33_invoker.call(AdoptionController_6.animalAdopted)
      }
  
    // @LINE:68
    case controllers_AdoptionController_animalAdminApproved34_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdminApproved34_invoker.call(AdoptionController_6.animalAdminApproved)
      }
  
    // @LINE:70
    case controllers_AdoptionController_adoptionExists35_route(params@_) =>
      call { 
        controllers_AdoptionController_adoptionExists35_invoker.call(AdoptionController_6.adoptionExists)
      }
  
    // @LINE:71
    case controllers_AdoptionController_readAllUsersAdoptions36_route(params@_) =>
      call { 
        controllers_AdoptionController_readAllUsersAdoptions36_invoker.call(AdoptionController_6.readAllUsersAdoptions)
      }
  
    // @LINE:72
    case controllers_AdoptionController_readAllUsersApprovedAdoptions37_route(params@_) =>
      call { 
        controllers_AdoptionController_readAllUsersApprovedAdoptions37_invoker.call(AdoptionController_6.readAllUsersApprovedAdoptions)
      }
  
    // @LINE:74
    case controllers_SubscriptionController_create38_route(params@_) =>
      call { 
        controllers_SubscriptionController_create38_invoker.call(SubscriptionController_5.create)
      }
  
    // @LINE:75
    case controllers_SubscriptionController_read39_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_read39_invoker.call(SubscriptionController_5.read(id))
      }
  
    // @LINE:76
    case controllers_SubscriptionController_readAll40_route(params@_) =>
      call { 
        controllers_SubscriptionController_readAll40_invoker.call(SubscriptionController_5.readAll)
      }
  
    // @LINE:78
    case controllers_SubscriptionController_delete41_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_delete41_invoker.call(SubscriptionController_5.delete(id))
      }
  
    // @LINE:80
    case controllers_SubscriptionController_subscriptionExists42_route(params@_) =>
      call { 
        controllers_SubscriptionController_subscriptionExists42_invoker.call(SubscriptionController_5.subscriptionExists)
      }
  
    // @LINE:82
    case controllers_SubscriptionController_readSubscriptionByAnimalAndUserId43_route(params@_) =>
      call { 
        controllers_SubscriptionController_readSubscriptionByAnimalAndUserId43_invoker.call(SubscriptionController_5.readSubscriptionByAnimalAndUserId)
      }
  
    // @LINE:85
    case controllers_AdminController_create44_route(params@_) =>
      call { 
        controllers_AdminController_create44_invoker.call(AdminController_9.create)
      }
  
    // @LINE:86
    case controllers_AdminController_readAll45_route(params@_) =>
      call { 
        controllers_AdminController_readAll45_invoker.call(AdminController_9.readAll)
      }
  
    // @LINE:87
    case controllers_AdminController_adminExists46_route(params@_) =>
      call { 
        controllers_AdminController_adminExists46_invoker.call(AdminController_9.adminExists)
      }
  
    // @LINE:89
    case controllers_AdminController_delete47_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdminController_delete47_invoker.call(AdminController_9.delete(id))
      }
  
    // @LINE:92
    case controllers_VetController_create48_route(params@_) =>
      call { 
        controllers_VetController_create48_invoker.call(VetController_8.create)
      }
  
    // @LINE:93
    case controllers_UserController_read49_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_read49_invoker.call(UserController_11.read(id))
      }
  
    // @LINE:94
    case controllers_VetController_readAll50_route(params@_) =>
      call { 
        controllers_VetController_readAll50_invoker.call(VetController_8.readAll)
      }
  
    // @LINE:96
    case controllers_VetController_delete51_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VetController_delete51_invoker.call(VetController_8.delete(id))
      }
  
    // @LINE:99
    case controllers_AdopterController_create52_route(params@_) =>
      call { 
        controllers_AdopterController_create52_invoker.call(AdopterController_2.create)
      }
  
    // @LINE:100
    case controllers_AdopterController_readAll53_route(params@_) =>
      call { 
        controllers_AdopterController_readAll53_invoker.call(AdopterController_2.readAll)
      }
  
    // @LINE:102
    case controllers_AdopterController_delete54_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdopterController_delete54_invoker.call(AdopterController_2.delete(id))
      }
  
    // @LINE:104
    case controllers_AdopterController_adopterExist55_route(params@_) =>
      call { 
        controllers_AdopterController_adopterExist55_invoker.call(AdopterController_2.adopterExist)
      }
  
    // @LINE:107
    case controllers_VetController_vetExists56_route(params@_) =>
      call { 
        controllers_VetController_vetExists56_invoker.call(VetController_8.vetExists)
      }
  
    // @LINE:110
    case controllers_VaccineController_create57_route(params@_) =>
      call { 
        controllers_VaccineController_create57_invoker.call(VaccineController_1.create)
      }
  
    // @LINE:111
    case controllers_VaccineController_readAll58_route(params@_) =>
      call { 
        controllers_VaccineController_readAll58_invoker.call(VaccineController_1.readAll)
      }
  
    // @LINE:113
    case controllers_VaccineController_delete59_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VaccineController_delete59_invoker.call(VaccineController_1.delete(id))
      }
  
    // @LINE:115
    case controllers_VaccineController_readAllAnimalVaccines60_route(params@_) =>
      call { 
        controllers_VaccineController_readAllAnimalVaccines60_invoker.call(VaccineController_1.readAllAnimalVaccines)
      }
  
    // @LINE:118
    case controllers_LostAndFoundController_createLost61_route(params@_) =>
      call { 
        controllers_LostAndFoundController_createLost61_invoker.call(LostAndFoundController_4.createLost)
      }
  
    // @LINE:120
    case controllers_LostAndFoundController_createFound62_route(params@_) =>
      call { 
        controllers_LostAndFoundController_createFound62_invoker.call(LostAndFoundController_4.createFound)
      }
  
    // @LINE:121
    case controllers_LostAndFoundController_readAll63_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAll63_invoker.call(LostAndFoundController_4.readAll)
      }
  
    // @LINE:122
    case controllers_LostAndFoundController_readAllNotApproved64_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllNotApproved64_invoker.call(LostAndFoundController_4.readAllNotApproved)
      }
  
    // @LINE:123
    case controllers_LostAndFoundController_readAllApproved65_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllApproved65_invoker.call(LostAndFoundController_4.readAllApproved)
      }
  
    // @LINE:124
    case controllers_LostAndFoundController_readAllLostApproved66_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllLostApproved66_invoker.call(LostAndFoundController_4.readAllLostApproved)
      }
  
    // @LINE:125
    case controllers_LostAndFoundController_readAllFoundApproved67_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllFoundApproved67_invoker.call(LostAndFoundController_4.readAllFoundApproved)
      }
  
    // @LINE:126
    case controllers_LostAndFoundController_readAllLost68_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllLost68_invoker.call(LostAndFoundController_4.readAllLost)
      }
  
    // @LINE:127
    case controllers_LostAndFoundController_readAllFound69_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllFound69_invoker.call(LostAndFoundController_4.readAllFound)
      }
  
    // @LINE:128
    case controllers_LostAndFoundController_readAllLostNotApproved70_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllLostNotApproved70_invoker.call(LostAndFoundController_4.readAllLostNotApproved)
      }
  
    // @LINE:129
    case controllers_LostAndFoundController_readAllFoundNotApproved71_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllFoundNotApproved71_invoker.call(LostAndFoundController_4.readAllFoundNotApproved)
      }
  
    // @LINE:131
    case controllers_LostAndFoundController_adminApproveLAF72_route(params@_) =>
      call { 
        controllers_LostAndFoundController_adminApproveLAF72_invoker.call(LostAndFoundController_4.adminApproveLAF)
      }
  
    // @LINE:132
    case controllers_LostAndFoundController_read73_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_LostAndFoundController_read73_invoker.call(LostAndFoundController_4.read(id))
      }
  
    // @LINE:134
    case controllers_LostAndFoundController_delete74_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_LostAndFoundController_delete74_invoker.call(LostAndFoundController_4.delete(id))
      }
  
    // @LINE:135
    case controllers_LostAndFoundController_readByAnimalId75_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_LostAndFoundController_readByAnimalId75_invoker.call(LostAndFoundController_4.readByAnimalId(id))
      }
  
    // @LINE:137
    case controllers_LostAndFoundController_lostAndFoundExists76_route(params@_) =>
      call { 
        controllers_LostAndFoundController_lostAndFoundExists76_invoker.call(LostAndFoundController_4.lostAndFoundExists)
      }
  
    // @LINE:140
    case controllers_PhotoController_create77_route(params@_) =>
      call { 
        controllers_PhotoController_create77_invoker.call(PhotoController_10.create)
      }
  
    // @LINE:142
    case controllers_PhotoController_adopterAddPhotos78_route(params@_) =>
      call { 
        controllers_PhotoController_adopterAddPhotos78_invoker.call(PhotoController_10.adopterAddPhotos)
      }
  
    // @LINE:143
    case controllers_PhotoController_readAll79_route(params@_) =>
      call { 
        controllers_PhotoController_readAll79_invoker.call(PhotoController_10.readAll)
      }
  
    // @LINE:145
    case controllers_PhotoController_delete80_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PhotoController_delete80_invoker.call(PhotoController_10.delete(id))
      }
  
    // @LINE:147
    case controllers_PhotoController_uploadMedia81_route(params@_) =>
      call { 
        controllers_PhotoController_uploadMedia81_invoker.call(PhotoController_10.uploadMedia)
      }
  
    // @LINE:149
    case controllers_PhotoController_readAllAnimalPhotos82_route(params@_) =>
      call { 
        controllers_PhotoController_readAllAnimalPhotos82_invoker.call(PhotoController_10.readAllAnimalPhotos)
      }
  
    // @LINE:152
    case controllers_VideoController_create83_route(params@_) =>
      call { 
        controllers_VideoController_create83_invoker.call(VideoController_0.create)
      }
  
    // @LINE:154
    case controllers_VideoController_adopterAddVideos84_route(params@_) =>
      call { 
        controllers_VideoController_adopterAddVideos84_invoker.call(VideoController_0.adopterAddVideos)
      }
  
    // @LINE:155
    case controllers_VideoController_readAll85_route(params@_) =>
      call { 
        controllers_VideoController_readAll85_invoker.call(VideoController_0.readAll)
      }
  
    // @LINE:157
    case controllers_VideoController_delete86_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VideoController_delete86_invoker.call(VideoController_0.delete(id))
      }
  
    // @LINE:159
    case controllers_VideoController_readAllAnimalVideos87_route(params@_) =>
      call { 
        controllers_VideoController_readAllAnimalVideos87_invoker.call(VideoController_0.readAllAnimalVideos)
      }
  
    // @LINE:162
    case controllers_AnimalTypeController_create88_route(params@_) =>
      call { 
        controllers_AnimalTypeController_create88_invoker.call(AnimalTypeController_3.create)
      }
  
    // @LINE:163
    case controllers_AnimalTypeController_readAll89_route(params@_) =>
      call { 
        controllers_AnimalTypeController_readAll89_invoker.call(AnimalTypeController_3.readAll)
      }
  
    // @LINE:166
    case controllers_Assets_versioned90_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned90_invoker.call(Assets_12.versioned(path, file))
      }
  }
}
