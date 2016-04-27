package yang.corba.notification

import akka.actor.Props
import yang.corba.notification.NotificationCorbaProtocol.AttachInfo
import yang.notification.UserActorCreator
import yang.notification.UserProtocol.{OperationFailed, User}

/**
  * Created by y28yang on 3/30/2016.
  */
class NotificationSenderCreator extends UserActorCreator {

  override def props(user: User): Props = {
    user match {
      case User(userName, Some(attachInfo: AttachInfo)) => createCorbaProps(userName, attachInfo)

      case other: AnyRef => throw new OperationFailed(s"can not create children notification sender due to illegalArgument:$other")

    }
  }


  def createCorbaProps(userName: String, attachInfo: AttachInfo) = {
    Props(new NotificationSender(userName, attachInfo))
  }


}
