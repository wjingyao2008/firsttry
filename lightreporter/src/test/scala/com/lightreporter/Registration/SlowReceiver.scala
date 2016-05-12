package com.lightreporter.registration

import java.util.Date
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.{Condition, Lock, ReentrantLock}

import akka.actor.ActorRef

/**
  * Created by y28yang on 5/4/2016.
  */
class SlowReceiver(testRef: ActorRef,val lock:Lock=new ReentrantLock) extends StringReceiver{

  override def receive(msg: String): Unit = {
    Thread.sleep(100)
    println(s"get: $msg,at:"+System.currentTimeMillis())
    testRef ! msg
  }
}