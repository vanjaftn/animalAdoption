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
  HomeController_6: controllers.HomeController,
  // @LINE:10
  UserController_4: controllers.UserController,
  // @LINE:19
  AnimalController_2: controllers.AnimalController,
  // @LINE:29
  AdoptionController_1: controllers.AdoptionController,
  // @LINE:43
  SubscriptionController_0: controllers.SubscriptionController,
  // @LINE:54
  AdminController_3: controllers.AdminController,
  // @LINE:61
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_6: controllers.HomeController,
    // @LINE:10
    UserController_4: controllers.UserController,
    // @LINE:19
    AnimalController_2: controllers.AnimalController,
    // @LINE:29
    AdoptionController_1: controllers.AdoptionController,
    // @LINE:43
    SubscriptionController_0: controllers.SubscriptionController,
    // @LINE:54
    AdminController_3: controllers.AdminController,
    // @LINE:61
    Assets_5: controllers.Assets
  ) = this(errorHandler, HomeController_6, UserController_4, AnimalController_2, AdoptionController_1, SubscriptionController_0, AdminController_3, Assets_5, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_6, UserController_4, AnimalController_2, AdoptionController_1, SubscriptionController_0, AdminController_3, Assets_5, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loggedInUser""", """controllers.UserController.readLoggedInUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readAllAnimalPendingAdoptions""", """controllers.UserController.readAllAnimalPendingAdoptions"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal""", """controllers.AnimalController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAnimals""", """controllers.AnimalController.readAll"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateAnimal""", """controllers.AnimalController.update"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAnimal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animal/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.read(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdoptedAnimals""", """controllers.AnimalController.readAllAdopted"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allUsersSubscribedAnimals""", """controllers.AnimalController.readAllUsersSubscribedAnimals"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allAdmin""", """controllers.AdminController.readAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminExists""", """controllers.AdminController.adminExists"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteAdmin/""" + "$" + """id<[^/]+>""", """controllers.AdminController.delete(id:String)"""),
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
    HomeController_6.index(),
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
    UserController_4.loginUser,
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

  // @LINE:11
  private[this] lazy val controllers_UserController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserController_create2_invoker = createInvoker(
    UserController_4.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "create",
      Nil,
      "POST",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_readAll3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsers")))
  )
  private[this] lazy val controllers_UserController_readAll3_invoker = createInvoker(
    UserController_4.readAll,
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

  // @LINE:13
  private[this] lazy val controllers_UserController_read4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_read4_invoker = createInvoker(
    UserController_4.read(fakeValue[String]),
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

  // @LINE:14
  private[this] lazy val controllers_UserController_readLoggedInUser5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loggedInUser")))
  )
  private[this] lazy val controllers_UserController_readLoggedInUser5_invoker = createInvoker(
    UserController_4.readLoggedInUser,
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

  // @LINE:16
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdoptions6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readAllAnimalPendingAdoptions")))
  )
  private[this] lazy val controllers_UserController_readAllAnimalPendingAdoptions6_invoker = createInvoker(
    UserController_4.readAllAnimalPendingAdoptions,
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

  // @LINE:19
  private[this] lazy val controllers_AnimalController_create7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal")))
  )
  private[this] lazy val controllers_AnimalController_create7_invoker = createInvoker(
    AnimalController_2.create,
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

  // @LINE:20
  private[this] lazy val controllers_AnimalController_readAll8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAll8_invoker = createInvoker(
    AnimalController_2.readAll,
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

  // @LINE:21
  private[this] lazy val controllers_AnimalController_update9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateAnimal")))
  )
  private[this] lazy val controllers_AnimalController_update9_invoker = createInvoker(
    AnimalController_2.update,
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

  // @LINE:23
  private[this] lazy val controllers_AnimalController_delete10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAnimal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_delete10_invoker = createInvoker(
    AnimalController_2.delete(fakeValue[String]),
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

  // @LINE:24
  private[this] lazy val controllers_AnimalController_read11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animal/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_read11_invoker = createInvoker(
    AnimalController_2.read(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_AnimalController_readAllAdopted12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllAdopted12_invoker = createInvoker(
    AnimalController_2.readAllAdopted,
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

  // @LINE:26
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allUsersSubscribedAnimals")))
  )
  private[this] lazy val controllers_AnimalController_readAllUsersSubscribedAnimals13_invoker = createInvoker(
    AnimalController_2.readAllUsersSubscribedAnimals,
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

  // @LINE:29
  private[this] lazy val controllers_AdoptionController_create14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption")))
  )
  private[this] lazy val controllers_AdoptionController_create14_invoker = createInvoker(
    AdoptionController_1.create,
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

  // @LINE:31
  private[this] lazy val controllers_AdoptionController_adminApprove15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminApprove")))
  )
  private[this] lazy val controllers_AdoptionController_adminApprove15_invoker = createInvoker(
    AdoptionController_1.adminApprove,
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

  // @LINE:32
  private[this] lazy val controllers_AdoptionController_readAll16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdoptions")))
  )
  private[this] lazy val controllers_AdoptionController_readAll16_invoker = createInvoker(
    AdoptionController_1.readAll,
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

  // @LINE:34
  private[this] lazy val controllers_AdoptionController_delete17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_delete17_invoker = createInvoker(
    AdoptionController_1.delete(fakeValue[String]),
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

  // @LINE:36
  private[this] lazy val controllers_AdoptionController_read18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adoption/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdoptionController_read18_invoker = createInvoker(
    AdoptionController_1.read(fakeValue[String]),
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

  // @LINE:38
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readByUserAndAnimalId")))
  )
  private[this] lazy val controllers_AdoptionController_readByUserAndAnimalId19_invoker = createInvoker(
    AdoptionController_1.readByUserAndAnimalId,
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

  // @LINE:40
  private[this] lazy val controllers_AdoptionController_animalAdopted20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animalAdopted")))
  )
  private[this] lazy val controllers_AdoptionController_animalAdopted20_invoker = createInvoker(
    AdoptionController_1.animalAdopted,
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

  // @LINE:43
  private[this] lazy val controllers_SubscriptionController_create21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription")))
  )
  private[this] lazy val controllers_SubscriptionController_create21_invoker = createInvoker(
    SubscriptionController_0.create,
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

  // @LINE:44
  private[this] lazy val controllers_SubscriptionController_read22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_read22_invoker = createInvoker(
    SubscriptionController_0.read(fakeValue[String]),
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

  // @LINE:45
  private[this] lazy val controllers_SubscriptionController_readAll23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allSubscriptions")))
  )
  private[this] lazy val controllers_SubscriptionController_readAll23_invoker = createInvoker(
    SubscriptionController_0.readAll,
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

  // @LINE:47
  private[this] lazy val controllers_SubscriptionController_delete24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSubscription/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_delete24_invoker = createInvoker(
    SubscriptionController_0.delete(fakeValue[String]),
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

  // @LINE:49
  private[this] lazy val controllers_SubscriptionController_subscriptionExists25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionExists")))
  )
  private[this] lazy val controllers_SubscriptionController_subscriptionExists25_invoker = createInvoker(
    SubscriptionController_0.subscriptionExists,
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

  // @LINE:51
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscriptionByAnimalId")))
  )
  private[this] lazy val controllers_SubscriptionController_readSubscriptionByAnimalAndUserId26_invoker = createInvoker(
    SubscriptionController_0.readSubscriptionByAnimalAndUserId,
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

  // @LINE:54
  private[this] lazy val controllers_AdminController_create27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_AdminController_create27_invoker = createInvoker(
    AdminController_3.create,
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

  // @LINE:55
  private[this] lazy val controllers_AdminController_readAll28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allAdmin")))
  )
  private[this] lazy val controllers_AdminController_readAll28_invoker = createInvoker(
    AdminController_3.readAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "readAll",
      Nil,
      "GET",
      this.prefix + """allAdmin""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_AdminController_adminExists29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminExists")))
  )
  private[this] lazy val controllers_AdminController_adminExists29_invoker = createInvoker(
    AdminController_3.adminExists,
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

  // @LINE:58
  private[this] lazy val controllers_AdminController_delete30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteAdmin/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_delete30_invoker = createInvoker(
    AdminController_3.delete(fakeValue[String]),
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

  // @LINE:61
  private[this] lazy val controllers_Assets_versioned31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned31_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_6.index())
      }
  
    // @LINE:10
    case controllers_UserController_loginUser1_route(params@_) =>
      call { 
        controllers_UserController_loginUser1_invoker.call(UserController_4.loginUser)
      }
  
    // @LINE:11
    case controllers_UserController_create2_route(params@_) =>
      call { 
        controllers_UserController_create2_invoker.call(UserController_4.create)
      }
  
    // @LINE:12
    case controllers_UserController_readAll3_route(params@_) =>
      call { 
        controllers_UserController_readAll3_invoker.call(UserController_4.readAll)
      }
  
    // @LINE:13
    case controllers_UserController_read4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_read4_invoker.call(UserController_4.read(id))
      }
  
    // @LINE:14
    case controllers_UserController_readLoggedInUser5_route(params@_) =>
      call { 
        controllers_UserController_readLoggedInUser5_invoker.call(UserController_4.readLoggedInUser)
      }
  
    // @LINE:16
    case controllers_UserController_readAllAnimalPendingAdoptions6_route(params@_) =>
      call { 
        controllers_UserController_readAllAnimalPendingAdoptions6_invoker.call(UserController_4.readAllAnimalPendingAdoptions)
      }
  
    // @LINE:19
    case controllers_AnimalController_create7_route(params@_) =>
      call { 
        controllers_AnimalController_create7_invoker.call(AnimalController_2.create)
      }
  
    // @LINE:20
    case controllers_AnimalController_readAll8_route(params@_) =>
      call { 
        controllers_AnimalController_readAll8_invoker.call(AnimalController_2.readAll)
      }
  
    // @LINE:21
    case controllers_AnimalController_update9_route(params@_) =>
      call { 
        controllers_AnimalController_update9_invoker.call(AnimalController_2.update)
      }
  
    // @LINE:23
    case controllers_AnimalController_delete10_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_delete10_invoker.call(AnimalController_2.delete(id))
      }
  
    // @LINE:24
    case controllers_AnimalController_read11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AnimalController_read11_invoker.call(AnimalController_2.read(id))
      }
  
    // @LINE:25
    case controllers_AnimalController_readAllAdopted12_route(params@_) =>
      call { 
        controllers_AnimalController_readAllAdopted12_invoker.call(AnimalController_2.readAllAdopted)
      }
  
    // @LINE:26
    case controllers_AnimalController_readAllUsersSubscribedAnimals13_route(params@_) =>
      call { 
        controllers_AnimalController_readAllUsersSubscribedAnimals13_invoker.call(AnimalController_2.readAllUsersSubscribedAnimals)
      }
  
    // @LINE:29
    case controllers_AdoptionController_create14_route(params@_) =>
      call { 
        controllers_AdoptionController_create14_invoker.call(AdoptionController_1.create)
      }
  
    // @LINE:31
    case controllers_AdoptionController_adminApprove15_route(params@_) =>
      call { 
        controllers_AdoptionController_adminApprove15_invoker.call(AdoptionController_1.adminApprove)
      }
  
    // @LINE:32
    case controllers_AdoptionController_readAll16_route(params@_) =>
      call { 
        controllers_AdoptionController_readAll16_invoker.call(AdoptionController_1.readAll)
      }
  
    // @LINE:34
    case controllers_AdoptionController_delete17_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_delete17_invoker.call(AdoptionController_1.delete(id))
      }
  
    // @LINE:36
    case controllers_AdoptionController_read18_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdoptionController_read18_invoker.call(AdoptionController_1.read(id))
      }
  
    // @LINE:38
    case controllers_AdoptionController_readByUserAndAnimalId19_route(params@_) =>
      call { 
        controllers_AdoptionController_readByUserAndAnimalId19_invoker.call(AdoptionController_1.readByUserAndAnimalId)
      }
  
    // @LINE:40
    case controllers_AdoptionController_animalAdopted20_route(params@_) =>
      call { 
        controllers_AdoptionController_animalAdopted20_invoker.call(AdoptionController_1.animalAdopted)
      }
  
    // @LINE:43
    case controllers_SubscriptionController_create21_route(params@_) =>
      call { 
        controllers_SubscriptionController_create21_invoker.call(SubscriptionController_0.create)
      }
  
    // @LINE:44
    case controllers_SubscriptionController_read22_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_read22_invoker.call(SubscriptionController_0.read(id))
      }
  
    // @LINE:45
    case controllers_SubscriptionController_readAll23_route(params@_) =>
      call { 
        controllers_SubscriptionController_readAll23_invoker.call(SubscriptionController_0.readAll)
      }
  
    // @LINE:47
    case controllers_SubscriptionController_delete24_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_SubscriptionController_delete24_invoker.call(SubscriptionController_0.delete(id))
      }
  
    // @LINE:49
    case controllers_SubscriptionController_subscriptionExists25_route(params@_) =>
      call { 
        controllers_SubscriptionController_subscriptionExists25_invoker.call(SubscriptionController_0.subscriptionExists)
      }
  
    // @LINE:51
    case controllers_SubscriptionController_readSubscriptionByAnimalAndUserId26_route(params@_) =>
      call { 
        controllers_SubscriptionController_readSubscriptionByAnimalAndUserId26_invoker.call(SubscriptionController_0.readSubscriptionByAnimalAndUserId)
      }
  
    // @LINE:54
    case controllers_AdminController_create27_route(params@_) =>
      call { 
        controllers_AdminController_create27_invoker.call(AdminController_3.create)
      }
  
    // @LINE:55
    case controllers_AdminController_readAll28_route(params@_) =>
      call { 
        controllers_AdminController_readAll28_invoker.call(AdminController_3.readAll)
      }
  
    // @LINE:56
    case controllers_AdminController_adminExists29_route(params@_) =>
      call { 
        controllers_AdminController_adminExists29_invoker.call(AdminController_3.adminExists)
      }
  
    // @LINE:58
    case controllers_AdminController_delete30_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AdminController_delete30_invoker.call(AdminController_3.delete(id))
      }
  
    // @LINE:61
    case controllers_Assets_versioned31_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned31_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
