package com.lightreporter

import com.lightreporter.RegisterMsg.RegisterInfo

/**
  * Created by y28yang on 4/27/2016.
  */
trait RegisterStation {

  @throws(classOf[AlreadyRegisteredException])
  def register(registerInfo:RegisterInfo)

  def unregister(user:String)

}

object RegisterMsg {

  case class RegisterInfo(user:String, receiver:Receiver)

  case class RegisterList(users:List[RegisterInfo])

}