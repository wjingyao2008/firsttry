package yang

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorRef, Props, ActorSystem}
import akka.testkit.TestActorRef
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions
import org.scalatest.{FunSuiteLike, FunSuite}
import scala.concurrent.duration._
/**
  * Created by y28yang on 1/30/2016.
  */
class AlarmOperationImplTest extends TestKitAndFunSpec {

  describe("testGet_alarm_IRP_versions") {
   it("should return correct"){
       val actorRef= system.actorOf(Props[AlarmOperationActor])
       val alarmOperationImpl=new AlarmOperationImpl(actorRef)

       val result=alarmOperationImpl.get_alarm_IRP_versions()
       result should be  (Array("123"))
     }

    it("should timeout when timeout"){
      val actorRef= system.actorOf(Props(new TimeOutActor(10000)))
      val alarmOperationImpl=new AlarmOperationImpl(actorRef)
       val thrown=intercept[GetAlarmIRPVersions]{
         alarmOperationImpl.get_alarm_IRP_versions()
       }
       thrown shouldBe a [GetAlarmIRPVersions]
    }
  }
  class TimeOutActor(timeOut:Long) extends Actor{
    override def receive = {
      case _ =>{ Thread.sleep(timeOut)
         AnyRef
      }
    }
  }
}
