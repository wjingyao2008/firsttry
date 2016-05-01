package com.lightreporter.Registration

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.lightreporter.Registration.UserProtocol._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModule[T <: AnyRef](system: ActorSystem) {

  private var broadCaster: ActorRef = null
  private var notifiable: Option[UserChangedNotifiable] = None
  private var broadCasterName = "BroadCast"
  @volatile
  private var isInited = false
  @volatile
  private var bufferSize = 1000
  private implicit var timeout: Timeout = Timeout(5 seconds)



  def init() = {
    mustBeforeInit()
    broadCaster=system.actorOf(Props.create(classOf[BroadCaster[T]], notifiable), broadCasterName)
    isInited = true
  }

  def setTimeOutSecs(tick: Int) = {
    timeout = Timeout(tick seconds)
    this
  }

  def setModuleName(moduleName: String) = {
    mustBeforeInit()
    this.broadCasterName = moduleName
    this
  }

  def getBroadCastPath()={
    mustAfterInit()
    this.broadCaster.path.toString
  }

  def setNotifiable(userChangedNotifiable: UserChangedNotifiable) = {
    mustBeforeInit()
    this.notifiable = Some(userChangedNotifiable)
    this
  }

  def setBroadCastBuffer(bufferSize:Int) ={
    this.bufferSize=bufferSize
    this
  }

  def register(userName: String, receiver: Receiver[T]) = {
    val registerMsg=Register(userName, receiver,bufferSize)
    askBroadCaster[OperationSuccss](registerMsg)
  }

  def unRegister(userName: String) = {
    val unRegisterMsg = UnRegister(userName)
    askBroadCaster[OperationSuccss](unRegisterMsg)
  }

  def requestAllUser():List[String] = {
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
