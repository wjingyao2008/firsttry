package com.lightreporter.Registration

/**
  * Created by y28yang on 3/29/2016.
  */
object UserProtocol {



  case class Register[T](userName: String, receiver: Receiver[T], bufferSize:Int, filterWarpper:FilterWrapper[T])
  case class ChangeFilter[T](userName: String, filter: Filter[T])
  case class UnRegister(user: String)
  case class OperationSuccess(userName: String)

  case class Msg[T](msg:T)
  case class MsgList[T](msgIterable:Iterable[T])

  case object RequestAllUser
  case class  ReplyAllUser(users:Iterable[String])
  case class  UserChanged(users:Iterable[String])


}
