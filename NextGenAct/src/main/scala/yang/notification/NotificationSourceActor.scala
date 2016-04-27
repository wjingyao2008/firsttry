package yang.notification

import akka.actor.{Actor, ActorLogging, ActorRef}
import com.nsn.oss.nbi.fm.notification.EnrichedNotificationDTO
import yang.notification.UserProtocol._


/**
  * Created by y28yang on 3/31/2016.
  */
class NotificationSourceActor( alarmNotificationConvert:AlarmNotificationConvert,
                               flexMappingActor: ActorRef) extends Actor with ActorLogging {


  override def receive: Receive = {

    case enrichedNotificationDTO: EnrichedNotificationDTO =>
      val alarmNoti=alarmNotificationConvert.convert(enrichedNotificationDTO)
      flexMappingActor ! alarmNoti

  }
}
