package v1.complianceApi

import javax.inject.Inject
import play.api.http.{FileMimeTypes, HttpVerbs}
import play.api.i18n.{Langs, MessagesApi}
import play.api.mvc._
import v1.post.RequestMarkerContext

import scala.concurrent.{ExecutionContext, Future}


trait ComplianceRequestHeader extends MessagesRequestHeader with PreferredMessagesProvider

class ComplianceRequest[A](request: Request[A], val messagesApi: MessagesApi)
  extends WrappedRequest(request)
  with ComplianceRequestHeader

class ComplianceActioniBuilder @Inject() (messagesApi: MessagesApi,
                                          playBodyParsers: PlayBodyParsers)(
                                         implicit val executionContext: ExecutionContext)
          extends ActionBuilder[ComplianceRequest, AnyContent]
          with HttpVerbs {

  override val parser: BodyParser[AnyContent] = playBodyParsers.anyContent
  type PostRequestBlock[A] = ComplianceRequest[A] => Future[Result]

  override def invokeBlock[A](request: Request[A], block: ComplianceRequest[A] => Future[Result]): Future[Result] = {
    val future = block(new ComplianceRequest(request, messagesApi))

    future.map{ result =>
      request.method match {
        case _ => result
      }
    }
  }
}

case class ComplianceControllerComponents @Inject()
            (complianceActionBuilder: ComplianceActioniBuilder,
             complianceResourceHandler: ComplianceResourceHandler,
             actionBuilder: DefaultActionBuilder,
             parsers: PlayBodyParsers,
             messagesApi: MessagesApi,
             langs: Langs,
             fileMimeTypes: FileMimeTypes,
             executionContext: scala.concurrent.ExecutionContext) extends ControllerComponents


class ComplianceBaseController @Inject()(ccc: ComplianceControllerComponents)
  extends BaseController
  with RequestMarkerContext {
  override protected def controllerComponents: ControllerComponents = ccc

  def ComplianceAction: ComplianceActioniBuilder = ccc.complianceActionBuilder

  def complianceResourceHandler: ComplianceResourceHandler = ccc.complianceResourceHandler
}
