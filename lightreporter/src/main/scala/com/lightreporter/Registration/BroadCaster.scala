package com.lightreporter.Registration

import akka.actor.SupervisorStrategy.Resume
import akka.actor._
import akka.stream.scaladsl._
import akka.stream.{ActorMaterializer, OverflowStrategy}
import com.lightreporter.Registration.UserProtocol._

/**
  * Created by y28yang on 3/29/2016.
  */
class BroadCaster[T](notifierActor: Option[ActorRef]) extends Actor with ActorLogging {


  case class RegisterInfo[T](register: Register[T], source:ActorRef)

  private var allUser = Map[String, RegisterInfo[T]]()
  private implicit val mat = ActorMaterializer()

  def getAllUser = allUser



  override def receive = {
    case msg: Msg[T] => allUser.foreach(_._2.source ! msg.msg)
    case msgs: MsgList[T]=> allUser.foreach(seq=>{msgs.msgIterable.foreach(seq._2.source ! _)})
    case regiMsg: Register[T] => register(regiMsg)
    case UnRegister(user) => unRegister(user)
    case RequestAllUser => replyWithUserInfos()
    case changeFilter:ChangeFilter[T]=> changeUserFilter(changeFilter)
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case _: Exception => Resume
  }


  def changeUserFilter(changeFilter: ChangeFilter[T]): Unit = {
    val userName=changeFilter.userName
    if (allUser.contains(userName)) {
      allUser.get(userName).get.register.filterWarpper.filter=changeFilter.filter
      sender() ! OperationSuccess(userName)
    } else {
      sender() ! Status.Failure(new IllegalArgumentException(s"change filter failed due to no $userName attached"))
    }
  }

  def replyWithUserInfos(): Unit = {
    val list = allUser.keys.toList
    log.info("current users:" + list.mkString(","))
    sender() ! ReplyAllUser(list)
  }

  def register(register: Register[T]): Unit = {
    val userName = register.userName
    if (allUser.contains(userName))
    sender() ! Status.Failure(new IllegalArgumentException(s"attach failed due to $userName already attached"))
    else
    registerTopic(register)
  }

  def registerTopic(register: Register[T]): Unit = {
    try {
      val receiver = register.receiver
      receiver.start()
      val userName = register.userName
      val source = Source.actorRef[T](register.bufferSize, OverflowStrategy.dropHead)
      val filterWrapper=register.filterWarpper
      val flowOps=source.filter(it=>{filterWrapper.filter.isPass(it)}).map(receiver.receive(_))

      val completeEnd = Sink.onComplete { case _ => receiver.stop() }
      var sourceRef = flowOps.to(completeEnd).run()
      allUser += (userName -> RegisterInfo(register,sourceRef))

      notifyUserChanged()
      sender() ! OperationSuccess(userName)
    } catch {
      case e: Exception => sender() ! Status.Failure(e)
    }
  }

  def unRegister(userName: String): Unit = {
    if (allUser.contains(userName)) {
      val userActorRef = allUser.get(userName).get.source
      userActorRef ! akka.actor.PoisonPill
      allUser -= userName

      notifyUserChanged()
      sender() ! OperationSuccess(userName)
    } else {
      sender() ! Status.Failure(new IllegalArgumentException(s"detach failed due to no $userName attached"))
    }
  }

  def notifyUserChanged() {
    notifierActor.foreach(_ ! UserChanged(allUser.keys))
  }
}
