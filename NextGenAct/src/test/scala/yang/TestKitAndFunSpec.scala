package yang

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest._

/**
  * Created by y28yang on 1/30/2016.
  */
class TestKitAndFunSpec extends TestKit(ActorSystem("testSystem"))
with FunSpecLike
with Matchers
with BeforeAndAfterAll
{
  //when mixin,then this will shutdown all
  this:TestKit with  Suite =>
  override protected def afterAll(): Unit ={
    super.afterAll()
    println("shutdown correctly")
    system.shutdown()
  }
}


class TestKitAndFlatSpec(actorSystem: ActorSystem) extends TestKit(_system = actorSystem)
  with FlatSpecLike
  with Matchers
  with ImplicitSender
  with BeforeAndAfterAll
{

 // def this()=>this(ActorSystem("FaultHandlingDocSpec"))
  //when mixin,then this will shutdown all
 // this:TestKit with  Suite =>
  override protected def afterAll(): Unit ={
    super.afterAll()
    println("shutdown correctly")
    system.shutdown()
  }



  def this(logLevel: String)=this(ActorSystem("testSystem",
    ConfigFactory.parseString(
      s"""
      akka {
        loggers = ["akka.testkit.TestEventListener"]
        loglevel = "$logLevel"
                                actor {
                                   debug {
                                      receive = on
                                      autoreceive = on
                                      lifecycle = on
                                    }
                                  }
      }
      """)))

  def this()=this("INFO")

}
