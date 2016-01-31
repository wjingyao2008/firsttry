package yang

import java.util

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorRef, Props, ActorSystem}
import akka.testkit.TestActorRef
import com.nsn.oss.nbi.{IRPInfo, IRPInfoServiceInstance}
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions
import org.mockito.Mockito
import org.scalatest.{FunSuiteLike, FunSuite}
import org.mockito.Mockito._
import org.mockito.Mockito.mock
import org.mockito.Matchers._
import yang.common.VersionProfilesInfoActor

/**
  * Created by y28yang on 1/30/2016.
  */
class AlarmOperationImplTest extends TestKitAndFunSpec {

  describe("testGet_alarm_IRP_versions") {
   it("should return correct"){
       val infoservice=Mockito.mock(classOf[IRPInfoServiceInstance])
       val version=Array("123.0.1","32.111 V6.2")
       val versionSet=new util.HashSet[String]()
       versionSet.add("123.0.1");
       versionSet.add("32.111 V6.2")
       val info=mock(classOf[IRPInfo])

       when(infoservice.getIRPInfoById(any[String])).thenReturn(info)
       when(info.getVersions()).thenReturn(versionSet)
       val versionProfileInfoActor=system.actorOf(Props(new VersionProfilesInfoActor(infoservice)))
       val actorRef= system.actorOf(Props(new AlarmOperationActor(versionProfileInfoActor,null)))
       val alarmOperationImpl=new AlarmOperationImpl(actorRef)

       val result=alarmOperationImpl.get_alarm_IRP_versions()
       result should contain (version(0))
       result should contain (version(1))


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
