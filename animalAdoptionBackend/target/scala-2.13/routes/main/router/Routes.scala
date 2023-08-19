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
  HomeController_11: controllers.HomeController,
  // @LINE:10
  UserController_9: controllers.UserController,
  // @LINE:24
  AnimalController_5: controllers.AnimalController,
  // @LINE:41
  AdoptionController_4: controllers.AdoptionController,
  // @LINE:59
  SubscriptionController_3: controllers.SubscriptionController,
  // @LINE:70
  AdminController_7: controllers.AdminController,
  // @LINE:77
  VetController_6: controllers.VetController,
  // @LINE:83
  AdopterController_1: controllers.AdopterController,
  // @LINE:92
  VaccineController_0: controllers.VaccineController,
  // @LINE:100
  LostAndFoundController_2: controllers.LostAndFoundController,
  // @LINE:112
  PhotoController_8: controllers.PhotoController,
  // @LINE:117
  Assets_10: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_11: controllers.HomeController,
    // @LINE:10
    UserController_9: controllers.UserController,
    // @LINE:24
    AnimalController_5: controllers.AnimalController,
    // @LINE:41
    AdoptionController_4: controllers.AdoptionController,
    // @LINE:59
    SubscriptionController_3: controllers.SubscriptionController,
    // @LINE:70
    AdminController_7: controllers.AdminController,
    // @LINE:77
    VetController_6: controllers.VetController,
    // @LINE:83
    AdopterController_1: controllers.AdopterController,
    // @LINE:92
    VaccineController_0: controllers.VaccineController,
    // @LINE:100
    LostAndFoundController_2: controllers.LostAndFoundController,
    // @LINE:112
    PhotoController_8: controllers.PhotoController,
    // @LINE:117
    Assets_10: controllers.Assets
  ) = this(errorHandler, HomeController_11, UserController_9, AnimalController_5, AdoptionController_4, SubscriptionController_3, AdminController_7, VetController_6, AdopterController_1, VaccineController_0, LostAndFoundController_2, PhotoController_8, Assets_10, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_11, UserController_9, AnimalController_5, AdoptionController_4, SubscriptionController_3, AdminController_7, VetController_6, AdopterController_1, VaccineController_0, LostAndFoundController_2, PhotoController_8, Assets_10, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.loginUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUsers""", """controllers.UserController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteUser/""" + "$" + """id<[^/]+>""", """controllers.UserController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loggedInUser""", """controllers.UserController.readLoggedInUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalPendingAdopters""", """controllers.UserController.readAllAnimalPendingAdopters"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalAdminApprovedAdopters""", """controllers.UserController.readAllAnimalAdminApprovedAdopters"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoption/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readByUserAndAnimalId""", """controllers.AdoptionController.readByUserAndAnimalId"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalAdopted""", """controllers.AdoptionController.animalAdopted"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalAdminApproved""", """controllers.AdoptionController.animalAdminApproved"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allVets""", """controllers.VetController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVet/""" + "$" + """id<[^/]+>""", """controllers.VetController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adopter""", """controllers.AdopterController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdopters""", """controllers.AdopterController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdopter/""" + "$" + """id<[^/]+>""", """controllers.AdopterController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vetExists""", """controllers.VetController.vetExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vaccine""", """controllers.VaccineController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allVaccines""", """controllers.VaccineController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVaccine/""" + "$" + """id<[^/]+>""", """controllers.VaccineController.delete(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalVaccines""", """controllers.VaccineController.readAllAnimalVaccines"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lost""", """controllers.LostAndFoundController.createLost"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """found""", """controllers.LostAndFoundController.createFound"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLostAndFound""", """controllers.LostAndFoundController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allLost""", """controllers.LostAndFoundController.readAllLost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allFound""", """controllers.LostAndFoundController.readAllFound"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllLostNotApproved""", """controllers.LostAndFoundController.readAllLostNotApproved"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllFoundNotApproved""", """controllers.LostAndFoundController.readAllFoundNotApproved"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminApproveLAF""", """controllers.LostAndFoundController.adminApproveLAF"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uploadPhoto""", """controllers.PhotoController.uploadPhoto"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalPhotos""", """controllers.PhotoController.readAllAnimalPhotos"""),
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
    HomeController_11.index(),
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
    UserController_9.loginUser,
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
  private[this] lazy val controllers_UserController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_create2_invoker = createInvoker(
    UserController_9.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "create",
      Nil,
      "POST",
      this.prefix + """user""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_readAll3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsers")))
  )
  private[this] lazy val controllers_UserController_readAll3_invoker = createInvoker(
    UserController_9.readAll,
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

  // @LINE:14
  private[this] lazy val controllers_UserController_read4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_read4_invoker = createInvoker(
    UserController_9.read(fakeValue[String]),
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

  // @LINE:16
  private[this] lazy val controllers_UserController_delete5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_delete5_invoker = createInvoker(
    UserController_9.delete(fakeValue[String]),
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

  // @LINE:17
  private[this] lazy val controllers_UserController_readLoggedInUser6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loggedInUser")))
  )
  private[this] lazy val controllers_UserController_readLoggedInUser6_invoker = createInvoker(
    UserController_9.readLoggedInUser,
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

  // @LINE:19
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdopters7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalPendingAdopters")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdopters7_invoker = createInvoker(
    UserController_9.readAllAnimalPendingAdopters,
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

  // @LINE:21
  private[this] lazy val controllers_UserController_readAllAnimalAdminApprovedAdopters8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalAdminApprovedAdopters")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalAdminApprovedAdopters8_invoker = createInvoker(
    UserController_9.readAllAnimalAdminApprovedAdopters,
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

  // @LINE:24
  private[this] lazy val controllers_AnimalController_create9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal")))
  )
  private[this] lazy val controllers_AnimalController_create9_invoker = createInvoker(
    AnimalController_5.create,
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

  // @LINE:25
  private[this] lazy val controllers_AnimalController_readAll10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAll10_invoker = createInvoker(
    AnimalController_5.readAll,
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

  // @LINE:26
  private[this] lazy val controllers_AnimalController_update11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateAnimal")))
  )
  private[this] lazy val controllers_AnimalController_update11_invoker = createInvoker(
    AnimalController_5.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "update",
      Nil,
      "POST",
      this.prefix + """updateAnimal""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_AnimalController_delete12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAnimal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_delete12_invoker = createInvoker(
    AnimalController_5.delete(fakeValue[String]),
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

  // @LINE:29
  private[this] lazy val controllers_AnimalController_read13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_read13_invoker = createInvoker(
    AnimalController_5.read(fakeValue[String]),
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

  // @LINE:30
  private[this] lazy val controllers_AnimalController_readAllAdopted14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllAdopted14_invoker = createInvoker(
    AnimalController_5.readAllAdopted,
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

  // @LINE:31
  private[this] lazy val controllers_AnimalController_readAllUnadopted15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUnadoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUnadopted15_invoker = createInvoker(
    AnimalController_5.readAllUnadopted,
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

  // @LINE:32
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsersSubscribedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals16_invoker = createInvoker(
    AnimalController_5.readAllUsersSubscribedAnimals,
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

  // @LINE:34
  private[this] lazy val controllers_AnimalController_animalIsSterilized17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalIsSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalIsSterilized17_invoker = createInvoker(
    AnimalController_5.animalIsSterilized,
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

  // @LINE:36
  private[this] lazy val controllers_AnimalController_animalSterilized18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalSterilized18_invoker = createInvoker(
    AnimalController_5.animalSterilized,
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

  // @LINE:38
  private[this] lazy val controllers_AnimalController_search19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchAnimal")))
  )
  private[this] lazy val controllers_AnimalController_search19_invoker = createInvoker(
    AnimalController_5.search,
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

  // @LINE:41
  private[this] lazy val controllers_AdoptionController_create20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption")))
  )
  private[this] lazy val controllers_AdoptionController_create20_invoker = createInvoker(
    AdoptionController_4.create,
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

  // @LINE:43
  private[this] lazy val controllers_AdoptionController_adminApprove21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApprove")))
  )
  private[this] lazy val controllers_AdoptionController_adminApprove21_invoker = createInvoker(
    AdoptionController_4.adminApprove,
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

  // @LINE:45
  private[this] lazy val controllers_AdoptionController_vetApprove22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vetApprove")))
  )
  private[this] lazy val controllers_AdoptionController_vetApprove22_invoker = createInvoker(
    AdoptionController_4.vetApprove,
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

  // @LINE:46
  private[this] lazy val controllers_AdoptionController_readAll23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAll23_invoker = createInvoker(
    AdoptionController_4.readAll,
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

  // @LINE:48
  private[this] lazy val controllers_AdoptionController_delete24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_delete24_invoker = createInvoker(
    AdoptionController_4.delete(fakeValue[String]),
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

  // @LINE:50
  private[this] lazy val controllers_AdoptionController_read25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_read25_invoker = createInvoker(
    AdoptionController_4.read(fakeValue[String]),
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

  // @LINE:52
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readByUserAndAnimalId")))
  )
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId26_invoker = createInvoker(
    AdoptionController_4.readByUserAndAnimalId,
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

  // @LINE:54
  private[this] lazy val controllers_AdoptionController_animalAdopted27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdopted")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdopted27_invoker = createInvoker(
    AdoptionController_4.animalAdopted,
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

  // @LINE:56
  private[this] lazy val controllers_AdoptionController_animalAdminApproved28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdminApproved")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdminApproved28_invoker = createInvoker(
    AdoptionController_4.animalAdminApproved,
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

  // @LINE:59
  private[this] lazy val controllers_SubscriptionController_create29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription")))
  )
  private[this] lazy val controllers_SubscriptionController_create29_invoker = createInvoker(
    SubscriptionController_3.create,
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

  // @LINE:60
  private[this] lazy val controllers_SubscriptionController_read30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_read30_invoker = createInvoker(
    SubscriptionController_3.read(fakeValue[String]),
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

  // @LINE:61
  private[this] lazy val controllers_SubscriptionController_readAll31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allSubscriptions")))
  )
  private[this] lazy val controllers_SubscriptionController_readAll31_invoker = createInvoker(
    SubscriptionController_3.readAll,
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

  // @LINE:63
  private[this] lazy val controllers_SubscriptionController_delete32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSubscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_delete32_invoker = createInvoker(
    SubscriptionController_3.delete(fakeValue[String]),
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

  // @LINE:65
  private[this] lazy val controllers_SubscriptionController_subscriptionExists33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionExists")))
  )
  private[this] lazy val controllers_SubscriptionController_subscriptionExists33_invoker = createInvoker(
    SubscriptionController_3.subscriptionExists,
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

  // @LINE:67
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionByAnimalId")))
  )
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId34_invoker = createInvoker(
    SubscriptionController_3.readSubscriptionByAnimalAndUserId,
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

  // @LINE:70
  private[this] lazy val controllers_AdminController_create35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_AdminController_create35_invoker = createInvoker(
    AdminController_7.create,
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

  // @LINE:71
  private[this] lazy val controllers_AdminController_readAll36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdmins")))
  )
  private[this] lazy val controllers_AdminController_readAll36_invoker = createInvoker(
    AdminController_7.readAll,
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

  // @LINE:72
  private[this] lazy val controllers_AdminController_adminExists37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminExists")))
  )
  private[this] lazy val controllers_AdminController_adminExists37_invoker = createInvoker(
    AdminController_7.adminExists,
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

  // @LINE:74
  private[this] lazy val controllers_AdminController_delete38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdmin/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_delete38_invoker = createInvoker(
    AdminController_7.delete(fakeValue[String]),
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

  // @LINE:77
  private[this] lazy val controllers_VetController_create39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vet")))
  )
  private[this] lazy val controllers_VetController_create39_invoker = createInvoker(
    VetController_6.create,
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

  // @LINE:78
  private[this] lazy val controllers_VetController_readAll40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVets")))
  )
  private[this] lazy val controllers_VetController_readAll40_invoker = createInvoker(
    VetController_6.readAll,
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

  // @LINE:80
  private[this] lazy val controllers_VetController_delete41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVet/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VetController_delete41_invoker = createInvoker(
    VetController_6.delete(fakeValue[String]),
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

  // @LINE:83
  private[this] lazy val controllers_AdopterController_create42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopter")))
  )
  private[this] lazy val controllers_AdopterController_create42_invoker = createInvoker(
    AdopterController_1.create,
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

  // @LINE:84
  private[this] lazy val controllers_AdopterController_readAll43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdopters")))
  )
  private[this] lazy val controllers_AdopterController_readAll43_invoker = createInvoker(
    AdopterController_1.readAll,
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

  // @LINE:86
  private[this] lazy val controllers_AdopterController_delete44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdopter/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdopterController_delete44_invoker = createInvoker(
    AdopterController_1.delete(fakeValue[String]),
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

  // @LINE:89
  private[this] lazy val controllers_VetController_vetExists45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vetExists")))
  )
  private[this] lazy val controllers_VetController_vetExists45_invoker = createInvoker(
    VetController_6.vetExists,
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

  // @LINE:92
  private[this] lazy val controllers_VaccineController_create46_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vaccine")))
  )
  private[this] lazy val controllers_VaccineController_create46_invoker = createInvoker(
    VaccineController_0.create,
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

  // @LINE:93
  private[this] lazy val controllers_VaccineController_readAll47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAll47_invoker = createInvoker(
    VaccineController_0.readAll,
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

  // @LINE:95
  private[this] lazy val controllers_VaccineController_delete48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVaccine/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VaccineController_delete48_invoker = createInvoker(
    VaccineController_0.delete(fakeValue[String]),
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

  // @LINE:97
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines49_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines49_invoker = createInvoker(
    VaccineController_0.readAllAnimalVaccines,
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

  // @LINE:100
  private[this] lazy val controllers_LostAndFoundController_createLost50_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lost")))
  )
  private[this] lazy val controllers_LostAndFoundController_createLost50_invoker = createInvoker(
    LostAndFoundController_2.createLost,
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

  // @LINE:102
  private[this] lazy val controllers_LostAndFoundController_createFound51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("found")))
  )
  private[this] lazy val controllers_LostAndFoundController_createFound51_invoker = createInvoker(
    LostAndFoundController_2.createFound,
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

  // @LINE:103
  private[this] lazy val controllers_LostAndFoundController_readAll52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLostAndFound")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAll52_invoker = createInvoker(
    LostAndFoundController_2.readAll,
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

  // @LINE:104
  private[this] lazy val controllers_LostAndFoundController_readAllLost53_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allLost")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllLost53_invoker = createInvoker(
    LostAndFoundController_2.readAllLost,
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

  // @LINE:105
  private[this] lazy val controllers_LostAndFoundController_readAllFound54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allFound")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllFound54_invoker = createInvoker(
    LostAndFoundController_2.readAllFound,
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

  // @LINE:106
  private[this] lazy val controllers_LostAndFoundController_readAllLostNotApproved55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllLostNotApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllLostNotApproved55_invoker = createInvoker(
    LostAndFoundController_2.readAllLostNotApproved,
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

  // @LINE:107
  private[this] lazy val controllers_LostAndFoundController_readAllFoundNotApproved56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllFoundNotApproved")))
  )
  private[this] lazy val controllers_LostAndFoundController_readAllFoundNotApproved56_invoker = createInvoker(
    LostAndFoundController_2.readAllFoundNotApproved,
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

  // @LINE:109
  private[this] lazy val controllers_LostAndFoundController_adminApproveLAF57_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApproveLAF")))
  )
  private[this] lazy val controllers_LostAndFoundController_adminApproveLAF57_invoker = createInvoker(
    LostAndFoundController_2.adminApproveLAF,
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

  // @LINE:112
  private[this] lazy val controllers_PhotoController_uploadPhoto58_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadPhoto")))
  )
  private[this] lazy val controllers_PhotoController_uploadPhoto58_invoker = createInvoker(
    PhotoController_8.uploadPhoto,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "uploadPhoto",
      Nil,
      "POST",
      this.prefix + """uploadPhoto""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:114
  private[this] lazy val controllers_PhotoController_readAllAnimalPhotos59_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalPhotos")))
  )
  private[this] lazy val controllers_PhotoController_readAllAnimalPhotos59_invoker = createInvoker(
    PhotoController_8.readAllAnimalPhotos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PhotoController",
      "readAllAnimalPhotos",
      Nil,
      "POST",
      this.prefix + """readAllAnimalPhotos""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:117
  private[this] lazy val controllers_Assets_versioned60_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned60_invoker = createInvoker(
    Assets_10.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_11.index())
      }
  
    // @LINE:10
    case controllers_UserController_loginUser1_route(params@_) =>
      call { 
        controllers_UserController_loginUser1_invoker.call(UserController_9.loginUser)
      }
  
    // @LINE:12
    case controllers_UserController_create2_route(params@_) =>
      call { 
        controllers_UserController_create2_invoker.call(UserController_9.create)
      }
  
    // @LINE:13
    case controllers_UserController_readAll3_route(params@_) =>
      call { 
        controllers_UserController_readAll3_invoker.call(UserController_9.readAll)
      }
  
    // @LINE:14
    case controllers_UserController_read4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_read4_invoker.call(UserController_9.read(id))
      }
  
    // @LINE:16
    case controllers_UserController_delete5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_delete5_invoker.call(UserController_9.delete(id))
      }
  
    // @LINE:17
    case controllers_UserController_readLoggedInUser6_route(params@_) =>
      call { 
        controllers_UserController_readLoggedInUser6_invoker.call(UserController_9.readLoggedInUser)
      }
  
    // @LINE:19
    case controllers_UserController_readAllAnimalPendingAdopters7_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalPendingAdopters7_invoker.call(UserController_9.readAllAnimalPendingAdopters)
      }
  
    // @LINE:21
    case controllers_UserController_readAllAnimalAdminApprovedAdopters8_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalAdminApprovedAdopters8_invoker.call(UserController_9.readAllAnimalAdminApprovedAdopters)
      }
  
    // @LINE:24
    case controllers_AnimalController_create9_route(params@_) =>
      call { 
        controllers_AnimalController_create9_invoker.call(AnimalController_5.create)
      }
  
    // @LINE:25
    case controllers_AnimalController_readAll10_route(params@_) =>
      call { 
        controllers_AnimalController_readAll10_invoker.call(AnimalController_5.readAll)
      }
  
    // @LINE:26
    case controllers_AnimalController_update11_route(params@_) =>
      call { 
        controllers_AnimalController_update11_invoker.call(AnimalController_5.update)
      }
  
    // @LINE:28
    case controllers_AnimalController_delete12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_delete12_invoker.call(AnimalController_5.delete(id))
      }
  
    // @LINE:29
    case controllers_AnimalController_read13_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_read13_invoker.call(AnimalController_5.read(id))
      }
  
    // @LINE:30
    case controllers_AnimalController_readAllAdopted14_route(params@_) =>
      call { 
        controllers_AnimalController_readAllAdopted14_invoker.call(AnimalController_5.readAllAdopted)
      }
  
    // @LINE:31
    case controllers_AnimalController_readAllUnadopted15_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUnadopted15_invoker.call(AnimalController_5.readAllUnadopted)
      }
  
    // @LINE:32
    case controllers_AnimalController_readAllUsersSubscribedAnimals16_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUsersSubscribedAnimals16_invoker.call(AnimalController_5.readAllUsersSubscribedAnimals)
      }
  
    // @LINE:34
    case controllers_AnimalController_animalIsSterilized17_route(params@_) =>
      call { 
        controllers_AnimalController_animalIsSterilized17_invoker.call(AnimalController_5.animalIsSterilized)
      }
  
    // @LINE:36
    case controllers_AnimalController_animalSterilized18_route(params@_) =>
      call { 
        controllers_AnimalController_animalSterilized18_invoker.call(AnimalController_5.animalSterilized)
      }
  
    // @LINE:38
    case controllers_AnimalController_search19_route(params@_) =>
      call { 
        controllers_AnimalController_search19_invoker.call(AnimalController_5.search)
      }
  
    // @LINE:41
    case controllers_AdoptionController_create20_route(params@_) =>
      call { 
        controllers_AdoptionController_create20_invoker.call(AdoptionController_4.create)
      }
  
    // @LINE:43
    case controllers_AdoptionController_adminApprove21_route(params@_) =>
      call { 
        controllers_AdoptionController_adminApprove21_invoker.call(AdoptionController_4.adminApprove)
      }
  
    // @LINE:45
    case controllers_AdoptionController_vetApprove22_route(params@_) =>
      call { 
        controllers_AdoptionController_vetApprove22_invoker.call(AdoptionController_4.vetApprove)
      }
  
    // @LINE:46
    case controllers_AdoptionController_readAll23_route(params@_) =>
      call { 
        controllers_AdoptionController_readAll23_invoker.call(AdoptionController_4.readAll)
      }
  
    // @LINE:48
    case controllers_AdoptionController_delete24_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_delete24_invoker.call(AdoptionController_4.delete(id))
      }
  
    // @LINE:50
    case controllers_AdoptionController_read25_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_read25_invoker.call(AdoptionController_4.read(id))
      }
  
    // @LINE:52
    case controllers_AdoptionController_readByUserAndAnimalId26_route(params@_) =>
      call { 
        controllers_AdoptionController_readByUserAndAnimalId26_invoker.call(AdoptionController_4.readByUserAndAnimalId)
      }
  
    // @LINE:54
    case controllers_AdoptionController_animalAdopted27_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdopted27_invoker.call(AdoptionController_4.animalAdopted)
      }
  
    // @LINE:56
    case controllers_AdoptionController_animalAdminApproved28_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdminApproved28_invoker.call(AdoptionController_4.animalAdminApproved)
      }
  
    // @LINE:59
    case controllers_SubscriptionController_create29_route(params@_) =>
      call { 
        controllers_SubscriptionController_create29_invoker.call(SubscriptionController_3.create)
      }
  
    // @LINE:60
    case controllers_SubscriptionController_read30_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_read30_invoker.call(SubscriptionController_3.read(id))
      }
  
    // @LINE:61
    case controllers_SubscriptionController_readAll31_route(params@_) =>
      call { 
        controllers_SubscriptionController_readAll31_invoker.call(SubscriptionController_3.readAll)
      }
  
    // @LINE:63
    case controllers_SubscriptionController_delete32_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_delete32_invoker.call(SubscriptionController_3.delete(id))
      }
  
    // @LINE:65
    case controllers_SubscriptionController_subscriptionExists33_route(params@_) =>
      call { 
        controllers_SubscriptionController_subscriptionExists33_invoker.call(SubscriptionController_3.subscriptionExists)
      }
  
    // @LINE:67
    case controllers_SubscriptionController_readSubscriptionByAnimalAndUserId34_route(params@_) =>
      call { 
        controllers_SubscriptionController_readSubscriptionByAnimalAndUserId34_invoker.call(SubscriptionController_3.readSubscriptionByAnimalAndUserId)
      }
  
    // @LINE:70
    case controllers_AdminController_create35_route(params@_) =>
      call { 
        controllers_AdminController_create35_invoker.call(AdminController_7.create)
      }
  
    // @LINE:71
    case controllers_AdminController_readAll36_route(params@_) =>
      call { 
        controllers_AdminController_readAll36_invoker.call(AdminController_7.readAll)
      }
  
    // @LINE:72
    case controllers_AdminController_adminExists37_route(params@_) =>
      call { 
        controllers_AdminController_adminExists37_invoker.call(AdminController_7.adminExists)
      }
  
    // @LINE:74
    case controllers_AdminController_delete38_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdminController_delete38_invoker.call(AdminController_7.delete(id))
      }
  
    // @LINE:77
    case controllers_VetController_create39_route(params@_) =>
      call { 
        controllers_VetController_create39_invoker.call(VetController_6.create)
      }
  
    // @LINE:78
    case controllers_VetController_readAll40_route(params@_) =>
      call { 
        controllers_VetController_readAll40_invoker.call(VetController_6.readAll)
      }
  
    // @LINE:80
    case controllers_VetController_delete41_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VetController_delete41_invoker.call(VetController_6.delete(id))
      }
  
    // @LINE:83
    case controllers_AdopterController_create42_route(params@_) =>
      call { 
        controllers_AdopterController_create42_invoker.call(AdopterController_1.create)
      }
  
    // @LINE:84
    case controllers_AdopterController_readAll43_route(params@_) =>
      call { 
        controllers_AdopterController_readAll43_invoker.call(AdopterController_1.readAll)
      }
  
    // @LINE:86
    case controllers_AdopterController_delete44_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdopterController_delete44_invoker.call(AdopterController_1.delete(id))
      }
  
    // @LINE:89
    case controllers_VetController_vetExists45_route(params@_) =>
      call { 
        controllers_VetController_vetExists45_invoker.call(VetController_6.vetExists)
      }
  
    // @LINE:92
    case controllers_VaccineController_create46_route(params@_) =>
      call { 
        controllers_VaccineController_create46_invoker.call(VaccineController_0.create)
      }
  
    // @LINE:93
    case controllers_VaccineController_readAll47_route(params@_) =>
      call { 
        controllers_VaccineController_readAll47_invoker.call(VaccineController_0.readAll)
      }
  
    // @LINE:95
    case controllers_VaccineController_delete48_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VaccineController_delete48_invoker.call(VaccineController_0.delete(id))
      }
  
    // @LINE:97
    case controllers_VaccineController_readAllAnimalVaccines49_route(params@_) =>
      call { 
        controllers_VaccineController_readAllAnimalVaccines49_invoker.call(VaccineController_0.readAllAnimalVaccines)
      }
  
    // @LINE:100
    case controllers_LostAndFoundController_createLost50_route(params@_) =>
      call { 
        controllers_LostAndFoundController_createLost50_invoker.call(LostAndFoundController_2.createLost)
      }
  
    // @LINE:102
    case controllers_LostAndFoundController_createFound51_route(params@_) =>
      call { 
        controllers_LostAndFoundController_createFound51_invoker.call(LostAndFoundController_2.createFound)
      }
  
    // @LINE:103
    case controllers_LostAndFoundController_readAll52_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAll52_invoker.call(LostAndFoundController_2.readAll)
      }
  
    // @LINE:104
    case controllers_LostAndFoundController_readAllLost53_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllLost53_invoker.call(LostAndFoundController_2.readAllLost)
      }
  
    // @LINE:105
    case controllers_LostAndFoundController_readAllFound54_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllFound54_invoker.call(LostAndFoundController_2.readAllFound)
      }
  
    // @LINE:106
    case controllers_LostAndFoundController_readAllLostNotApproved55_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllLostNotApproved55_invoker.call(LostAndFoundController_2.readAllLostNotApproved)
      }
  
    // @LINE:107
    case controllers_LostAndFoundController_readAllFoundNotApproved56_route(params@_) =>
      call { 
        controllers_LostAndFoundController_readAllFoundNotApproved56_invoker.call(LostAndFoundController_2.readAllFoundNotApproved)
      }
  
    // @LINE:109
    case controllers_LostAndFoundController_adminApproveLAF57_route(params@_) =>
      call { 
        controllers_LostAndFoundController_adminApproveLAF57_invoker.call(LostAndFoundController_2.adminApproveLAF)
      }
  
    // @LINE:112
    case controllers_PhotoController_uploadPhoto58_route(params@_) =>
      call { 
        controllers_PhotoController_uploadPhoto58_invoker.call(PhotoController_8.uploadPhoto)
      }
  
    // @LINE:114
    case controllers_PhotoController_readAllAnimalPhotos59_route(params@_) =>
      call { 
        controllers_PhotoController_readAllAnimalPhotos59_invoker.call(PhotoController_8.readAllAnimalPhotos)
      }
  
    // @LINE:117
    case controllers_Assets_versioned60_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned60_invoker.call(Assets_10.versioned(path, file))
      }
  }
}
