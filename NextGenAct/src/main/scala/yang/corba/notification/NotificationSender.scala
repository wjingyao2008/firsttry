package yang.corba.notification

import akka.actor.{Actor, ActorLogging}
import com.nsn.oss.nbi.corba4gpp.CorbaServiceLocator
import org.omg.CORBA.Any
import org.omg.CosNotification._
import org.omg.CosNotifyComm.SequencePushConsumerHelper
import yang.corba.notification.NotificationCorbaProtocol.AttachInfo
import yang.flexmapping.FlexProtocol.OutFlexMapPayLoad
import yang.flexmapping.StructuredEventWarpper
import org.omg.CORBA.ORB;
/**
  * Created by y28yang on 3/30/2016.
  */
class NotificationSender(userName: String, attachInfo: AttachInfo) extends Actor with ActorLogging {
  val orb = NotificationSender.getORB
  val spc = SequencePushConsumerHelper.narrow(orb.string_to_object(attachInfo.manager_reference))
  val creator = new CorbaAnyValCreator(orb)

  override def receive: Receive = {

    case OutFlexMapPayLoad(convertArrayStructs) =>
      log.info("send out: " + convertArrayStructs)
      val events = convertArrayStructs.filter(doFilter).map(parseStructedEvent(_)).toArray
      if(events.nonEmpty){
        log.info("after filter,send out")
        spc.push_structured_events(events)
      }else {
        log.info("events is empty")
      }

  }

  def doFilter(filterable:StructuredEventWarpper):Boolean={
    true
  }

  def parseStructedEvent(struct: StructuredEventWarpper): StructuredEvent = {
    val structuredEvent = new StructuredEvent
    structuredEvent.header = new EventHeader()
    val domainName = struct.domainName
    val typeName = struct.eventType
    val eventName = struct.eventName
    structuredEvent.header.fixed_header = new FixedEventHeader(new EventType(domainName, typeName), eventName)
    structuredEvent.remainder_of_body = orb.create_any()
    val corbaAnys = struct.filterData.map(dataHolder => {
      val any = dataHolder.toOuterValue(creator).asInstanceOf[Any]
      new Property(dataHolder.id, any)
    }).toArray
    structuredEvent.filterable_data = corbaAnys
    structuredEvent
  }
}


object NotificationSender{

    var orb: ORB = null

  def getORB={
    //if(orb==null)
     // orb=CorbaServiceLocator.getOrb
    orb
  }
}
