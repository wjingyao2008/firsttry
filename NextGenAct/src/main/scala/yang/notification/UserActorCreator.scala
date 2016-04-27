package yang.notification

import akka.actor.Props
import yang.notification.UserProtocol.User

/**
  * Created by y28yang on 3/29/2016.
  */
trait UserActorCreator {
  //  def props(user:User): Props = Props(new DemoActor(magicNumber))
  def props(user: User): Props
}
