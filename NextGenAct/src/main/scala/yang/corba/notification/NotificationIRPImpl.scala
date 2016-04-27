package yang.corba.notification

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.{Method, StringTypeOpt, StringTypeOptHolder}
import com.nsn.oss.nbi.corba.NotificationIRPConstDefs.{NotificationTypesSetHolder, SubscriptionStateHolder}
import com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPPOA
import org.apache.log4j.Logger
import org.omg.CORBA.IntHolder
import org.omg.CosNotifyChannelAdmin.{SequenceProxyPullSupplierHolder, SequenceProxyPushSupplierHolder}
import yang.corba.DeployableProxy
import yang.corba.notification.NotificationCorbaProtocol.AttachInfo
import yang.notification.UserProtocol.{Attach, User}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by y28yang on 3/30/2016.
  */
class NotificationIRPImpl(notificationIRPActor: ActorRef, timeoutSec: Long) extends NotificationIRPPOA with DeployableProxy {
  implicit val timeout = Timeout(timeoutSec seconds)
  private val LOGGER = Logger.getLogger(classOf[NotificationIRPImpl])

  def this(notificationIRPActor: ActorRef) = this(notificationIRPActor, 15)


  override def get_notification_IRP_notification_profile(s: String): Array[Method] = ???

  override def detach(s: String, s1: String): Unit = {
    ???
  }

  override def attach_pull(s: String, i: Int, strings: Array[String], stringTypeOpt: StringTypeOpt, sequenceProxyPullSupplierHolder: SequenceProxyPullSupplierHolder): String = ???

  override def get_notification_categories(notificationTypesSetHolder: NotificationTypesSetHolder): Array[String] = ???

  override def get_notification_IRP_operations_profile(s: String): Array[Method] = ???

  override def change_subscription_filter(s: String, s1: String): Unit = {
    ???
  }

  override def get_subscription_status(s: String, stringTypeOptHolder: StringTypeOptHolder, subscriptionStateHolder: SubscriptionStateHolder, intHolder: IntHolder): Array[String] = ???

  override def get_notification_IRP_versions(): Array[String] = ???

  override def get_subscription_ids(s: String): Array[String] = ???

  override def attach_push_b(s: String, i: Int, strings: Array[String], stringTypeOpt: StringTypeOpt, sequenceProxyPushSupplierHolder: SequenceProxyPushSupplierHolder): String = ???

  override def attach_push(manager_reference: String, time_tick: Int, notification_categories: Array[String], filter: StringTypeOpt): String = {
    //TODO proxy deploy here
    val filterStr = if (filter.discriminator) filter.value() else ""
    val attachInfo = Some(AttachInfo(manager_reference, time_tick, filterStr, proxyId))
    val futureResult = notificationIRPActor ? Attach(User("test1", attachInfo))
    try {
      //3GPP-Corba-NB@2 here
      Await.result(futureResult, timeout.duration).asInstanceOf[String]
    } catch {
      case e: Exception =>
        LOGGER.error("Fail to attach", e)
        throw new com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach(e.getMessage)
    }
  }
}
