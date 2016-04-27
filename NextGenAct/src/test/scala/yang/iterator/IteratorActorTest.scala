package yang.iterator

import akka.actor.{ActorRef, Props}
import akka.testkit.TestActorRef
import yang.TestKitAndFunSuite
import yang.iterator.IteratorActorTest.DonothingPoller
import yang.iterator.IteratorProtocol._

object IteratorActorTest {

  class DonothingPoller extends DataPoller {
    override def startPoll(iteratorRef: ActorRef, iteratorId: Int): Boolean = {
      false
    }
  }

}

/**
  * Created by y28yang on 3/1/2016.
  */
class IteratorActorTest extends TestKitAndFunSuite {

  val hasNext = true
  val hasNoNext = false

  test("test auto poll") {
    val dataPoller = new mockDataPoller(testActor)

    val iteratorActorRef = system.actorOf(Props(new IteratorActor[AnyRef](dataPoller, testActor, 1)), "1")
    Thread.sleep(500)
    dataPoller.pollCount shouldBe 4
  }

  test("actor test for take more than it has") {
    val dataPoller = new DonothingPoller

    val iteratorActorRef: TestActorRef[IteratorActor[Object]] = TestActorRef(Props(new IteratorActor[Object](dataPoller, testActor, 1)))
    val underlying = iteratorActorRef.underlyingActor
    underlying.hasMoreDataToTaken shouldBe true
    iteratorActorRef ! request_next_date(3)
    expectMsgPF() {
      case RespondNextDate(hasMoreNext, eventArray) =>
        hasMoreNext shouldBe true
        eventArray.size shouldBe 0

      case any => fail(any.toString)

    }
    val s1 = new AnyRef

    iteratorActorRef ! appended_flexmapped_data(hasNoNext, Array(s1))
    iteratorActorRef ! request_next_date(3)
    expectMsgPF() {
      case RespondNextDate(hasMoreNext, eventArray) =>
        hasMoreNext shouldBe false
        eventArray.size shouldBe 1
        val iterator = eventArray.iterator
        iterator.hasNext shouldBe true
        iterator.next() shouldBe s1

      case any => fail(any.toString)

    }

  }


  test("test for get next") {
    val dataPoller2 = new DonothingPoller
    val iteratorActorRef = system.actorOf(Props(new IteratorActor[AnyRef](dataPoller2, testActor, 0)))
    val s1 = new AnyRef()
    val s2 = new AnyRef()
    val s3 = new AnyRef()
    val hasNext = true
    val hasNoNext = false
    iteratorActorRef ! appended_flexmapped_data(hasNext, Array(s1))
    iteratorActorRef ! appended_flexmapped_data(hasNext, Array(s2))
    iteratorActorRef ! appended_flexmapped_data(hasNoNext, Array(s3))
    expect(iteratorActorRef, s1, hasNext)
    expect(iteratorActorRef, s2, hasNext)
    expect(iteratorActorRef, s3, hasNoNext)
  }

  test("test for get next in turn") {
    val dataPoller2 = new DonothingPoller
    val iteratorActorRef = system.actorOf(Props(new IteratorActor[AnyRef](dataPoller2, testActor, 1)))
    val s1 = new AnyRef()
    val s2 = new AnyRef()
    val s3 = new AnyRef()
    val s4 = new AnyRef()

    iteratorActorRef ! appended_flexmapped_data(hasNext, Array(s1))
    expect(iteratorActorRef, s1, hasNext)
    iteratorActorRef ! appended_flexmapped_data(hasNext, Array(s2))
    iteratorActorRef ! appended_flexmapped_data(hasNext, Array(s3))

    expect(iteratorActorRef, s2, hasNext)
    expect(iteratorActorRef, s3, hasNext)
    iteratorActorRef ! appended_flexmapped_data(hasNoNext, Array(s4))
    expect(iteratorActorRef, s4, hasNoNext)
  }


  def expect(iteratorActorRef: ActorRef, event: AnyRef, expectHasNext: Boolean) {
    iteratorActorRef ! request_next_date(1)
    expectMsgPF() {
      case RespondNextDate(hasMoreNext, eventArray) =>
        hasMoreNext shouldBe expectHasNext
        val iterator = eventArray.iterator
        iterator.hasNext shouldBe true
        iterator.next shouldBe event
        println("assert ok")

      case msg: Any => fail(msg.toString)


    }
  }

  class mockDataPoller(testRef: ActorRef) extends DataPoller {
    val events = new scala.collection.mutable.Queue[AnyRef]()
    val s1 = new AnyRef()
    val s2 = new AnyRef()
    val s3 = new AnyRef()

    events += s1
    events += s2
    events += s3
    @volatile
    var pollCount = 0
    println(events.mkString(","))

    override def startPoll(iteratorRef: ActorRef, iteratorId: Int): Boolean = {
      println(s"poll $pollCount,event size: ${events.size}")
      pollCount += 1
      val hasNext = events.nonEmpty
      if (hasNext) events.dequeue
      hasNext
    }
  }

}

