package yang.alarm

import akka.actor.{ActorLogging, ActorRef, Actor}
import akka.actor.Actor.Receive
import com.nsn.oss.nbi.fm.operation.interfaces.{Filter, UserInfo}
import yang.Protocol.AlarmOptPtl._
import yang.iterator.IteratorProtocol.request_create_iterator_ior

/**
  * Created by y28yang on 2/16/2016.
  */
class GetAlarmListFromFmActor(fmService:AlarmFmServiceInterface,
                              iteratorIorService:ActorRef,
                              pullerFromFm:ActorRef) extends Actor with ActorLogging{
  override def receive: Receive = {
    case request_get_alarm_list_combined(concateFilter,resultBaseObject)=>{
      //val filters=new java.util.ArrayList[Filter]
      val filters=null
      val userInfo = new UserInfo;
      userInfo.setFilterId(0:Short)
      this.log.info("try to get all alarm from fm")
      val iteratorId=  fmService.getAllAlarm(filters,userInfo)
      this.log.info(s"get iteratorId $Iterator")
      iteratorIorService forward  request_create_iterator_ior
      pullerFromFm ! request_poll_alarm_list_from_fm(iteratorId)
    }
  }
}


