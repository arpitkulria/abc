package controllers


import models.UserForm
import play.api.Play
import play.api.data.Form
import play.api.db.slick.{HasDatabaseConfig, DatabaseConfigProvider}
import models.tableUserT
import slick.driver.JdbcProfile
import play.api.data.Forms._
import play.api.mvc._

import scala.concurrent.Await
import scala.concurrent.duration._


class Application extends Controller with tableUserT with HasDatabaseConfig[JdbcProfile] {
  import driver.api._
  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
    val users = TableQuery[UserTable]

    def index = Action {
      Ok(views.html.index("Your new application is ready."))
    }

    val userF = Form(
      mapping(
        "userName" -> text(),
        "password" -> text()
      )(UserForm.apply)(UserForm.unapply)
    )

    def insert = Action { implicit rs =>
      val usr = userF.bindFromRequest.get
      val resultingUsers = Await.result(dbConfig.db.run(users.forceInsert(usr)), 10 seconds)
      Ok(" Insert - - - " + resultingUsers)
    }

  def show = Action{ implicit rs =>
    val resultingUsers = Await.result(dbConfig.db.run(users.result), 10 seconds)
    Ok(" Show - - - " + resultingUsers)
  }
  }
