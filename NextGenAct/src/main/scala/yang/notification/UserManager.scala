package yang.notification

import akka.actor.SupervisorStrategy.Resume
import akka.actor._
import yang.flexmapping.FlexProtocol.OutFlexMapPayLoad
import yang.notification.UserProtocol._


/**
  * Created by y28yang on 3/29/2016.
  */
class UserManager(val userCreator: UserActorCreator,
                  val notifier: UserChangedNotifiable) extends Actor with ActorLogging {


  override val supervisorStrategy = OneForOneStrategy() {

    case _: Exception => Resume

  }
  var allUser = Map[String, (User, ActorRef)]()

  def getAllUser = allUser

  def receive = {
    case Attach(user) =>
      val userName = user.userName

      if (allUser.contains(userName)) {
        sender() ! Status.Failure(OperationFailed(s"attach failed due to $userName already attached"))
      } else {
        try {
          val userActorRef = context.actorOf(userCreator.props(user), userName)
          allUser += (userName ->(user, userActorRef))
          notifyUserChanged()
          log.info(s"attach $userName successful")
          sender() ! OperationSuccss(userName)
        } catch {
          case e: Exception =>
            sender() ! Status.Failure(e)
        }
      }

    case Detach(user) =>
      val userName = user.userName
      if (allUser.contains(userName)) {
        val userActorRef = allUser.get(userName).get._2
        context.stop(userActorRef)
        allUser -= userName
        notifyUserChanged()
        sender() ! OperationSuccss(userName)
      } else {
        sender() ! Status.Failure(OperationFailed(s"detach failed due to no $userName attached"))
      }
    case RequestAllUser =>
      val list = allUser.keys.toList
      println(list)
      sender() ! list

    case msg:OutFlexMapPayLoad => allUser.foreach(_._2._2 forward msg)


  }

  def notifyUserChanged() {
    notifier.userChanged(allUser.keys)
  }

}
