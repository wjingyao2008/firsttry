package com.lightreporter.Registration

/**
  * Created by y28yang on 3/29/2016.
  */
object UserProtocol {



  case class Register[T<:AnyRef](userName: String, receiver: Receiver[T],bufferSize:Int)

  case class UnRegister(user: String)
  case class OperationSuccss(userName: String)

  case class Msg[T](arrays:Iterable[T])

  case object RequestAllUser
  case class  ReplyAllUser(users:Iterable[String])
  case class  UserChanged(users:Iterable[String])

}
