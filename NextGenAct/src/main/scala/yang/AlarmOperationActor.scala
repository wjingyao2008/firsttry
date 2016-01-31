package yang

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive
import yang.AlarmOperationPotocol._
/**
  * Created by y28yang on 1/30/2016.
  */
class AlarmOperationActor(licenseChecker:ActorRef) extends Actor{

  override def receive = {
    case GetAlarmIrpVersions =>{
       // licenseChecker forward GetAlarmIrpVersions
      sender ! Array("123")
      licenseChecker ! GetAlarmIrpVersions
    }
    case _=> ???
  }
}
