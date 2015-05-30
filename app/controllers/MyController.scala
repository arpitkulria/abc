package controllers

import models.MyDataHandler
import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scalaoauth2.provider._

/**
 * Created by knoldus on 29/5/15.
 */

object MyController extends Controller with OAuth2Provider {
  def list = Action.async { implicit request =>
    authorize(new MyDataHandler()) { authInfo =>
      val user = authInfo.user // User is defined on your system
      // access resource for the user
      //      user
      Future(Ok(""))
    }
  }
}

//
//
//object MyController1 extends Controller {
//
//  import scalaoauth2.provider.OAuth2ProviderActionBuilders._
//
//  def list = AuthorizedAction(new MyDataHandler()) { request =>
//    val user = request.authInfo.user // User is defined on your system
//    Ok(" in mycontroller" + user)
//  }
//}