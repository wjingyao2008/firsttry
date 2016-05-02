package com.lightreporter.Registration

import akka.actor.SupervisorStrategy.Resume
import akka.actor._
import akka.stream.scaladsl._
import akka.stream.{ActorMaterializer, OverflowStrategy}
import com.lightreporter.Registration.UserProtocol._

/**
  * Created by y28yang on 3/29/2016.
  */
class BroadCaster[T <: AnyRef](notifierActor:Option[ActorRef]) extends Actor with ActorLogging {


  private var allUser = Map[String, ActorRef]()
  private implicit val mat = ActorMaterializer()

  def getAllUser = allUser


  override def receive = {
    case msg: Msg[T] => allUser.foreach(_._2 ! msg)
    case regiMsg: Register[T] => register(regiMsg)
    case UnRegister(user) => unRegister(user)
    case RequestAllUser => replyWithUserInfos()
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case _: Exception => Resume
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
      regeisteTopic(register)
  }

  def regeisteTopic(register: Register[T]): Unit = {
    try {
      val receiver = register.receiver
      receiver.start()
      val userName = register.userName
      val source = Source.actorRef[Msg[T]](register.bufferSize, OverflowStrategy.dropHead)
      val flow = source.map(it => receiver.receive(it.arrays)).to(Sink.onComplete { case _ => receiver.stop() }).run()
      allUser += (userName -> flow)
      notifyUserChanged()
      sender() ! OperationSuccss(userName)
    } catch {
      case e: Exception => sender() ! Status.Failure(e)
    }
  }

  def unRegister(userName: String): Unit = {
    if (allUser.contains(userName)) {
      val userActorRef = allUser.get(userName).get
      userActorRef ! akka.actor.PoisonPill
      allUser -= userName

      notifyUserChanged()
      sender() ! OperationSuccss(userName)
    } else {
      sender() ! Status.Failure(new IllegalArgumentException(s"detach failed due to no $userName attached"))
    }
  }

  def notifyUserChanged() {
    notifierActor.foreach(_ ! UserChanged(allUser.keys))
  }

}
