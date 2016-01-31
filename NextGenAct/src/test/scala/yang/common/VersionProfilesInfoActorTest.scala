package yang.common

import akka.actor.Props
import akka.actor.Status.Success
import akka.util.Timeout
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method
import com.nsn.oss.nbi.{Operation, IRPInfo, IRPInfoServiceInstance}
import org.mockito.Mockito
import org.scalatest.FunSuite
import yang.Protocol.AlarmOptPtl.get_alarm_IRP_operations_profile_msg
import yang.TestKitAndFunSpec
import org.mockito.Mockito._
import scala.concurrent.duration._
import akka.pattern.ask


/**
  * Created by y28yang on 1/31/2016.
  */
class VersionProfilesInfoActorTest extends TestKitAndFunSpec {

  describe("when receive getOperationProfile") {
    it("should return array[Mehod]") {
      val infoservice = Mockito.mock(classOf[IRPInfoServiceInstance])
      val irpinfo = new IRPInfo("id", "idInNs")
      val operation = new Operation("get_version")
      operation.getParameters.add("p1")
      val operation2 = new Operation("get_profile")
      operation2.getParameters.add("p2");
      operation2.getParameters.add("p3");

      irpinfo.getVersions.add("v3")
      irpinfo.getOperations.add(operation)
      irpinfo.getOperations.add(operation2)



      when(infoservice.getIRPInfoById("AlarmIRP")).thenReturn(irpinfo)

      implicit val timeout = Timeout(5 seconds)
      val versionProfileInfoActor = system.actorOf(Props(new VersionProfilesInfoActor(infoservice)))
      versionProfileInfoActor.tell(get_alarm_IRP_operations_profile_msg("v3"), testActor)
      expectMsgPF() {
        case retArray: Array[Method] => {
          retArray.size should be(2)
          retArray(0).name should be("get_version")
          retArray(0).parameter_list.size should be(1)
          retArray(0).parameter_list should be(Array("p1"))
          retArray(1).name shouldBe "get_profile"
          retArray(1).parameter_list shouldBe (Array("p2", "p3"))
        }
        case _ => {
          fail()
        }
      }
    }
  }

}
