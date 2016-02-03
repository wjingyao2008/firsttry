package yang

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import org.apache.log4j.Logger
import org.omg.CORBA.{BooleanHolder, IntHolder}
import org.omg.CosNotification.StructuredEvent
import yang.Protocol.AlarmOptPtl.{get_alarm_IRP_versions_msg, reply_get_alarm_count, request_get_alarm_count}
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.{AlarmInformationIdAndSev, BadAcknowledgeAlarmInfoSeqHolder, BadAlarmInformationIdSeqHolder, DNTypeOpt}
import com.nsn.oss.nbi.corba.AlarmIRPSystem.{AlarmIRPOperations, AlarmIRPPOA, AlarmInformationIteratorHolder, GetAlarmIRPVersions}
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.{Method, Signal, StringTypeOpt}

import scala.concurrent.Await
import scala.concurrent.duration._




/**
  * Created by y28yang on 1/30/2016.
  */

class AlarmOperationImpl(alarmOperationActor:ActorRef) extends AlarmIRPPOA with AlarmIRPOperations{
  implicit val timeout = Timeout(5 seconds)
  private val LOGGER = Logger.getLogger(classOf[AlarmOperationImpl])

  override def get_alarm_IRP_versions(): Array[String] = {
     val futureResult=alarmOperationActor ? get_alarm_IRP_versions_msg
     try{
      Await.result(futureResult,timeout.duration).asInstanceOf[Array[String]]
     }catch{
       case e:Exception=> {
         LOGGER.error("Fail to get alarm irp versions", e);
         throw new GetAlarmIRPVersions(e.getMessage);
       }
     }
  }


  override def get_alarm_count(filter: StringTypeOpt, critical_count: IntHolder,
                               major_count: IntHolder, minor_count: IntHolder,
                               warning_count: IntHolder, indeterminate_count: IntHolder,
                               cleared_count: IntHolder): Unit = {
    val filterStr=filter.value()
    val futureResult=alarmOperationActor ? request_get_alarm_count(filterStr)
    try{
      val result=Await.result(futureResult,timeout.duration).asInstanceOf[reply_get_alarm_count]
      critical_count.value=result.critical_count
      major_count.value=result.major_count
      minor_count.value=result.minor_count
      warning_count.value=result.warning_count
      indeterminate_count.value=result.indeterminate_count
      cleared_count.value=result.cleared_count
    }catch{
      case e:Exception=> {
        LOGGER.error("Fail to get alarm irp versions", e);
        throw new GetAlarmIRPVersions(e.getMessage);
      }
    }
  }

  override def acknowledge_alarms(alarm_information_id_and_sev_list: Array[AlarmInformationIdAndSev], ack_user_id: String, ack_system_id: StringTypeOpt, bad_ack_alarm_info_list: BadAcknowledgeAlarmInfoSeqHolder): Signal = ???

  override def comment_alarms(alarm_information_id_list: Array[String], comment_user_id: String, comment_system_id: StringTypeOpt, comment_text: String, bad_alarm_information_id_list: BadAlarmInformationIdSeqHolder): Signal = ???

  override def unacknowledge_alarms(alarm_information_id_list: Array[String], ack_user_id: String, ack_system_id: StringTypeOpt, bad_alarm_information_id_list: BadAlarmInformationIdSeqHolder): Signal = ???

  override def clear_alarms(alarm_information_id_list: Array[String], clear_user_id: String, clear_system_id: StringTypeOpt, bad_alarm_information_id_list: BadAlarmInformationIdSeqHolder): Signal = ???

  override def get_alarm_list(filter: StringTypeOpt, base_object: DNTypeOpt, flag: BooleanHolder, iter: AlarmInformationIteratorHolder): Array[StructuredEvent] = ???

  override def get_alarm_IRP_operations_profile(alarm_irp_version: String): Array[Method] = {
    val futureResult=alarmOperationActor ? get_alarm_IRP_operations_profile(alarm_irp_version)
    try{
      Await.result(futureResult,timeout.duration).asInstanceOf[Array[Method]]
    }catch{
      case e:Exception=> {
        LOGGER.error("Fail to get alarm irp notification profile", e);
        throw new GetAlarmIRPVersions(e.getMessage);
      }
    }
  }

  override def get_alarm_IRP_notification_profile(alarm_irp_version: String): Array[Method] = ???


}
