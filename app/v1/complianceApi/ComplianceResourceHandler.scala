package v1.complianceApi


import play.api.MarkerContext

import javax.inject.{Inject, Provider}
import scala.concurrent.{ExecutionContext, Future}
import play.api.libs.json._


case class ComplianceResource(id: Int, title: String)
object ComplianceResource {
  implicit val format: Format[ComplianceResource] = Json.format
}

class ComplianceResourceHandler @Inject()(complianceRepo: ComplianceRepository)(implicit ec: ExecutionContext) {
  def lookup()(implicit mc: MarkerContext) : Future[List[ComplianceResource]] = {
    val complianceFuture:Future[List[ComplianceData]]  = complianceRepo.list()
    complianceFuture.map{
      complList =>
        complList.map{
          complItem => createComplianceResource(complItem)
        }
    }
  }

  private def createComplianceResource(cd: ComplianceData): ComplianceResource = {
    ComplianceResource(cd.id, cd.title)
  }
}
