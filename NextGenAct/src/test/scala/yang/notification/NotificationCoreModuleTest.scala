package yang.notification


import akka.actor.{Actor, ActorRef, Props, Status}
import com.nsn.oss.nbi.fm.notification.EnrichedNotificationDTO
import com.nsn.oss.nbi.interfaces.AlarmNotificationFlow
import org.scalatest.OneInstancePerTest
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import yang.TestKitAndFunSuite
import yang.corba.notification.NotificationCorbaProtocol.AttachInfo
import yang.corba.notification.NotificationSenderCreator
import yang.notification.UserProtocol.{Attach, Detach, OperationSuccss, User}

/**
  * Created by y28yang on 4/5/2016.
  */
class NotificationCoreModuleTest extends TestKitAndFunSuite with OneInstancePerTest {

  test("testSourceActor attach and detach") {

    //    val baseConfiguration= new BaseConfiguration()
    //    baseConfiguration.addProperty("com.oss.nsn.nbi.was.ndcallback.hostname","127.0.0.5")
    val ctx = new AnnotationConfigApplicationContext
    ctx.getBeanFactory.registerSingleton("actorFactory", this.system)
    val register = new RegisterTester
    ctx.getBeanFactory.registerSingleton("registerInterface", register)

    ctx.getBeanFactory.registerSingleton("enrichActor", testActor)
    ctx.getBeanFactory.registerSingleton("alarmNotificationConvert", new AlarmConverter)
    ctx.register(classOf[NotificationCoreModule])
    val childCreater = new NotificationSenderCreatorProb
    ctx.getBeanFactory.registerSingleton("userActorCreator", childCreater)
    ctx.refresh()

    register.isStartedSchedule shouldBe true
    register.isRegisterToND shouldBe None

    val userManagerActor = ctx.getBean("userManagerActor", classOf[ActorRef])
    userManagerActor ! Attach(User("test1", Some(AttachInfo("userAttach", 1, "$e==1", "1"))))

    register.isStartedSchedule shouldBe true

    expectMsg(OperationSuccss("test1"))

    register.isRegisterToND shouldBe Some(true)

    userManagerActor ! Detach(User("test1", None))

    expectMsg(OperationSuccss("test1"))
    Thread.sleep(1000)
    register.isRegisterToND shouldBe Some(false)

  }

  test("testSourceActor attach and detach not exsit user,the nd should still registe") {

    //    val baseConfiguration= new BaseConfiguration()
    //    baseConfiguration.addProperty("com.oss.nsn.nbi.was.ndcallback.hostname","127.0.0.5")
    val ctx = new AnnotationConfigApplicationContext
    ctx.getBeanFactory.registerSingleton("actorFactory", this.system)
    val register = new RegisterTester
    ctx.getBeanFactory.registerSingleton("registerInterface", register)

    ctx.getBeanFactory.registerSingleton("enrichActor", testActor)
    ctx.getBeanFactory.registerSingleton("alarmNotificationConvert", new AlarmConverter)
    ctx.register(classOf[NotificationCoreModule])
    val childCreater = new NotificationSenderCreatorProb
    ctx.getBeanFactory.registerSingleton("userActorCreator", childCreater)
    ctx.refresh()

    register.isStartedSchedule shouldBe true
    register.isRegisterToND shouldBe None

    val userManagerActor = ctx.getBean("userManagerActor", classOf[ActorRef])
    userManagerActor ! Attach(User("test1", Some(AttachInfo("userAttach", 1, "$e==1", "1"))))

    register.isStartedSchedule shouldBe true

    expectMsg(OperationSuccss("test1"))

    register.isRegisterToND shouldBe Some(true)

    userManagerActor ! Detach(User("test2", None))

    expectMsgClass(classOf[Status.Failure])
    Thread.sleep(1000)
    register.isRegisterToND shouldBe Some(true)

  }


  class RegisterTester extends UserChangedNotifiable {

    override def userChanged(users: Iterable[String]): Unit = {
       isRegisterToND = Some(users.nonEmpty)
    }

    var isStartedSchedule = false
    var isRegisterToND: Option[Boolean] = None

    override def startScheduleCheck() {
      isStartedSchedule = true
    }


  }

  class NotificationSenderCreatorProb extends NotificationSenderCreator {
    //  def props(user:User): Props = Props(new DemoActor(magicNumber))
    override def createCorbaProps(userName: String, attachInfo: AttachInfo) = {
      Props(new NotificationSenderProbe(userName, attachInfo))
    }
  }

  class NotificationSenderProbe(userName: String, attachInfo: AttachInfo) extends Actor {
    override def receive: Receive = {
      case msg => testActor !(userName, attachInfo, msg)
    }
  }

  class AlarmConverter extends AlarmNotificationConvert{
    override def convert(dto: EnrichedNotificationDTO): AlarmNotificationFlow = ???
  }
}
