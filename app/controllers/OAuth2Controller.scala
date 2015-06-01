package controllers

import models.MyDataHandler
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{Action, AnyContent, Controller}
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scalaoauth2.provider._
import javax.inject.Inject

/**
 * Created by knoldus on 29/5/15.
 */

class OAuth2Controller  @Inject()(dbConfigProvider: DatabaseConfigProvider) extends OAuth2Provider {
  this: Controller =>
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  def accessToken: Action[AnyContent] = Action.async { implicit request =>
    println(request.toString)
    issueAccessToken(new MyDataHandler())
  }
}
