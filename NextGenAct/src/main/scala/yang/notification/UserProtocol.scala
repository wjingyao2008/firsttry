package yang.notification

/**
  * Created by y28yang on 3/29/2016.
  */
object UserProtocol {

  case class User(userName: String, otherInfo: Option[AnyRef])

  case class Attach(user: User)

  case class OperationSuccss(userName: String)

  case class Detach(user: User)

  case class Msg(any: AnyRef)

  final case class OperationFailed(msg: String) extends RuntimeException(msg)

  case object RequestAllUser

}
