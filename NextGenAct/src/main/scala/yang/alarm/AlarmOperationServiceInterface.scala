package yang.alarm

import java.util
import java.util.List

import com.nsn.oss.nbi.fm.operation.ServiceLocator
import com.nsn.oss.nbi.fm.operation.interfaces.{AlarmCounts, Filter, UserInfo}
/**
  * Created by y28yang on 2/3/2016.
  */
trait AlarmOperationServiceInterface {
  def getAllAlarmCounts(filters:List[Filter],userInfo: UserInfo):AlarmCounts
}

class AlarmOperationServiceImpl extends AlarmOperationServiceInterface{
  override def getAllAlarmCounts(filters: util.List[Filter], userInfo: UserInfo): AlarmCounts = {
     ServiceLocator.getAlarmMonitorPort().getAllAlarmCounts(filters, userInfo)
  }
}
