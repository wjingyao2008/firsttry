package yang.notification.was

import javax.xml.ws.Endpoint

import akka.actor.ActorRef
import com.nsn.oss.nbi.fm.notification._
import com.nsn.oss.nbi.fm.notification.callback.{MapMessage, NotificationDTO, NotificationWSCallbackInterface}
import org.apache.log4j.Logger

/**
  * Created by y28yang on 3/30/2016.
  */
@javax.jws.WebService(serviceName = "NotificationWSCallbackInterfaceService", portName = "nd-callback", targetNamespace = "http://www.nokiasiemens.com/nd-callback", endpointInterface = "com.nsn.oss.nbi.fm.notification.callback.NotificationWSCallbackInterface")
class NotificationCallBack(callbackHostName: String,
                           sourceActor: ActorRef) extends NotificationWSCallbackInterface {
  val LOGGER: Logger = Logger.getLogger(classOf[NotificationCallBack])

  var endpoint: Endpoint = null

  def start() {
    endpoint = NotificationWSCallbackPublisher.getInstance().publish(this, callbackHostName)
    LOGGER.debug("Callback is published in " + callbackHostName)
  }

  def stop() {
    if (endpoint != null) endpoint.stop()
  }

  override def processNotification(notificationDTO: NotificationDTO): Unit = {
    printAlarm(notificationDTO)
    val enrichedNotification = new EnrichedNotificationDTO(System.currentTimeMillis, notificationDTO)
    sourceActor ! enrichedNotification
  }


  private def printAlarm(notificationDTO: NotificationDTO): Unit = {
    //    if (LOGGER.isDebugEnabled) {
    LOGGER.debug("Got notification from icf! And the type is: " + notificationDTO.getNotificationType)
    LOGGER.debug("Received alarm information: " + notificationDTO.getTextMessage.getText)
    printMapMessage(notificationDTO)
    //    }
  }

  private def printMapMessage(notificationDTO: NotificationDTO): Unit = {
    val mapMessage: MapMessage = notificationDTO.getMapMessage
    if (mapMessage == null || mapMessage.getMapData == null || mapMessage.getMapData.getItem == null) {
      LOGGER.warn("Map message is empty ")
      return
    }
    val sb: StringBuilder = new StringBuilder
    sb.append("Received alarm map message: ")
    import scala.collection.JavaConversions._
    for (item <- mapMessage.getMapData.getItem) {
      sb.append(item.getKey)
      sb.append("=")
      sb.append(item.getValue)
      sb.append(",")
    }
    LOGGER.debug(sb)
  }


}
