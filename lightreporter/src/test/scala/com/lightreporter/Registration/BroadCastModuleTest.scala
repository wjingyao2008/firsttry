package com.lightreporter.registration

import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}
import akka.stream.{ActorMaterializer, OverflowStrategy}
import akka.testkit.{TestKit, TestProbe}
import com.lightreporter.registration.UserProtocol.OperationSuccess
import org.scalatest.concurrent.Eventually._
import org.scalatest.{BeforeAndAfter, FunSuiteLike, Matchers}

import scala.collection.mutable.ListBuffer
import scala.concurrent.duration._

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModuleTest extends TestKit(ActorSystem("TestKitUsageSpec"))
  with FunSuiteLike
  with Matchers with BeforeAndAfter {


  test("test init and then register successful") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.init()
    val receiver = new StringReceiver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccess("123")
  }

  test("test duplicate register,the second register will fail") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("broadcastDuplicateReg").init()
    val receiver = new StringReceiver
    broadCastModule.register("123", receiver) shouldBe OperationSuccess("123")
    intercept[IllegalArgumentException] {
      broadCastModule.register("123", receiver)
    }
  }

  test("test when register,the receive interface will correctly been start and stop") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("correct_start_stop").init()
    val receiver = new StringReceiver
    broadCastModule.register("123", receiver) shouldBe OperationSuccess("123")
    receiver.isStart shouldBe true
    broadCastModule.unRegister("123") shouldBe OperationSuccess("123")

    eventually {
      receiver.isStop shouldBe true
    }
  }


  test("test register and unregister") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("broadCastRegAndUnReg").init()
    val receiver = new StringReceiver
    broadCastModule.register("123", receiver) shouldBe OperationSuccess("123")
    broadCastModule.register("124", receiver) shouldBe OperationSuccess("124")
    broadCastModule.requestAllUser() should be(Array("123", "124"))
    broadCastModule.unRegister("123") shouldBe OperationSuccess("123")
    broadCastModule.requestAllUser() should be(Array[String]("124"))
    broadCastModule.unRegister("124") shouldBe OperationSuccess("124")
    broadCastModule.requestAllUser() should be(Array[String]())
  }

  test("register with two receivers,send msg to broadcast with two msg,then expecting receive them") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("t3").init()
    val dest1 = registerTo(broadCastModule, "user1")
    val dest2 = registerTo(broadCastModule, "user2")
    broadCastModule.sendMsg("testMsg1")
    broadCastModule.sendMsg("testMsg2")
    //    broadCastModule.sendMsg(Msg[String](List("testMsg1","testMsg2")))
    dest1.expectMsg("testMsg1")
    dest1.expectMsg("testMsg2")
    dest2.expectMsg("testMsg1")
    dest2.expectMsg("testMsg2")
  }

  test("register with two receivers,send msg to broadcast with iterable msg,then expecting receive them") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("t4").init()
    val dest1 = registerTo(broadCastModule, "user1")
    val dest2 = registerTo(broadCastModule, "user2")
    broadCastModule.sendMsgList(Array("testMsg1", "testMsg2"))
    dest1.expectMsg("testMsg1")
    dest1.expectMsg("testMsg2")
    dest2.expectMsg("testMsg1")
    dest2.expectMsg("testMsg2")
  }

  test("register with two receivers,set one user with filter,then expect one receive filtered data,one receive all") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("t5").init()
    val dest1 = registerTo(broadCastModule, "user1")
    val dest2 = registerTo(broadCastModule, "user2")
    broadCastModule.changeFilter("user1", new StringFilter("testMsg1"))
    broadCastModule.sendMsgList(Array("testMsg1", "testMsg2"))

    dest1.expectMsg("testMsg1")

    dest2.expectMsg("testMsg1")
    dest2.expectMsg("testMsg2")
  }

//  test("test for buffer size") {
//    implicit val mat = ActorMaterializer()
//    val source = Source.actorRef[String](5, OverflowStrategy.dropHead)
//    val sink = Sink.ignore
//    val ref = source.map(it => {
//      println(s"get: $it")
//      Thread.sleep(100)
//      println(it)
//      it
//    }).to(sink).run()
//    for (a <- 1 to 100) {
//      ref ! a.toString
//    }
//  }


  test("one receiver is slow,then expect slow receiver receive only 3 data when buffer overflow") {
    val broadCastModule = new BroadCastModule[String](system)
    broadCastModule.setModuleName("t6")
      .setBroadCastBuffer(3).init()
    val slowRegister = registerToSlowReceiver(broadCastModule, "user1")

    val slowReceiver = slowRegister._1
    val slowLock = slowRegister._2

    for (a <- 1 to 100)
      broadCastModule.sendMsg(a.toString)

    val duration = Duration(1, TimeUnit.SECONDS)

    val get=getList(slowReceiver, duration).size
    println(s"get size is :$get")
    get<100 shouldBe true
  }


  def getList(slowReceiver: TestProbe, duration: FiniteDuration): ListBuffer[AnyRef] = {
    var list=ListBuffer[AnyRef]()
    for (a <- 1 to 100) {
      val value = slowReceiver.receiveOne(duration)
      if (value != null) {
        list += value
      } else {
        return list
      }
    }
    list
  }

  def registerTo(broadCastModule: BroadCastModule[String], userName: String): TestProbe = {
    val probe = TestProbe()
    val receiver = new ActorReceiver(probe.ref)
    broadCastModule.register(userName, receiver) shouldBe OperationSuccess(userName)
    probe
  }

  def registerToSlowReceiver(broadCastModule: BroadCastModule[String], userName: String) = {
    val probe = TestProbe()
    val receiver = new SlowReceiver(probe.ref)
    broadCastModule.register(userName, receiver) shouldBe OperationSuccess(userName)
    (probe, receiver.lock)
  }


  override protected def after(fun: => Any): Unit = {
    super.after(fun)
    system.terminate()
  }
}
