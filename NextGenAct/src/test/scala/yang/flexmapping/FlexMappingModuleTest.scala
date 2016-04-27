package yang.flexmapping

import java.util.Properties

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.nsn.oss.nbi.corba4gpp.CorbaServiceLocator
import com.nsn.oss.nbi.fm.notification.EnrichedNotificationDTO
import com.nsn.oss.nbi.interfaces._
import org.omg.CORBA.ORB
import org.scalatest.OneInstancePerTest
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import yang.TestKitAndFunSuite
import yang.corba.notification.NotificationCorbaProtocol.AttachInfo
import yang.corba.notification.{NotificationCorbaModule, NotificationSender, NotificationSenderCreator}
import yang.flexmapping.FlexProtocol.{OutFlexMapPayLoad, XmlContentHasChanged}
import yang.notification.UserProtocol.{Attach, OperationSuccss, User}
import yang.notification.{AlarmNotificationConvert, NotificationCoreModule, UserChangedNotifiable}

/**
  * Created by y28yang on 4/12/2016.
  */
class FlexMappingModuleTest extends TestKitAndFunSuite with OneInstancePerTest {

  test("test attach and send one notification") {
    val ctx = new AnnotationConfigApplicationContext
    ctx.getBeanFactory.registerSingleton("actorFactory", this.system)
    val register = new RegisterTester
    ctx.getBeanFactory.registerSingleton("registerInterface", register)

    ctx.register(classOf[FlexMappingModule])
    ctx.getBeanFactory.registerSingleton("alarmNotificationConvert", new AlarmConverter)
    ctx.register(classOf[NotificationCoreModule])
    val childCreater = new NotificationSenderCreatorProb
    ctx.getBeanFactory.registerSingleton("userActorCreator", childCreater)
    ctx.refresh()

    val enrichActorRef = ctx.getBean("enrichActor", classOf[ActorRef])

    val userManagerActor = ctx.getBean("userManagerActor", classOf[ActorRef])
    userManagerActor ! Attach(User("test1", Some(AttachInfo("userAttach", 1, "$e==1", "1"))))

    expectMsg(OperationSuccss("test1"))


    val flexMappingActor = ctx.getBean("flexMappingActor", classOf[ActorRef])


    flexMappingActor ! XmlContentHasChanged(xml)



    val alarmFlow = new AlarmNotificationFlow
    val notifications = new java.util.ArrayList[AlarmNotification]();
    alarmFlow.setNotifications(notifications)
    val alarmNotification = new AlarmNotification();
    notifications.add(alarmNotification)

    alarmNotification.setNotificationType(AlarmNotificationType.ALARM_NEW)
    alarmNotification.setAckStatus(AckStatus.ACKED)
    val alarmKey = new com.nsn.oss.nbi.interfaces.NsnAlarmKey
    alarmKey.setAlarmId(500000: Long)

    alarmNotification.setAlarmKey(alarmKey)
    alarmNotification.setDn("PLMN-1")
    alarmNotification.setAdditionalText1("this is test")
    alarmNotification.setEventType(EventType.ENVIRONMENTAL)
    enrichActorRef ! alarmFlow

    expectMsg("received")
  }


