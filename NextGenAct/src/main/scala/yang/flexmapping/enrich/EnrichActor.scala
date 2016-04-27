package yang.flexmapping.enrich

import akka.actor.{Actor, ActorLogging, ActorRef}
import com.nsn.oss.nbi.interfaces.{AlarmNotificationFlow, InterfaceType}


/**
  * Created by y28yang on 4/12/2016.
  */
class EnrichActor(var enrich:Enrich,flexMappingActor: ActorRef) extends Actor with ActorLogging{
  override def receive: Receive = {
    case alarm:AlarmNotificationFlow=>
      log.info("received $alarm")
     val toFlexMapAlarmFlow=enrich.enrich(alarm, InterfaceType.ALARM_NOTIFICATAION)
      flexMappingActor ! toFlexMapAlarmFlow
  }
}
