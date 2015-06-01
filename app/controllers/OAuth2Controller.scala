package controllers

import models.MyDataHandler
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scalaoauth2.provider._

/**
 * Created by knoldus on 29/5/15.
 */


trait OAuth2Controller extends Controller with OAuth2Provider {

  def accessToken: Action[AnyContent] = Action.async { implicit request =>
    println(request.toString)
    issueAccessToken(new MyDataHandler())
  }
}

object OAuth2Controller extends OAuth2Controller