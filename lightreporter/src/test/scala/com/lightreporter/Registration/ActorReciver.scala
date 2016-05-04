package com.lightreporter.Registration

import akka.actor.ActorRef


/**
  * Created by Administrator on 2016/5/1 0001.
  */
class ActorReciver(testRef: ActorRef) extends StringReciver{


  override def receive(msg: String): Unit = {
    testRef ! msg
  }
}
