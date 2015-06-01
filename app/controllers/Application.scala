package controllers


import models.UserForm
import play.api.Play
import play.api.data.Form
import play.api.mvc._
import play.api.data.Forms._
import play.api.db.slick.{HasDatabaseConfig, DatabaseConfigProvider}
import models.tableUserT
import slick.driver.JdbcProfile



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
      val resultingUsers = dbConfig.db.run(users.filter(_.name === "abc").result)
      Ok(views.html.index("" + resultingUsers))
    }
  }
