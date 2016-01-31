package yang

import akka.actor.ActorSystem
import akka.testkit.TestKit
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
    system.shutdown()
  }
}
