package yang.alarm

import java.util.List
import java.util.List
import javax.xml.datatype.XMLGregorianCalendar
import org.apache.log4j.Logger
import com.nsn.oss.nbi.fm.operation.interfaces.AckAlarmsByKeysFault
import com.nsn.oss.nbi.fm.operation.interfaces.AlarmCounts
import com.nsn.oss.nbi.fm.operation.interfaces.AlarmKeyResult
import com.nsn.oss.nbi.fm.operation.interfaces.AlarmMonitorSEI
import com.nsn.oss.nbi.fm.operation.interfaces.ClearAlarmsByKeysFault
import com.nsn.oss.nbi.fm.operation.interfaces.Filter
import com.nsn.oss.nbi.fm.operation.interfaces.GetActiveAlarmsFault
import com.nsn.oss.nbi.fm.operation.interfaces.GetAlarmsByKeysFault
import com.nsn.oss.nbi.fm.operation.interfaces.GetAlarmsByTemplateFault
import com.nsn.oss.nbi.fm.operation.interfaces.GetAlarmsCountsFault
import com.nsn.oss.nbi.fm.operation.interfaces.GetAllAlarmsFault
import com.nsn.oss.nbi.fm.operation.interfaces.IterationFault
import com.nsn.oss.nbi.fm.operation.interfaces.NsnAlarm
import com.nsn.oss.nbi.fm.operation.interfaces.NsnAlarmKey
import com.nsn.oss.nbi.fm.operation.interfaces.UnAckAlarmsByKeysFault
import com.nsn.oss.nbi.fm.operation.interfaces.UserInfo
/**
  * Created by y28yang on 2/3/2016.
  */
trait AlarmOperationServiceInterface {
  def getAllAlarmCounts(filters:List[Filter],userInfo: UserInfo):AlarmCounts
}
