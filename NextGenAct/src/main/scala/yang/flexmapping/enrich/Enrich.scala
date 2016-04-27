package yang.flexmapping.enrich

import com.nsn.oss.nbi.interfaces.{AlarmNotificationFlow, InterfaceType}
import yang.flexmapping.FlexProtocol.ToFlexMapAlarmFlow

/**
  * Created by y28yang on 4/12/2016.
  */
trait Enrich {

  def enrich(alarmFlow:AlarmNotificationFlow,interfaceType:InterfaceType):ToFlexMapAlarmFlow;
}
