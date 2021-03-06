package yang.alarm

import akka.actor.{Actor, ActorLogging, ActorRef}
import com.nsn.oss.nbi.fm.operation.interfaces.UserInfo
import yang.Protocol.AlarmOptPtl._
import yang.iterator.IteratorProtocol.RequestCreateIteratorIor

/**
  * Created by y28yang on 2/16/2016.
  */
class GetAlarmListFromFmActor(fmService: AlarmFmServiceInterface,
                              iteratorIorService: ActorRef) extends Actor with ActorLogging {
  override def receive: Receive = {
    case request_get_alarm_list_combined(concateFilter, resultBaseObject) =>
      val filters = null
      val userInfo = new UserInfo
      userInfo.setFilterId(0: Short)
      this.log.info("try to get all alarm from fm")
      val iteratorFmId = fmService.getAllAlarm(filters, userInfo)
      this.log.info(s"get iteratorId $Iterator")
      iteratorIorService forward RequestCreateIteratorIor(iteratorFmId)

  }
}


