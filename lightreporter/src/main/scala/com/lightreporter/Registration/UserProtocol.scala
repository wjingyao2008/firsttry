package com.lightreporter.Registration

/**
  * Created by y28yang on 3/29/2016.
  */
object UserProtocol {



  case class Register[T<:AnyRef](userName: String, receiver: Receiver[T])

  case class UnRegister(user: String)
  case class OperationSuccss(userName: String)


  final case class OperationFailed(msg: String) extends RuntimeException(msg)

  case class Msg[T](arrays:List[T])

  case object RequestAllUser
  case class  ReplyAllUser(users:List[String])

}
