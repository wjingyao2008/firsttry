package com.lightreporter.Registration

import akka.actor.Actor
import com.lightreporter.Registration.UserProtocol.Msg

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastToReceiver[T<:AnyRef](receiver: Receiver[T]) extends Actor{


  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    receiver.start()
    super.preStart()
  }


  @scala.throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    super.postStop()
    receiver.stop()
  }

  override def receive: Receive = {
    case Msg(msgs:Iterable[T])=> receiver.receive(msgs)
  }
}
