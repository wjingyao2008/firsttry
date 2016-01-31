package yang

import java.util.concurrent.TimeoutException

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive
import akka.pattern.ask
import com.nsn.oss.nbi.common.Logger
import yang.Protocol.AlarmOptPtl.get_alarm_IRP_versions_msg
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.util.Timeout
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.{BadAcknowledgeAlarmInfoSeqHolder, AlarmInformationIdAndSev, BadAlarmInformationIdSeqHolder, DNTypeOpt}
import com.nsn.oss.nbi.corba.AlarmIRPSystem.{AlarmIRPPOA, GetAlarmIRPVersions, AlarmInformationIteratorHolder, AlarmIRPOperations}
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.{Signal, StringTypeOpt, Method}
import org.omg.CORBA.{IntHolder, BooleanHolder}
import org.omg.CosNotification.StructuredEvent




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
         LOGGER.error("Fail to get alarm irp versions", e.getMessage);
         throw new GetAlarmIRPVersions(e.getMessage);
       }
     }
  }


  override def get_alarm_count(filter: StringTypeOpt, critical_count: IntHolder, major_count: IntHolder, minor_count: IntHolder, warning_count: IntHolder, indeterminate_count: IntHolder, cleared_count: IntHolder): Unit = ???

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
        LOGGER.error("Fail to get alarm irp notification profile", e.getMessage);
        throw new GetAlarmIRPVersions(e.getMessage);
      }
    }
  }

  override def get_alarm_IRP_notification_profile(alarm_irp_version: String): Array[Method] = ???


}
