package com.lightreporter.Registration

import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import com.lightreporter.Registration.UserProtocol.{Msg, OperationSuccss}
import org.scalatest.{BeforeAndAfter, FunSuiteLike, Matchers}
import org.scalatest.concurrent.Eventually._
import org.scalatest.time.Span

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModuleTest extends TestKit(ActorSystem("TestKitUsageSpec"))
  with FunSuiteLike
  with Matchers with BeforeAndAfter{



  test("test init and then register successful") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.init()
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
  }

  test("test duplicate register") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("broadcastDuplicateReg").init()
    val receiver = new StringReciver
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    intercept[IllegalArgumentException]{
      broadCastModule.register("123", receiver)
    }
  }

  test("test when register,the receive interface will correctly been start and stop") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("correct_start_stop").init()
    val receiver = new StringReciver
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    receiver.isStart shouldBe true
    broadCastModule.unRegister("123") shouldBe OperationSuccss("123")

    eventually{receiver.isStop shouldBe true}
  }


  test("test register and unregister") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("broadCastRegAndUnReg").init()
    val receiver = new StringReciver
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    broadCastModule.register("124", receiver) shouldBe OperationSuccss("124")
    broadCastModule.requestAllUser() should be (Array("123","124"))
    broadCastModule.unRegister("123") shouldBe OperationSuccss("123")
    broadCastModule.requestAllUser() should be (Array[String]("124"))
    broadCastModule.unRegister("124") shouldBe OperationSuccss("124")
    broadCastModule.requestAllUser() should be (Array[String]())
  }

  test("register 2 recivers,send msg to broadcast,then expecting receive them") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("broadcastTo2User").init()
    val dest1= registerTo(broadCastModule,"user1")
    val dest2=registerTo(broadCastModule,"user2")
    val path=broadCastModule.getBroadCastPath()
    val actorRef=system.actorSelection(path)
    actorRef ! Msg[String](List("testMsg1","testMsg2"))

    dest1.expectMsg("testMsg1")
    dest1.expectMsg("testMsg2")
    dest2.expectMsg("testMsg1")
    dest2.expectMsg("testMsg2")
  }


  def registerTo(broadCastModule: BroadCastModule[String],userName: String): TestProbe = {
    val probe = TestProbe()
    val receiver = new ActorReciver(probe.ref)
    broadCastModule.register(userName, receiver) shouldBe OperationSuccss(userName)
    probe
  }

  override protected def after(fun: => Any): Unit = {
    super.after(fun)
    system.terminate()
  }
}
