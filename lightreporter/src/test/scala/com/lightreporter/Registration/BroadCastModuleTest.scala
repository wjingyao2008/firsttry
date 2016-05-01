package com.lightreporter.Registration

import akka.actor.ActorSystem
import akka.testkit.TestKit
import com.lightreporter.Registration.UserProtocol.{Msg, OperationSuccss}
import org.scalatest.{BeforeAndAfter, FunSuiteLike, Matchers}

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModuleTest extends TestKit(ActorSystem("TestKitUsageSpec"))
  with FunSuiteLike
  with Matchers with BeforeAndAfter{



  test("testInit") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.init()
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
  }

  test("test duplicate register") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("br1").init()
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    intercept[IllegalArgumentException]{
      broadCastModule.register("123", receiver)
    }
  }

  test("test register and unregister") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("br3").init()
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    broadCastModule.register("124", receiver) shouldBe OperationSuccss("124")
    broadCastModule.requestAllUser() should be (Array("123","124"))
    broadCastModule.unRegister("123") shouldBe OperationSuccss("123")
    broadCastModule.requestAllUser() should be (Array[String]("124"))

    val path=broadCastModule.getBroadCastPath()
    val actorRef=system.actorSelection(path)
    actorRef ! Msg[String](List("testMsg"))
  }

  test("test register send msg") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("br3").init()
    val receiver = new ActorReciver(this.testActor)
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    val path=broadCastModule.getBroadCastPath()
    val actorRef=system.actorSelection(path)
    actorRef ! Msg[String](List("testMsg1","testMsg2"))

    expectMsg("testMsg1")
    expectMsg("testMsg2")
  }


  override protected def after(fun: => Any): Unit = {
    super.after(fun)
    system.terminate()
  }
}
