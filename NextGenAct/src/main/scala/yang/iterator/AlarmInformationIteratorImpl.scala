package yang.iterator

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import com.nsn.oss.nbi.common.Logger
import com.nsn.oss.nbi.corba.AlarmIRPSystem.{AlarmInformationIteratorPOA, NextAlarmInformations}
import org.omg.CosNotification.{EventBatchHolder, StructuredEvent}
import yang.iterator.IteratorProtocol._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by y28yang on 2/16/2016.
  */
class AlarmInformationIteratorImpl(val iteratorActor: ActorRef, timeoutSec: Long) extends AlarmInformationIteratorPOA with TimeoutCheckable {
  val LOGGER = Logger.getLogger("AlarmInformationIteratorImpl")
  implicit val timeout = Timeout(timeoutSec seconds)

  //test for remote git
  override def destroy(): Unit = {
    iteratorActor ! RequestDestroyIterator
  }

  override def next_alarmInformations(howMany: Short, eventBatchHolder: EventBatchHolder): Boolean = {
    touch()
    val futureResult = iteratorActor ? request_next_date(howMany)
    try {
      val respond = Await.result(futureResult, timeout.duration).asInstanceOf[RespondNextDate[StructuredEvent]]
      eventBatchHolder.value = respond.structuredEvents.toArray
      respond.hasNext
    } catch {
      case e: Exception =>
        LOGGER.error("Fail to next alarm": Any, e: Throwable)
        throw new NextAlarmInformations(e.getMessage)

    }
  }
}
