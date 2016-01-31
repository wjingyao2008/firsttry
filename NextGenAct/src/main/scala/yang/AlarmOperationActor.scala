package yang

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive
import yang.Protocol.AlarmOptPtl._

/**
  * Created by y28yang on 1/30/2016.
  */
class AlarmOperationActor(nextPipe:ActorRef) extends Actor{

  override def receive = {
    case `get_alarm_IRP_versions_msg` =>{
       // licenseChecker forward GetAlarmIrpVersions
      nextPipe forward  get_alarm_IRP_versions_msg
    }
    case msg:get_alarm_IRP_operations_profile_msg=>{
      nextPipe forward msg
    }
    case _=> ???
  }
}
