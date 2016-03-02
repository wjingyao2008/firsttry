package yang.iterator

import akka.actor.Props
import akka.testkit.TestActorRef
import org.omg.PortableServer.Servant
import org.scalatest.FunSuite
import yang.Protocol.AlarmOptPtl.reply_get_alarm_list

import yang.TestKitAndFunSuite
import yang.alarm.CorbaObjInitiator
import yang.iterator.IteratorActorTest.DonothingPoller
import yang.iterator.IteratorProtocol.{request_iterator_manager_to_destroy, request_create_iterator_ior}

/**
  * Created by y28yang on 3/2/2016.
  */
class IteratorManagerTest extends TestKitAndFunSuite {

  test("testCreateNewIterator") {
    val mockCorbaObj=new MockCorbaObjManager
    val mockDataPoll=new DonothingPoller
    val iteratorMgrActorRef:TestActorRef[IteratorManager] = TestActorRef(Props(new IteratorManager(mockCorbaObj,mockDataPoll)))
    iteratorMgrActorRef.tell(request_create_iterator_ior,testActor)

    val message=expectMsgClass(classOf[reply_get_alarm_list])
    message.iterator.destroy()
    val underMgr=iteratorMgrActorRef.underlyingActor
    Thread.sleep(1000)
    underMgr.iteratorMap.size shouldBe 0

  }

  test("test for iterator timeout") {
    val mockCorbaObj=new MockCorbaObjManager
    val mockDataPoll=new DonothingPoller
    val iteratorMgrActorRef:TestActorRef[IteratorManager] = TestActorRef(Props(new IteratorManager(mockCorbaObj,
      mockDataPoll,"timeoutedIterator",100,100)))
    iteratorMgrActorRef.tell(request_create_iterator_ior,testActor)
    iteratorMgrActorRef.tell(request_create_iterator_ior,testActor)
    iteratorMgrActorRef.tell(request_create_iterator_ior,testActor)
    iteratorMgrActorRef.tell(request_create_iterator_ior,testActor)
    Thread.sleep(1000)


    val underMgr=iteratorMgrActorRef.underlyingActor
    Thread.sleep(1000)
    underMgr.iteratorMap.size shouldBe 0
  }

  class MockCorbaObjManager extends CorbaObjInitiator{
    override def active(toActive: Servant): Unit = {}

    override def deActive(toDeactive: Servant): Unit = {}
  }
}
