package yang

import akka.actor.Actor
import akka.actor.Actor.Receive
import akka.event.Logging

/**
  * Created by y28yang on 1/28/2016.
  */
class MyActor extends Actor {
  val log = Logging(context.system, this)

  override def receive = {
    case input:String => log.info(s"receive $input")
    case _ => log.info("receive unknow messsage")
  }
}
