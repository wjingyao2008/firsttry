package com.lightreporter.Registration

import akka.actor.ActorSystem
import akka.testkit.TestKit
import com.lightreporter.Registration.UserProtocol.OperationSuccss
import org.scalatest.{FunSuiteLike, Matchers}

/**
  * Created by Administrator on 2016/4/30 0030.
  */
class BroadCastModuleTest extends TestKit(ActorSystem("TestKitUsageSpec"))
  with FunSuiteLike
  with Matchers {
  //  implicit val system = ActorSystem("testsystem")
  val broadCastModule = new BroadCastModule[String](system)
  broadCastModule.init()
  test("testInit") {
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
  }

  test("test duplicate register") {
    val receiver = new StringReciver("-")
    broadCastModule.register("123", receiver) shouldBe OperationSuccss("123")
    try {
      broadCastModule.register("123", receiver)
    } catch {
      case ex:Exception => println(s"================= $ex")
    }
  }

}
