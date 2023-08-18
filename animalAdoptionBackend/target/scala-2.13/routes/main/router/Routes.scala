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
  HomeController_9: controllers.HomeController,
  // @LINE:10
  UserController_7: controllers.UserController,
  // @LINE:22
  AnimalController_4: controllers.AnimalController,
  // @LINE:35
  AdoptionController_3: controllers.AdoptionController,
  // @LINE:49
  SubscriptionController_2: controllers.SubscriptionController,
  // @LINE:60
  AdminController_6: controllers.AdminController,
  // @LINE:67
  VetController_5: controllers.VetController,
  // @LINE:73
  AdopterController_1: controllers.AdopterController,
  // @LINE:82
  VaccineController_0: controllers.VaccineController,
  // @LINE:90
  Assets_8: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_9: controllers.HomeController,
    // @LINE:10
    UserController_7: controllers.UserController,
    // @LINE:22
    AnimalController_4: controllers.AnimalController,
    // @LINE:35
    AdoptionController_3: controllers.AdoptionController,
    // @LINE:49
    SubscriptionController_2: controllers.SubscriptionController,
    // @LINE:60
    AdminController_6: controllers.AdminController,
    // @LINE:67
    VetController_5: controllers.VetController,
    // @LINE:73
    AdopterController_1: controllers.AdopterController,
    // @LINE:82
    VaccineController_0: controllers.VaccineController,
    // @LINE:90
    Assets_8: controllers.Assets
  ) = this(errorHandler, HomeController_9, UserController_7, AnimalController_4, AdoptionController_3, SubscriptionController_2, AdminController_6, VetController_5, AdopterController_1, VaccineController_0, Assets_8, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_9, UserController_7, AnimalController_4, AdoptionController_3, SubscriptionController_2, AdminController_6, VetController_5, AdopterController_1, VaccineController_0, Assets_8, prefix)
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalPendingAdoptions""", """controllers.UserController.readAllAnimalPendingAdoptions"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal""", """controllers.AnimalController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimals""", """controllers.AnimalController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateAnimal""", """controllers.AnimalController.update"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAnimal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.read(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdoptedAnimals""", """controllers.AnimalController.readAllAdopted"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUsersSubscribedAnimals""", """controllers.AnimalController.readAllUsersSubscribedAnimals"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalIsSterilized""", """controllers.AnimalController.animalIsSterilized"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalSterilized""", """controllers.AnimalController.animalSterilized"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoption""", """controllers.AdoptionController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminApprove""", """controllers.AdoptionController.adminApprove"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdoptions""", """controllers.AdoptionController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdoption/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adoption/""" + "$" + """id<[^/]+>""", """controllers.AdoptionController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readByUserAndAnimalId""", """controllers.AdoptionController.readByUserAndAnimalId"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animalAdopted""", """controllers.AdoptionController.animalAdopted"""),
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
    HomeController_9.index(),
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
    UserController_7.loginUser,
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
    UserController_7.create,
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
    UserController_7.readAll,
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
    UserController_7.read(fakeValue[String]),
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
    UserController_7.delete(fakeValue[String]),
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
    UserController_7.readLoggedInUser,
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
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdoptions7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalPendingAdoptions")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdoptions7_invoker = createInvoker(
    UserController_7.readAllAnimalPendingAdoptions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "readAllAnimalPendingAdoptions",
      Nil,
      "POST",
      this.prefix + """readAllAnimalPendingAdoptions""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:22
  private[this] lazy val controllers_AnimalController_create8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal")))
  )
  private[this] lazy val controllers_AnimalController_create8_invoker = createInvoker(
    AnimalController_4.create,
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

  // @LINE:23
  private[this] lazy val controllers_AnimalController_readAll9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAll9_invoker = createInvoker(
    AnimalController_4.readAll,
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

  // @LINE:24
  private[this] lazy val controllers_AnimalController_update10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateAnimal")))
  )
  private[this] lazy val controllers_AnimalController_update10_invoker = createInvoker(
    AnimalController_4.update,
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

  // @LINE:26
  private[this] lazy val controllers_AnimalController_delete11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAnimal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_delete11_invoker = createInvoker(
    AnimalController_4.delete(fakeValue[String]),
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

  // @LINE:27
  private[this] lazy val controllers_AnimalController_read12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_read12_invoker = createInvoker(
    AnimalController_4.read(fakeValue[String]),
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

  // @LINE:28
  private[this] lazy val controllers_AnimalController_readAllAdopted13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllAdopted13_invoker = createInvoker(
    AnimalController_4.readAllAdopted,
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

  // @LINE:29
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsersSubscribedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals14_invoker = createInvoker(
    AnimalController_4.readAllUsersSubscribedAnimals,
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

  // @LINE:31
  private[this] lazy val controllers_AnimalController_animalIsSterilized15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalIsSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalIsSterilized15_invoker = createInvoker(
    AnimalController_4.animalIsSterilized,
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

  // @LINE:33
  private[this] lazy val controllers_AnimalController_animalSterilized16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalSterilized")))
  )
  private[this] lazy val controllers_AnimalController_animalSterilized16_invoker = createInvoker(
    AnimalController_4.animalSterilized,
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

  // @LINE:35
  private[this] lazy val controllers_AdoptionController_create17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption")))
  )
  private[this] lazy val controllers_AdoptionController_create17_invoker = createInvoker(
    AdoptionController_3.create,
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

  // @LINE:37
  private[this] lazy val controllers_AdoptionController_adminApprove18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApprove")))
  )
  private[this] lazy val controllers_AdoptionController_adminApprove18_invoker = createInvoker(
    AdoptionController_3.adminApprove,
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

  // @LINE:38
  private[this] lazy val controllers_AdoptionController_readAll19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAll19_invoker = createInvoker(
    AdoptionController_3.readAll,
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

  // @LINE:40
  private[this] lazy val controllers_AdoptionController_delete20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_delete20_invoker = createInvoker(
    AdoptionController_3.delete(fakeValue[String]),
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

  // @LINE:42
  private[this] lazy val controllers_AdoptionController_read21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_read21_invoker = createInvoker(
    AdoptionController_3.read(fakeValue[String]),
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

  // @LINE:44
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readByUserAndAnimalId")))
  )
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId22_invoker = createInvoker(
    AdoptionController_3.readByUserAndAnimalId,
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

  // @LINE:46
  private[this] lazy val controllers_AdoptionController_animalAdopted23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdopted")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdopted23_invoker = createInvoker(
    AdoptionController_3.animalAdopted,
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

  // @LINE:49
  private[this] lazy val controllers_SubscriptionController_create24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription")))
  )
  private[this] lazy val controllers_SubscriptionController_create24_invoker = createInvoker(
    SubscriptionController_2.create,
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

  // @LINE:50
  private[this] lazy val controllers_SubscriptionController_read25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_read25_invoker = createInvoker(
    SubscriptionController_2.read(fakeValue[String]),
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

  // @LINE:51
  private[this] lazy val controllers_SubscriptionController_readAll26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allSubscriptions")))
  )
  private[this] lazy val controllers_SubscriptionController_readAll26_invoker = createInvoker(
    SubscriptionController_2.readAll,
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

  // @LINE:53
  private[this] lazy val controllers_SubscriptionController_delete27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSubscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_delete27_invoker = createInvoker(
    SubscriptionController_2.delete(fakeValue[String]),
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

  // @LINE:55
  private[this] lazy val controllers_SubscriptionController_subscriptionExists28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionExists")))
  )
  private[this] lazy val controllers_SubscriptionController_subscriptionExists28_invoker = createInvoker(
    SubscriptionController_2.subscriptionExists,
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

  // @LINE:57
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionByAnimalId")))
  )
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId29_invoker = createInvoker(
    SubscriptionController_2.readSubscriptionByAnimalAndUserId,
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

  // @LINE:60
  private[this] lazy val controllers_AdminController_create30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_AdminController_create30_invoker = createInvoker(
    AdminController_6.create,
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

  // @LINE:61
  private[this] lazy val controllers_AdminController_readAll31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdmins")))
  )
  private[this] lazy val controllers_AdminController_readAll31_invoker = createInvoker(
    AdminController_6.readAll,
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

  // @LINE:62
  private[this] lazy val controllers_AdminController_adminExists32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminExists")))
  )
  private[this] lazy val controllers_AdminController_adminExists32_invoker = createInvoker(
    AdminController_6.adminExists,
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

  // @LINE:64
  private[this] lazy val controllers_AdminController_delete33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdmin/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_delete33_invoker = createInvoker(
    AdminController_6.delete(fakeValue[String]),
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

  // @LINE:67
  private[this] lazy val controllers_VetController_create34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vet")))
  )
  private[this] lazy val controllers_VetController_create34_invoker = createInvoker(
    VetController_5.create,
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

  // @LINE:68
  private[this] lazy val controllers_VetController_readAll35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVets")))
  )
  private[this] lazy val controllers_VetController_readAll35_invoker = createInvoker(
    VetController_5.readAll,
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

  // @LINE:70
  private[this] lazy val controllers_VetController_delete36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVet/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VetController_delete36_invoker = createInvoker(
    VetController_5.delete(fakeValue[String]),
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

  // @LINE:73
  private[this] lazy val controllers_AdopterController_create37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adopter")))
  )
  private[this] lazy val controllers_AdopterController_create37_invoker = createInvoker(
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

  // @LINE:74
  private[this] lazy val controllers_AdopterController_readAll38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdopters")))
  )
  private[this] lazy val controllers_AdopterController_readAll38_invoker = createInvoker(
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

  // @LINE:76
  private[this] lazy val controllers_AdopterController_delete39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdopter/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdopterController_delete39_invoker = createInvoker(
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

  // @LINE:79
  private[this] lazy val controllers_VetController_vetExists40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vetExists")))
  )
  private[this] lazy val controllers_VetController_vetExists40_invoker = createInvoker(
    VetController_5.vetExists,
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

  // @LINE:82
  private[this] lazy val controllers_VaccineController_create41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vaccine")))
  )
  private[this] lazy val controllers_VaccineController_create41_invoker = createInvoker(
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

  // @LINE:83
  private[this] lazy val controllers_VaccineController_readAll42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAll42_invoker = createInvoker(
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

  // @LINE:85
  private[this] lazy val controllers_VaccineController_delete43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVaccine/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VaccineController_delete43_invoker = createInvoker(
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

  // @LINE:87
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalVaccines")))
  )
  private[this] lazy val controllers_VaccineController_readAllAnimalVaccines44_invoker = createInvoker(
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

  // @LINE:90
  private[this] lazy val controllers_Assets_versioned45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned45_invoker = createInvoker(
    Assets_8.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_9.index())
      }
  
    // @LINE:10
    case controllers_UserController_loginUser1_route(params@_) =>
      call { 
        controllers_UserController_loginUser1_invoker.call(UserController_7.loginUser)
      }
  
    // @LINE:12
    case controllers_UserController_create2_route(params@_) =>
      call { 
        controllers_UserController_create2_invoker.call(UserController_7.create)
      }
  
    // @LINE:13
    case controllers_UserController_readAll3_route(params@_) =>
      call { 
        controllers_UserController_readAll3_invoker.call(UserController_7.readAll)
      }
  
    // @LINE:14
    case controllers_UserController_read4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_read4_invoker.call(UserController_7.read(id))
      }
  
    // @LINE:16
    case controllers_UserController_delete5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_delete5_invoker.call(UserController_7.delete(id))
      }
  
    // @LINE:17
    case controllers_UserController_readLoggedInUser6_route(params@_) =>
      call { 
        controllers_UserController_readLoggedInUser6_invoker.call(UserController_7.readLoggedInUser)
      }
  
    // @LINE:19
    case controllers_UserController_readAllAnimalPendingAdoptions7_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalPendingAdoptions7_invoker.call(UserController_7.readAllAnimalPendingAdoptions)
      }
  
    // @LINE:22
    case controllers_AnimalController_create8_route(params@_) =>
      call { 
        controllers_AnimalController_create8_invoker.call(AnimalController_4.create)
      }
  
    // @LINE:23
    case controllers_AnimalController_readAll9_route(params@_) =>
      call { 
        controllers_AnimalController_readAll9_invoker.call(AnimalController_4.readAll)
      }
  
    // @LINE:24
    case controllers_AnimalController_update10_route(params@_) =>
      call { 
        controllers_AnimalController_update10_invoker.call(AnimalController_4.update)
      }
  
    // @LINE:26
    case controllers_AnimalController_delete11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_delete11_invoker.call(AnimalController_4.delete(id))
      }
  
    // @LINE:27
    case controllers_AnimalController_read12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_read12_invoker.call(AnimalController_4.read(id))
      }
  
    // @LINE:28
    case controllers_AnimalController_readAllAdopted13_route(params@_) =>
      call { 
        controllers_AnimalController_readAllAdopted13_invoker.call(AnimalController_4.readAllAdopted)
      }
  
    // @LINE:29
    case controllers_AnimalController_readAllUsersSubscribedAnimals14_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUsersSubscribedAnimals14_invoker.call(AnimalController_4.readAllUsersSubscribedAnimals)
      }
  
    // @LINE:31
    case controllers_AnimalController_animalIsSterilized15_route(params@_) =>
      call { 
        controllers_AnimalController_animalIsSterilized15_invoker.call(AnimalController_4.animalIsSterilized)
      }
  
    // @LINE:33
    case controllers_AnimalController_animalSterilized16_route(params@_) =>
      call { 
        controllers_AnimalController_animalSterilized16_invoker.call(AnimalController_4.animalSterilized)
      }
  
    // @LINE:35
    case controllers_AdoptionController_create17_route(params@_) =>
      call { 
        controllers_AdoptionController_create17_invoker.call(AdoptionController_3.create)
      }
  
    // @LINE:37
    case controllers_AdoptionController_adminApprove18_route(params@_) =>
      call { 
        controllers_AdoptionController_adminApprove18_invoker.call(AdoptionController_3.adminApprove)
      }
  
    // @LINE:38
    case controllers_AdoptionController_readAll19_route(params@_) =>
      call { 
        controllers_AdoptionController_readAll19_invoker.call(AdoptionController_3.readAll)
      }
  
    // @LINE:40
    case controllers_AdoptionController_delete20_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_delete20_invoker.call(AdoptionController_3.delete(id))
      }
  
    // @LINE:42
    case controllers_AdoptionController_read21_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_read21_invoker.call(AdoptionController_3.read(id))
      }
  
    // @LINE:44
    case controllers_AdoptionController_readByUserAndAnimalId22_route(params@_) =>
      call { 
        controllers_AdoptionController_readByUserAndAnimalId22_invoker.call(AdoptionController_3.readByUserAndAnimalId)
      }
  
    // @LINE:46
    case controllers_AdoptionController_animalAdopted23_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdopted23_invoker.call(AdoptionController_3.animalAdopted)
      }
  
    // @LINE:49
    case controllers_SubscriptionController_create24_route(params@_) =>
      call { 
        controllers_SubscriptionController_create24_invoker.call(SubscriptionController_2.create)
      }
  
    // @LINE:50
    case controllers_SubscriptionController_read25_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_read25_invoker.call(SubscriptionController_2.read(id))
      }
  
    // @LINE:51
    case controllers_SubscriptionController_readAll26_route(params@_) =>
      call { 
        controllers_SubscriptionController_readAll26_invoker.call(SubscriptionController_2.readAll)
      }
  
    // @LINE:53
    case controllers_SubscriptionController_delete27_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_delete27_invoker.call(SubscriptionController_2.delete(id))
      }
  
    // @LINE:55
    case controllers_SubscriptionController_subscriptionExists28_route(params@_) =>
      call { 
        controllers_SubscriptionController_subscriptionExists28_invoker.call(SubscriptionController_2.subscriptionExists)
      }
  
    // @LINE:57
    case controllers_SubscriptionController_readSubscriptionByAnimalAndUserId29_route(params@_) =>
      call { 
        controllers_SubscriptionController_readSubscriptionByAnimalAndUserId29_invoker.call(SubscriptionController_2.readSubscriptionByAnimalAndUserId)
      }
  
    // @LINE:60
    case controllers_AdminController_create30_route(params@_) =>
      call { 
        controllers_AdminController_create30_invoker.call(AdminController_6.create)
      }
  
    // @LINE:61
    case controllers_AdminController_readAll31_route(params@_) =>
      call { 
        controllers_AdminController_readAll31_invoker.call(AdminController_6.readAll)
      }
  
    // @LINE:62
    case controllers_AdminController_adminExists32_route(params@_) =>
      call { 
        controllers_AdminController_adminExists32_invoker.call(AdminController_6.adminExists)
      }
  
    // @LINE:64
    case controllers_AdminController_delete33_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdminController_delete33_invoker.call(AdminController_6.delete(id))
      }
  
    // @LINE:67
    case controllers_VetController_create34_route(params@_) =>
      call { 
        controllers_VetController_create34_invoker.call(VetController_5.create)
      }
  
    // @LINE:68
    case controllers_VetController_readAll35_route(params@_) =>
      call { 
        controllers_VetController_readAll35_invoker.call(VetController_5.readAll)
      }
  
    // @LINE:70
    case controllers_VetController_delete36_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VetController_delete36_invoker.call(VetController_5.delete(id))
      }
  
    // @LINE:73
    case controllers_AdopterController_create37_route(params@_) =>
      call { 
        controllers_AdopterController_create37_invoker.call(AdopterController_1.create)
      }
  
    // @LINE:74
    case controllers_AdopterController_readAll38_route(params@_) =>
      call { 
        controllers_AdopterController_readAll38_invoker.call(AdopterController_1.readAll)
      }
  
    // @LINE:76
    case controllers_AdopterController_delete39_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdopterController_delete39_invoker.call(AdopterController_1.delete(id))
      }
  
    // @LINE:79
    case controllers_VetController_vetExists40_route(params@_) =>
      call { 
        controllers_VetController_vetExists40_invoker.call(VetController_5.vetExists)
      }
  
    // @LINE:82
    case controllers_VaccineController_create41_route(params@_) =>
      call { 
        controllers_VaccineController_create41_invoker.call(VaccineController_0.create)
      }
  
    // @LINE:83
    case controllers_VaccineController_readAll42_route(params@_) =>
      call { 
        controllers_VaccineController_readAll42_invoker.call(VaccineController_0.readAll)
      }
  
    // @LINE:85
    case controllers_VaccineController_delete43_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_VaccineController_delete43_invoker.call(VaccineController_0.delete(id))
      }
  
    // @LINE:87
    case controllers_VaccineController_readAllAnimalVaccines44_route(params@_) =>
      call { 
        controllers_VaccineController_readAllAnimalVaccines44_invoker.call(VaccineController_0.readAllAnimalVaccines)
      }
  
    // @LINE:90
    case controllers_Assets_versioned45_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned45_invoker.call(Assets_8.versioned(path, file))
      }
  }
}
