// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Qi_Workspace/IdeaProjects/PlayScalaRestApi/conf/routes
// @DATE:Tue Mar 23 11:38:59 CST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  v1_complianceApi_ComplianceRouter_0: v1.complianceApi.ComplianceRouter,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    v1_complianceApi_ComplianceRouter_0: v1.complianceApi.ComplianceRouter
  ) = this(errorHandler, v1_complianceApi_ComplianceRouter_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, v1_complianceApi_ComplianceRouter_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    prefixed_v1_complianceApi_ComplianceRouter_0_0.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] val prefixed_v1_complianceApi_ComplianceRouter_0_0 = Include(v1_complianceApi_ComplianceRouter_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "v1/complianceApi"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case prefixed_v1_complianceApi_ComplianceRouter_0_0(handler) => handler
  }
}
