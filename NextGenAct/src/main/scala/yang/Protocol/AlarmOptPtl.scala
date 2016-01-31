package yang.Protocol

/**
  * Created by y28yang on 1/31/2016.
  */
object AlarmOptPtl {
   case object get_alarm_IRP_versions_msg
   case class  get_alarm_IRP_operations_profile_msg(alarm_irp_version: String)
}
