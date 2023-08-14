// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAnimalController AnimalController = new controllers.ReverseAnimalController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSubscriptionController SubscriptionController = new controllers.ReverseSubscriptionController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdoptionController AdoptionController = new controllers.ReverseAdoptionController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAnimalController AnimalController = new controllers.javascript.ReverseAnimalController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSubscriptionController SubscriptionController = new controllers.javascript.ReverseSubscriptionController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdoptionController AdoptionController = new controllers.javascript.ReverseAdoptionController(RoutesPrefix.byNamePrefix());
  }

}
