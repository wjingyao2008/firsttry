package com.lightreporter.Registration

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class StringReciver(var recivStr:String) extends Receiver[String]{


  override def receive(msg: Iterable[String]): Unit = {
    recivStr=msg.head
  }

  override def stop(): Unit = {}

  override def start(): Unit = {}
}