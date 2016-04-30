package com.lightreporter.Registration

import akka.actor.SupervisorStrategy.Resume
import akka.actor._
import com.lightreporter.Registration.UserProtocol._


/**
  * Created by y28yang on 3/29/2016.
  */
class BroadCaster[T<:AnyRef](val notifier: Option[UserChangedNotifiable]) extends Actor with ActorLogging {


  private var allUser = Map[String,ActorRef]()

  def getAllUser = allUser


  override def receive = {
    case regiMsg:Register[T] => register(regiMsg)
    case UnRegister(user) => unRegister(user)
    case RequestAllUser => replyWithUserInfos
    case msg:Msg[T] => allUser.foreach(_._2 forward msg)
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case _: Exception => Resume
  }

  def replyWithUserInfos: Unit = {
    val list = allUser.keys.toList
    log.info("current users:"+list.mkString(","))
    sender() ! ReplyAllUser(list)
  }

  def register(register:Register[T]): Unit = {
    val userName=register.userName

    if (allUser.contains(userName)) {
      sender() ! Status.Failure(OperationFailed(s"attach failed due to $userName already attached"))
    } else {
      try {
        val receiver=register.receiver
        val userActorRef = context.actorOf(Props(new BroadCastToReceiver(receiver)), userName)
        allUser += (userName ->userActorRef)
        notifyUserChanged()
        log.info(s"attach $userName successful")
        sender() ! OperationSuccss(userName)
      } catch {
        case e: Exception =>
          sender() ! Status.Failure(e)
      }
    }
  }

  def unRegister(userName: String): Unit = {
    if (allUser.contains(userName)) {
      val userActorRef = allUser.get(userName).get
      context.stop(userActorRef)
      allUser -= userName
      notifyUserChanged()
      sender() ! OperationSuccss(userName)
    } else {
      sender() ! Status.Failure(OperationFailed(s"detach failed due to no $userName attached"))
    }
  }

  def notifyUserChanged() {
    if(notifier.isDefined)
       notifier.get.userChanged(allUser.keys)
  }

}
