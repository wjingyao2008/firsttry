package yang.flexmapping.process

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import yang.flexmapping.StructuredEventWarpper
import yang.flexmapping.getval.GetValue

import scala.xml.NodeSeq

/**
  * Created by y28yang on 4/8/2016.
  */
class HeaderConverter(mappingNode:NodeSeq) extends FlexMappingProcesser {

   val domainNameGetVal = getGetVal(mappingNode, "domainName")
   val eventTypeGetVal = getGetVal(mappingNode, "typeName")
   val eventNameGetVal = getGetVal(mappingNode, "eventName")


  def getGetVal(node: NodeSeq, tagName: String): GetValue = {
    val tag = node \ tagName
    GetValue.parse(tag)
  }

  override def process(event: util.Map[EventField, String], structuredEvent: StructuredEventWarpper) = {
    structuredEvent.domainName = domainNameGetVal.getValue(event)
    structuredEvent.eventName = eventNameGetVal.getValue(event)
    structuredEvent.eventType = eventTypeGetVal.getValue(event)
  }
}
