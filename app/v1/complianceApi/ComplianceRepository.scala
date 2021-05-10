package v1.complianceApi

import javax.inject.{Inject, Singleton}
import akka.actor.ActorSystem
import play.api.libs.concurrent.CustomExecutionContext
import play.api.{Logger, MarkerContext}
import scala.concurrent.Future

final case class ComplianceData(id: Int, title: String)

class ComplianceExecutionContext @Inject()(actorSystem: ActorSystem)
  extends CustomExecutionContext(actorSystem, "repository.dispatcher")

trait ComplianceRepository {
  def list()(implicit mc: MarkerContext): Future[List[ComplianceData]]
}


@Singleton
class ComplianceRepositoryImpl @Inject()()(implicit ec: ComplianceExecutionContext)
  extends ComplianceRepository {

  private val complianceList = List(
    ComplianceData(1,"Compliance Decree 1"),
    ComplianceData(2,"Compliance Decree 2"),
    ComplianceData(3,"Compliance Decree 3")
  )

  override def list()(implicit mc: MarkerContext): Future[List[ComplianceData]] = {
    Future {
      complianceList
    }
  }
}
