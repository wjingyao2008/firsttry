package yang.Protocol

import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
import org.omg.CORBA.IntHolder

/**
  * Created by y28yang on 1/31/2016.
  */
object AlarmOptPtl {
   case object get_alarm_IRP_versions_msg
   case class  get_alarm_IRP_operations_profile_msg(alarm_irp_version: String)
   case class request_get_alarm_count(filter: StringTypeOpt)
   case class reply_get_alarm_count(critical_count: Int,
                                    major_count: Int,
                                    minor_count: Int,
                                    warning_count: Int,
                                    indeterminate_count: Int,
                                    cleared_count: Int)

}
