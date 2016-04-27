package yang.alarm

import java.util
import com.nsn.oss.nbi.fm.operation.interfaces._
import com.nsn.oss.nbi.fm.operation.{AlarmOperationService, IteratorHolder, ServiceLocator}

/**
  * Created by y28yang on 2/3/2016.
  */
trait AlarmFmServiceInterface {
  def getAllAlarmCounts(filters: java.util.List[Filter], userInfo: UserInfo): AlarmCounts

  def getAllAlarm(filters: java.util.List[Filter], userInfo: UserInfo): Int

  @throws(classOf[IterationFault])
  def getNext(iteratorId: Int, howMany: Int): util.List[NsnAlarm]
}

class AlarmFmServiceImpl extends AlarmFmServiceInterface {
  override def getAllAlarmCounts(filters: util.List[Filter], userInfo: UserInfo): AlarmCounts = {
    ServiceLocator.getAlarmMonitorPort.getAllAlarmCounts(filters, userInfo)
  }

  override def getAllAlarm(filters: util.List[Filter], userInfo: UserInfo): Int = {
    val alarmMonitorSEI = ServiceLocator.getAlarmMonitorPort
    alarmMonitorSEI.getAllAlarms(Integer.MAX_VALUE, null, filters, userInfo)
    IteratorHolder.getInstance.offer(alarmMonitorSEI)
  }

  @throws(classOf[IterationFault])
  override def getNext(iteratorId: Int, howMany: Int): util.List[NsnAlarm] = {
    AlarmOperationService.getInstance().getNext(iteratorId, howMany)
  }
}
