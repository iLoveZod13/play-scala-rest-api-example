package v1.complianceApi

import play.api.mvc.RequestHeader

import javax.inject.Inject
import play.api.routing._
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


class ComplianceRouter @Inject() (controller: ComplianceController) extends SimpleRouter {
  val prefix = "/v1/complianceApi"
  override def routes: Routes = {
    case POST(p"/") => controller.process
  }
}
