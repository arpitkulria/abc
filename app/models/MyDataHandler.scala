package models

import java.util.Date

import org.apache.http.auth.AUTH

import scala.concurrent.Future
import scalaoauth2.provider
import scalaoauth2.provider._
import scala.concurrent.ExecutionContext.Implicits.global

//import scalaoauth2.provider.{AccessToken, ClientCredential, DataHandler}

/**
 * Created by knoldus on 29/5/15.
 */
case class User(id: Long, name: String, hashedPassword: String)

class MyDataHandler extends DataHandler[User] {

  val userObj = User(12.toLong, "", "")
  val oauthUser: AuthInfo[User] = AuthInfo(userObj,Some(""),Some(""),Some(""))

  def validateClient(clientCredential: ClientCredential, grantType: String): Future[Boolean] = Future(true)

  def findUser(username: String, password: String): Future[Option[User]] = Future(None)

  def  findAuthInfoByCode(code: String): Future[Option[AuthInfo[User]]] = Future(None)

  def findAuthInfoByRefreshToken(refreshToken: String): Future[Option[AuthInfo[User]]] = Future(None)

  def findClientUser(clientCredential: ClientCredential, scope: Option[String]): Future[Option[User]] = Future(None)

  def deleteAuthCode(code: String): Future[Unit] = Future(Unit)

  def findAccessToken(token: String): Future[Option[AccessToken]] = Future(Some(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date)))

  def findAuthInfoByAccessToken(accessToken: AccessToken): Future[Option[AuthInfo[User]]] = Future(None)

  def createAccessToken(authInfo: provider.AuthInfo[User]): Future[AccessToken] = Future(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date))

  def refreshAccessToken(authInfo: provider.AuthInfo[User], refreshToken: String): Future[AccessToken] = Future(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date))

   def getStoredAccessToken(authInfo: provider.AuthInfo[User]): Future[Option[AccessToken]] = Future(Some(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date)))
}


/*
case class AuthInfo[User](
                           user: User,
                           clientId: Option[String],
                           scope: Option[String],
                           redirectUri: Option[String]
                           )*/
