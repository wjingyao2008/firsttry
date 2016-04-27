package yang.flexmapping.enrich

import java.text.ParseException
import java.util.Date

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.interfaces._
import org.apache.commons.lang3.time.FastDateFormat
import yang.flexmapping.FlexProtocol.ToFlexMapAlarmFlow

import scala.collection.JavaConversions._
import scala.collection.mutable

/**
  * Created by y28yang on 4/12/2016.
  */
class EnrichSimpleImpl extends Enrich {
  private val FAST_DATE_FORMAT: FastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss")

  override def enrich(alarmFlow: AlarmNotificationFlow, interfaceType: InterfaceType): ToFlexMapAlarmFlow = {
    val notifications = alarmFlow.getNotifications();
    val mappedEventField=notifications.map(ns => {
      val notification = ns
      val tmpMap = new java.util.HashMap[EventField, String]()
      val dn = ns.getDn
      val liftedDN = dn

      val notificationType = ns.getNotificationType
      val strNotiType = if (notificationType != null) notificationType.value else null
      tmpMap.put(EventField.NOTIFICATION_TYPE, strNotiType)
      tmpMap.put(EventField.ALARM_ID, ns.getAlarmKey.getAlarmId.toString)
      tmpMap.put(EventField.ORIGINAL_DN, dn)
      tmpMap.put(EventField.LIFTED_DN, liftedDN)
      val ackStatus = ns.getAckStatus
      if (AlarmNotificationType.ALARM_NEW eq notificationType) {
        tmpMap.put(EventField.ACK_STATUS, AckStatus.UNACKED.value)
      }
      else {
        val staus = if (ackStatus == null) null else ackStatus.value
        tmpMap.put(EventField.ACK_STATUS, staus)
      }

      tmpMap.put(EventField.ACK_USER, ns.getAckUser)
      tmpMap.put(EventField.ADDITIONAL_TEXT1, ns.getAdditionalText1)
      tmpMap.put(EventField.ADDITIONAL_TEXT2, ns.getAdditionalText2)
      tmpMap.put(EventField.ADDITIONAL_TEXT3, ns.getAdditionalText3)
      tmpMap.put(EventField.ADDITIONAL_TEXT4, ns.getAdditionalText4)
      tmpMap.put(EventField.ADDITIONAL_TEXT5, ns.getAdditionalText5)
      tmpMap.put(EventField.ADDITIONAL_TEXT6, ns.getAdditionalText6)
      tmpMap.put(EventField.ADDITIONAL_TEXT7, ns.getAdditionalText7)
      tmpMap.put(EventField.ALARM_TEXT, ns.getAlarmText)

      tmpMap.put(EventField.CLEAR_USER, ns.getClearUser)


      val eventTime = notification.getEventTime();
      if (AlarmNotificationType.ALARM_CLEARD == notificationType) {
        tmpMap.put(EventField.CLEAR_TIME, if (eventTime == null) null
        else convertDateStringToUnifyFormat(eventTime))
      }

      tmpMap.put(EventField.NOTIFICATION_ID, notification.getOriginalAlarmId)

      tmpMap.put(EventField.EVENT_TIME, if (eventTime == null) null
      else convertDateStringToUnifyFormat(eventTime))

      tmpMap.put(EventField.EVENT_TYPE, notification.getEventType.value)
      tmpMap.put(EventField.INTERFACE_TYPE, interfaceType.value)

      val originalSeverity: OriginalSeverity = notification.getOriginalSeverity
      tmpMap.put(EventField.ORIGINAL_SEVERITY, if (originalSeverity == null) null
      else originalSeverity.value)

      val perceivedSeverity: PerceivedSeverity = notification.getPerceivedSeverity
      tmpMap.put(EventField.PERCEIVED_SEVERITY, if (perceivedSeverity == null) null
      else perceivedSeverity.value)

      tmpMap.put(EventField.PROBABAL_CAUSE, String.valueOf(notification.getProbableCauseCode))
      tmpMap.put(EventField.SPECIFIC_PROBLEM, String.valueOf(notification.getSpecificProblem))
      tmpMap
    }).toList

    ToFlexMapAlarmFlow(mappedEventField,"CREATE ALARM")
  }

  private def convertDateStringToUnifyFormat(inputDateStr: String): String = {
    try {
      val tmpDate: Date = FAST_DATE_FORMAT.parse(inputDateStr)
      return FAST_DATE_FORMAT.format(tmpDate)
    }
    catch {
      case e: ParseException => {
        return inputDateStr
      }
    }
  }
}
