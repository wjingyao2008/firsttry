package com.lightreporter.registration

import akka.actor.ActorRef


/**
  * Created by Administrator on 2016/5/1 0001.
  */
class ActorReceiver(testRef: ActorRef) extends StringReceiver{


  override def receive(msg: String): Unit = {
    testRef ! msg
  }
}
