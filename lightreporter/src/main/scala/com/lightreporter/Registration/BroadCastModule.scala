package com.lightreporter.Registration

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.lightreporter.Registration.UserProtocol._

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModule[T <: AnyRef](val system: ActorSystem) {
  private var broadCaster: ActorRef = null
  private var notifiable: Option[UserChangedNotifiable] = None
  private var broadCasterName = "BroadCast"
  private var isInited = false
  private implicit var timeout: Timeout = Timeout(5 seconds)
  implicit val ec = system.dispatcher
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

  def setNotifiable(userChangedNotifiable: UserChangedNotifiable) = {
    mustBeforeInit()
    this.notifiable = Some(userChangedNotifiable)
    this
  }


  //  def addSource(receiver: Source[T])={
  //
  //  }

  def register(userName: String, receiver: Receiver[T]) = {
    mustAfterInit()

    try {
      val futureResult = broadCaster ? Register(userName, receiver)
      val result = Await.result(futureResult, timeout.duration).asInstanceOf[OperationSuccss]
      println(result)
      result
    } catch {
      case ex:Exception =>throw ex
    }
  }

  def unRegister(userName: String, receiver: Receiver[T]) = {
    mustAfterInit()
    val futureResult = broadCaster ? UnRegister(userName)
    futureResult.value.get match {
      case Success(OperationSuccss(userName)) =>
      case Success(unknown) =>throw new IllegalArgumentException(s"return value unknown: $unknown")
      case Failure(e)=> println("sdsfsfdfdff==========");throw e

    }
  }

  def requestAllUser():List[String] = {
    mustAfterInit()
    val futureResult = broadCaster ? RequestAllUser
    val value=futureResult.value.get match {
      case Success(reply:ReplyAllUser) =>reply.users
      case Success(unknown) =>throw new IllegalArgumentException(s"return value unknown: $unknown")
      case Failure(e)=> throw e
    }
    value
  }


  private def mustBeforeInit() = if (isInited) throw new UnsupportedOperationException("error,must invoke before init() method")

  private def mustAfterInit() = if (!isInited) throw new UnsupportedOperationException("error,must invoke after init() method")
}
