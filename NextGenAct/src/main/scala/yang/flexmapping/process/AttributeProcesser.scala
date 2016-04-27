package yang.flexmapping.process

import java.text.ParseException
import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import org.apache.log4j.Logger
import yang.flexmapping.datas.DataHolderCreatorFactory
import yang.flexmapping.getval.GetValue
import yang.flexmapping.StructuredEventWarpper

import scala.xml.NodeSeq

/**
  * Created by y28yang on 4/9/2016.
  */
class AttributeProcesser(node: NodeSeq) extends FlexMappingProcesser {

  val log = Logger.getLogger(classOf[AttributeProcesser])

  val id = node \@ "id"

  val dataHolderCreator = initTypeField(node)

  val valueGeter = GetValue.parse(node)

  //TODO
  //val isFilterable????

  override def process(event: util.Map[EventField, String], structuredEvent: StructuredEventWarpper) = {
    var value:String=""
    try {
      value=valueGeter.getValue(event)
      val dataHolder = dataHolderCreator.create(id, value)
      dataHolder.init
      structuredEvent.filterData += dataHolder
    } catch {
      case nfm: NumberFormatException => log.error(s"can not parse,the id:$id,type:${dataHolderCreator.typeCode},value:$value", nfm)
      case parse: ParseException => log.error(s"can not parse,the id:$id,type:${dataHolderCreator.typeCode},value:$value", parse)
      case nup: NullPointerException => log.error(s"can not parse,the id:$id,type:${dataHolderCreator.typeCode},value:$value", nup)
    }
  }

  def initTypeField(node: NodeSeq) = {
    val theType = node \@ "type".trim
    val creator=DataHolderCreatorFactory.getOrWithDefault(theType)
    creator
  }


  def initGetValue() = {

  }


}
