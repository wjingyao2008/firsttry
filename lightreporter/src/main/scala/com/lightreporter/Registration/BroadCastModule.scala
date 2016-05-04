package com.lightreporter.Registration

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.lightreporter.Filter.Filter
import com.lightreporter.Registration.UserProtocol._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModule[T <: AnyRef](system: ActorSystem) {

  private var broadCaster: ActorRef = null
  private var notifiable: Option[ActorRef] = None
  private var broadCasterName = "BroadCast"
  @volatile
  private var isInited = false
  @volatile
  private var bufferSize = 500
  private implicit var timeout: Timeout = Timeout(5 seconds)



  def init() = {
    mustBeforeInit()
    broadCaster=system.actorOf(Props.create(classOf[BroadCaster[T]], notifiable), broadCasterName)
    isInited = true
  }


  def setReplyTimeOutSecs(tick: Int) = {
    timeout = Timeout(tick seconds)
    this
  }

  def setModuleName(moduleName: String) = {
    mustBeforeInit()
    this.broadCasterName = moduleName
    this
  }

  def getBroadCastRef={
    mustAfterInit()
    this.broadCaster
  }

  def getBroadCastPath={
    getBroadCastRef.path.toString
  }

  def sendMsg(msg:T)={
    broadCaster ! Msg(msg)
  }

  def sendMsgList(iteratorMsg:Iterable[T])={
    broadCaster ! MsgList(iteratorMsg)
  }


  def setNotifiable(userChangedNotifiable:ActorRef) = {
    mustBeforeInit()
    this.notifiable = Some(userChangedNotifiable)
    this
  }

  def setBroadCastBuffer(bufferSize:Int) ={
    this.bufferSize=bufferSize
    this
  }


  def register(userName: String, receiver: Receiver[T],optionalFilter:FilterWrapper[T]=new FilterWrapper[T]) = {
    val registerMsg=Register(userName, receiver,bufferSize,optionalFilter)
    askBroadCaster[OperationSuccess](registerMsg)
  }

  def changeFilter(userName: String,filter: Filter[T]) ={
    val changeFilter=ChangeFilter(userName,filter)
    askBroadCaster[OperationSuccess](changeFilter)
  }

  def unRegister(userName: String) = {
    val unRegisterMsg = UnRegister(userName)
    askBroadCaster[OperationSuccess](unRegisterMsg)
  }

  def requestAllUser():Iterable[String] = {
    askBroadCaster[ReplyAllUser](RequestAllUser).users
  }

  private def askBroadCaster[U](msgToBroadCaster:AnyRef): U = {
      mustAfterInit()
      val futureResult = broadCaster ? msgToBroadCaster
      Await.result(futureResult, timeout.duration).asInstanceOf[U]
  }


  private def mustBeforeInit() = if (isInited) throw new UnsupportedOperationException("error,must invoke before init() method")

  private def mustAfterInit() = if (!isInited) throw new UnsupportedOperationException("error,must invoke after init() method")
}
