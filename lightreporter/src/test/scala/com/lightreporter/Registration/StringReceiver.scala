package com.lightreporter.registration

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class StringReceiver(var receivStr:String="-") extends Receiver[String]{

  var isStop=false
  var isStart=false
  override def receive(msg:String): Unit = {
    receivStr=msg
  }

  override def stop(): Unit = {isStop=true}

  override def start(): Unit = {isStart=true}
}
