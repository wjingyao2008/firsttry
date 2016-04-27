package yang.flexmapping.process

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import yang.flexmapping.StructuredEventWarpper

import scala.xml.{Elem, NodeSeq}

/**
  * Created by y28yang on 4/8/2016.
  */
class FlemxMappingProcesserCreator {

  private var processerMap = Map[String, List[FlexMappingProcesser]]()

  def parseXmlFile(xmlString: Elem) = {
    val mappingNode = xmlString \ "mapping"
    processerMap = mappingNode.map(node => {
      val logName = node.attribute("logName").get.text
      val processer = genProcessors(node)
      logName -> processer
    }).toMap
  }

  def process(events: util.Map[EventField, String], theType: String) = {
    val structuredEvent = new StructuredEventWarpper
    val getProcessList = processerMap.get(theType)
    if (getProcessList.isDefined) {
      getProcessList.get.foreach(pro => pro.process(events, structuredEvent))
    }
    else throw new IllegalArgumentException(s"no $theType supported in flexMapping configured")
    structuredEvent
  }

  private def genProcessors(mappingNode: NodeSeq) = {
    val headerConverter = new HeaderConverter(mappingNode)
    val attributesList = genFiltableProcessor(mappingNode)
    var seq = List[FlexMappingProcesser](headerConverter)
    seq ++= attributesList
    seq
  }


  private def genFiltableProcessor(mappingNode: NodeSeq) = {
    val allAttributes = mappingNode \ "attribute"
    allAttributes.map(attr => {
      val attributeProcesser = new AttributeProcesser(attr)
      attributeProcesser
    })
  }
}
