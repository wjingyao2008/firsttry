package yang.flexmapping

import akka.actor.{Actor, ActorRef}
import yang.flexmapping.FlexProtocol.{FileHasChanged, OutFlexMapPayLoad, ToFlexMapAlarmFlow, XmlContentHasChanged}
import yang.flexmapping.process.FlemxMappingProcesserCreator

import scala.xml.XML

/**
  * Created by y28yang on 4/11/2016.
  */
class FlexMappingActor(processor:FlemxMappingProcesserCreator,
                       clientPort:ActorRef) extends Actor{



  override def receive: Receive = {

    case ToFlexMapAlarmFlow(eventList,theType)=>{
     val convertArrayStructs= eventList.map(events=>{
        val structuredEventWarpper= processor.process(events,theType)
       structuredEventWarpper
      })

      clientPort ! OutFlexMapPayLoad(convertArrayStructs)
    }
    case FileHasChanged(path)=>{
      val xml = XML.loadFile(path)
      processor.parseXmlFile(xml)
    }

    case XmlContentHasChanged(xml)=> processor.parseXmlFile(xml)
  }
}
