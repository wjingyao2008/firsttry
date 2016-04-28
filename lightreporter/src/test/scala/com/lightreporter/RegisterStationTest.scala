package com.lightreporter

import com.lightreporter.RegisterMsg.RegisterInfo
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

/**
  * Created by y28yang on 4/27/2016.
  */
class RegisterStationTest extends FunSuite with BeforeAndAfterEach with Matchers{

  var registerStation:RegisterStation=null
  var simpleReceiver:SimpleReceiver=null
  override def beforeEach() {
    registerStation=new SimpleRegisterStation
    simpleReceiver=new SimpleReceiver
  }

  test("test Register and unregister successfully") {
    registerStation.register(RegisterInfo("user1",simpleReceiver))
    simpleReceiver.isStarted shouldBe true
    registerStation.unregister("user1")
    simpleReceiver.isStop shouldBe true

  }

  test("test registered succeful and receive data") {

  }

}
