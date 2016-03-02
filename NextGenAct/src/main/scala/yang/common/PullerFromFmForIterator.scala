package yang.common

import akka.actor.{ActorLogging, Actor}
import akka.actor.Actor.Receive
import yang.Protocol.AlarmOptPtl.request_poll_alarm_list_from_fm

/**
  * Created by y28yang on 2/16/2016.
  */
class PullerFromFmForIterator extends Actor with ActorLogging{



  override def receive: Receive = {
    case request_poll_alarm_list_from_fm(iteratorId)=>{
      log.info(s"poller received $iteratorId")

    }
  }
}
