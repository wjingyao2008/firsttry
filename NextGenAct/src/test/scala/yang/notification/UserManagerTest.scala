package yang.notification

import akka.actor.{Actor, ActorRef, Props}
import akka.pattern.ask
import akka.testkit.TestActorRef
import akka.util.Timeout
import org.mockito.Matchers._
import org.mockito.Mockito
import org.mockito.Mockito._
import org.scalatest.Matchers
import yang.TestKitAndFunSuite
import yang.flexmapping.FlexProtocol.OutFlexMapPayLoad
import yang.flexmapping.StructuredEventWarpper
import yang.notification.UserProtocol.{OperationFailed, _}

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by y28yang on 3/29/2016.
  */
class UserManagerTest extends TestKitAndFunSuite with Matchers {


  def createActor = {
    val userActorCreator = Mockito.mock(classOf[UserActorCreator])
    val props = Props(new ChildUserActor())
    when(userActorCreator.props(any(classOf[User]))).thenReturn(props)
    val stubUserChangedNotification=new StubUserChangedNotification
    val userManager = TestActorRef[UserManager](Props(new UserManager(userActorCreator,stubUserChangedNotification)))
    (userManager, userManager.underlyingActor,stubUserChangedNotification)
  }

  def sendMsgTo(msg: Any, userManager: ActorRef): Future[Any] = {
    implicit val timeout = Timeout(1 seconds)
    val retFuture = userManager ? msg
    retFuture
  }

  test("test Manager for attatch one success") {
    val actorTuple = createActor
    val retFuture = sendMsgTo(Attach(User("user1", None)), actorTuple._1)
    val Success(result) = retFuture.value.get
    result shouldBe OperationSuccss("user1")
    val internal = actorTuple._2.getAllUser

    internal should have size 1
    internal should contain key "user1"
    actorTuple._3.userList should be (List("user1"))

  }
  test("test Manager for attatch two, but sec is already attached") {
    val actorTuple = createActor
    sendMsgTo(Attach(User("user1", None)), actorTuple._1)
    val retFuture = sendMsgTo(Attach(User("user1", None)), actorTuple._1)

    val Failure(result) = retFuture.value.get
    result shouldBe a[OperationFailed]

    val internal = actorTuple._2.getAllUser
    internal should have size 1
    internal should contain key "user1"

  }


  test("test Manager for attach user,then detach user sucessful") {
    val actorTuple = createActor
    val retFuture = sendMsgTo(Attach(User("user1", None)), actorTuple._1)
    val Success(result) = retFuture.value.get
    result shouldBe OperationSuccss("user1")

    var internal = actorTuple._2.getAllUser
    internal should have size 1

    val retFutureDetach = sendMsgTo(Detach(User("user1", None)), actorTuple._1)
    val Success(resultDetach) = retFutureDetach.value.get
    resultDetach shouldBe OperationSuccss("user1")

    internal = actorTuple._2.getAllUser
    internal should have size 0

  }


  test("test Manager for detach no exist user") {
    val actorTuple = createActor
    val retFutureDetach = sendMsgTo(Detach(User("noexist", None)), actorTuple._1)
    val Failure(resultDetach) = retFutureDetach.value.get
    resultDetach shouldBe a[OperationFailed]
  }

  test("test attach and detach,make sure get all user list correctly") {
    val actorTuple = createActor
    val userManager = actorTuple._1
    userManager ! Attach(User("user1", None))

    val retFuture = sendMsgTo(RequestAllUser, userManager)
    val Success(result: List[_]) = retFuture.value.get
    result should have size 1
    result should contain only "user1"

    userManager ! Detach(User("user1", None))

    val retFuture2 = sendMsgTo(RequestAllUser, userManager)
    val Success(result2: List[_]) = retFuture2.value.get
    result2 should have size 0

  }

  test("test first attach then detach no exist user,the attach info should exist") {
    val actorTuple = createActor
    val userManager = actorTuple._1
    userManager ! Attach(User("user1", None))
    userManager ! Detach(User("noexist", None))

    val retFuture = sendMsgTo(RequestAllUser, userManager)
    val Success(result: List[_]) = retFuture.value.get
    result should have size 1
    result should contain only "user1"
  }

  test("test send msg to an child user, which will throw exception,but all things continue") {
    val userActorCreator = Mockito.mock(classOf[UserActorCreator])
    val props = Props(new ThrowExceptionActor)
    when(userActorCreator.props(any(classOf[User]))).thenReturn(props)
    val stubUserChangedNotification=new StubUserChangedNotification
    val userManager = TestActorRef(new UserManager(userActorCreator,stubUserChangedNotification))

    userManager ! Attach(User("user1", None))
    userManager ! OutFlexMapPayLoad(List[StructuredEventWarpper]())
    expectMsg(OperationSuccss("user1"))
    val retFuture = sendMsgTo(RequestAllUser, userManager)
    val Success(result: List[_]) = retFuture.value.get
    result should have size 1
    result should contain only "user1"
  }

  //  test("test send msg to 2 child user,one will throw exception,but another will receive msg") {
  //    val userActorCreator = Mockito.mock(classOf[UserActorCreator])
  //    val exceptionProps=Props(new ThrowExceptionActor)
  //    val props=Props(new ChildUserActor)
  //    when(userActorCreator.props(any(classOf[User]))).thenReturn(exceptionProps).thenReturn(props)
  //    //.thenReturn(props)
  //    val userManager=system.actorOf(Props(new UserManager(userActorCreator)),"manager_")
  //
  //    userManager ! Attach(User("user5",None))
  //    expectMsg(OperationSuccss("user5"))
  //    userManager ! Attach(User("user6",None))
  //    expectMsg(OperationSuccss("user6"))
  //    userManager ! Msg("any message":AnyRef)
  //    expectMsg("received")
  //  }


}

class UserManagerMultiThreadTest extends TestKitAndFunSuite {
  test("test send msg to 2 child user,one will throw exception,but another will receive msg") {
    val userActorCreator = Mockito.mock(classOf[UserActorCreator])
    val exceptionProps = Props(new ThrowExceptionActor)
    val props = Props(new ChildUserActor)
    when(userActorCreator.props(any(classOf[User]))).thenReturn(exceptionProps).thenReturn(props)
    //.t henReturn(props)
    val stubUserChangedNotification=new StubUserChangedNotification
    val userManager = system.actorOf(Props(new UserManager(userActorCreator,stubUserChangedNotification)), "manager_")

    userManager ! Attach(User("user5", None))
    expectMsg(OperationSuccss("user5"))
    userManager ! Attach(User("user6", None))
    expectMsg(OperationSuccss("user6"))
    userManager ! OutFlexMapPayLoad(List[StructuredEventWarpper]())
    expectMsg("received")
  }
}

class ChildUserActor extends Actor {
  override def receive: Receive = {
    case msg: OutFlexMapPayLoad =>
      val senderName = sender().path.name
      println(s"${this.self.path.name} receive ${msg.toString},send to $senderName")
      sender() ! "received"


  }
}

class ThrowExceptionActor extends Actor {
  override def receive: Receive = {
    case msg: OutFlexMapPayLoad =>
      println(s"${this.self.path.name} receive ${msg.toString},will throw")
      throw new RuntimeException(s"${this.self.path.name} failed")
  }
}

class StubUserChangedNotification extends UserChangedNotifiable{

  var userList:List[String]=_

  override def userChanged(users: Iterable[String]): Unit = userList=users.toList

  override def startScheduleCheck(): Unit = {

  }
}