  test("test attach and send one notification to real corba client,") {
    val isSendToRealCorba=false
    val ior="IOR:000000000000003349444C3A6F6D672E6F72672F436F734E6F74696679436F6D6D2F53657175656E636550757368436F6E73756D65723A312E300000000000010000000000000088000102000000000E31302E3134312E34352E3138360022B8000000325374616E64617264496D706C4E616D652F4D6E7124242F59656C6C6F774475636B5F5365715F50757368436F6E73756D65720000000000020000000000000008000000004A414300000000010000001C00000000000100010000000105010001000101090000000105010001"



    NotificationSender.orb=getOrb
    val ctx = new AnnotationConfigApplicationContext
    ctx.getBeanFactory.registerSingleton("actorFactory", this.system)
    val register = new RegisterTester
    ctx.getBeanFactory.registerSingleton("registerInterface", register)

    ctx.register(classOf[FlexMappingModule])
    ctx.getBeanFactory.registerSingleton("alarmNotificationConvert", new AlarmConverter)
    ctx.register(classOf[NotificationCoreModule])
    ctx.register(classOf[NotificationCorbaModule])
    val childCreater = new NotificationSenderCreatorProb

    ctx.refresh()

    val enrichActorRef = ctx.getBean("enrichActor", classOf[ActorRef])

    val userManagerActor = ctx.getBean("userManagerActor", classOf[ActorRef])
    userManagerActor ! Attach(User("test34", Some(AttachInfo(ior, 1, "$e==1", "1"))))

    expectMsg(OperationSuccss("test34"))


    val flexMappingActor = ctx.getBean("flexMappingActor", classOf[ActorRef])


    flexMappingActor ! XmlContentHasChanged(xml)


    val alarmFlow = new AlarmNotificationFlow
    val notifications = new java.util.ArrayList[AlarmNotification]();
    alarmFlow.setNotifications(notifications)
    val alarmNotification = new AlarmNotification();
    notifications.add(alarmNotification)

    alarmNotification.setNotificationType(AlarmNotificationType.ALARM_NEW)
    alarmNotification.setAckStatus(AckStatus.ACKED)
    val alarmKey = new com.nsn.oss.nbi.interfaces.NsnAlarmKey
    alarmKey.setAlarmId(500000: Long)

    alarmNotification.setAlarmKey(alarmKey)
    alarmNotification.setDn("PLMN-1")
    alarmNotification.setAdditionalText1("this is test")
    alarmNotification.setEventType(EventType.ENVIRONMENTAL)
    enrichActorRef ! alarmFlow


    Thread.sleep(10000)
  }



  class NotificationSenderProbe(userName: String, attachInfo: AttachInfo) extends Actor with ActorLogging {
    override def receive: Receive = {
      case OutFlexMapPayLoad(events) => {
        events.foreach(msg => {
          log.info(s"received notification!!!! $msg")
          log.info(msg.eventName)
          log.info(msg.eventType)
          log.info(msg.domainName)
          msg.filterData.foreach(it => println(it.id, it.value))
        })
        testActor ! "received"
      }
    }
  }

  class NotificationSenderCreatorProb extends NotificationSenderCreator {
    //  def props(user:User): Props = Props(new DemoActor(magicNumber))
    override def createCorbaProps(userName: String, attachInfo: AttachInfo) = {
      Props(new NotificationSenderProbe(userName, attachInfo))
    }
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

  class AlarmConverter extends AlarmNotificationConvert {
    override def convert(dto: EnrichedNotificationDTO): AlarmNotificationFlow = ???
  }

  val xml = <eventMappings
  xmlns="http://www.nokia.com/schemas/3gpp/Nbi/FmMapping"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.nokia.com/schemas/3gpp/Nbi/FmMapping c3g_fm_flex_mapping.xsd">

    <mapping logName="CREATE ALARM">
      <filter>
        <checkEvent>alarmNew</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x1</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="long">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="i" type="string">
        <fromEvent attributeName="alarmNumber"/>
      </attribute>
      <attribute id="j">
        <fromEvent attributeName="alarmText"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="additionalInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="userAddInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="additionalInformation">
        <fromEvent attributeName="additionalInfo"/>
      </attribute>
      <attribute id="userAdditionalInformation">
        <fromEvent attributeName="userAddInfo"/>
      </attribute>
      <attribute id="diagnosticInformation">
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>
  </eventMappings>


  def getOrb() = {
    println("init org.omg.CORBA.ORB by given ");
    //    val jacorbFile= new java.io.File("D:\\mynote\\software\\UCSV1.3.6\\etc\\jacorb.properties");
    val finalProperties = new Properties();
    //    val  in1 = new FileInputStream(jacorbFile);
//    finalProperties.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
//    finalProperties.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");

    //    finalProperties.load(in1)
    val orb = ORB.init(new Array[String](0), finalProperties);
    orb;
  }
}
