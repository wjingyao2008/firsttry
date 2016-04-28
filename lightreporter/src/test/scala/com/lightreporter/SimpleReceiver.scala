package com.lightreporter

/**
  * Created by y28yang on 4/27/2016.
  */
class SimpleReceiver extends Receiver{

  var isStarted=false
  var isStop=false
  var received=""


  override def receive: Receive = {
    case msg:String=>received=msg
  }

  override def stop(): Unit = {
    isStop=true
    isStarted=false
  }

  override def start(): Unit = {
    isStarted = true
    isStop=false
  }

}
