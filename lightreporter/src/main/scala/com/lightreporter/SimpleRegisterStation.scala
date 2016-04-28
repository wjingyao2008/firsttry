package com.lightreporter

import com.lightreporter.RegisterMsg.RegisterInfo

/**
  * Created by y28yang on 4/27/2016.
  */
class SimpleRegisterStation extends RegisterStation {

  var userMap = Map[String, Receiver]()


  @throws(classOf[AlreadyRegisteredException])
  override def register(registerInfo: RegisterInfo): Unit = {
    val user = registerInfo.user
    if (userMap.contains(user))
      throw new AlreadyRegisteredException(s"use $user already registered.")
    else {
      userMap += user -> registerInfo.receiver
      registerInfo.receiver.start()
    }
  }

  override def unregister(user: String): Unit = {
    val option=userMap.get(user)
    if(option.isDefined){
      option.get.stop()
      userMap-=user
    }

  }
}
