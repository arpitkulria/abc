package models

import java.util.Date

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

  override  def validateClient(clientCredential: ClientCredential, grantType: String): Future[Boolean] = Future(true)

  override def findUser(username: String, password: String): Future[Option[User]] = Future(None)

//  def createAccessToken(authInfo: AuthInfo[User]): Future[AccessToken] = ???

//  def getStoredAccessToken(authInfo: AuthInfo[User]): Future[Option[AccessToken]] = ???

//  def refreshAccessToken(authInfo: AuthInfo[User], refreshToken: String): Future[AccessToken] = ???

  override def  findAuthInfoByCode(code: String): Future[Option[AuthInfo[User]]] = Future(None)

  override  def findAuthInfoByRefreshToken(refreshToken: String): Future[Option[AuthInfo[User]]] = Future(None)

  override def findClientUser(clientCredential: ClientCredential, scope: Option[String]): Future[Option[User]] = Future(None)

  override def deleteAuthCode(code: String): Future[Unit] = Future(Unit)

  override def findAccessToken(token: String): Future[Option[AccessToken]] = Future(Some(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date)))

  override  def findAuthInfoByAccessToken(accessToken: AccessToken): Future[Option[AuthInfo[User]]] = Future(None)

  override def createAccessToken(authInfo: provider.AuthInfo[User]): Future[AccessToken] = Future(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date))

  override def refreshAccessToken(authInfo: provider.AuthInfo[User], refreshToken: String): Future[AccessToken] = Future(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date))

  override  def getStoredAccessToken(authInfo: provider.AuthInfo[User]): Future[Option[AccessToken]] = Future(Some(AccessToken("",Some(""),Some(""),Some(12.toLong),new Date)))
}


case class AuthInfo[User](
                           user: User,
                           clientId: Option[String],
                           scope: Option[String],
                           redirectUri: Option[String]
                           )