package yang.flexmapping

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.flexmapping.handler.BaseHandler
import com.nsn.oss.nbi.flexmapping.util.GetHandlerInterface
import org.mockito.Mockito._
import org.mockito.Mockito
import org.scalatest.{FunSuite, Matchers}
import yang.flexmapping.getval.handler.AttributeNameTypeHandler
import yang.flexmapping.process.AttributeProcesser

import scala.xml._
/**
  * Created by y28yang on 4/9/2016.
  */
class AttributeProcesserTest extends FunSuite with Matchers{

//  test("testInit") {
//
//    AttributeNameTypeHandler.handler=new AnyGetHandlerInterface
//     val base=Mockito.mock(classOf[BaseHandler])
//
//   val attributeProcesser=new AttributeProcesser(withTypeXml)
////    println((withMultiAttri \ "_").length)
//    withMultiAttri.nonEmptyChildren.foreach(println(_))
//    attributeProcesser.id shouldBe "g"
//    attributeProcesser.dataHolderCreator.typeCode shouldBe "long"
//    val events=new java.util.HashMap[EventField, String]()
//    events.put(EventField.PROBABAL_CAUSE ,"123")  //"probableCause"
//    attributeProcesser.valueGeter.getValue(events) shouldBe "123"
//  }
//
//
//  test("testWithOutTypeXml,no type,then the type will be String default") {
//
//    val attributeProcesser=new AttributeProcesser(withOutTypeXml)
//    attributeProcesser.id shouldBe "g"
//    attributeProcesser.dataHolderCreator.typeCode shouldBe "string"
//    val events=new java.util.HashMap[String, String]()
//    events.put("probableCause","123")
//    attributeProcesser.valueGeter.getValue(events) shouldBe "x3"
//  }
//
//
//
//  test("testWithMultiAttriXm") {
//    val attributeProcesser=new AttributeProcesser(withMultiAttri)
//    attributeProcesser.id shouldBe "j"
//    attributeProcesser.dataHolderCreator.typeCode shouldBe "string"
//    val events=new java.util.HashMap[String, String]()
//    events.put("alarmText","123")
//    events.put("additionalInfo","345")
//    events.put("userAddInfo","567")
//    events.put("diagInfo","789")
//    attributeProcesser.valueGeter.getValue(events) shouldBe "123|345|567|789"
//  }

//  class AnyGetHandlerInterface extends GetHandlerInterface{
//    override def getHandler(key: String): BaseHandler = {
//      new BaseHandler {
//        override def getValue(event: util.Map[EventField, String]): String =
//          event.get(key)
//      }
//    }
//  }

  val withMultiAttri= <attribute id="j">
    <fromEvent attributeName="alarmText"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="additionalInfo"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="userAddInfo"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="diagInfo"/>
  </attribute>


  val withTypeXml= <attribute id="g" type="long">
            <fromEvent attributeName="probableCause"/>
     </attribute>


  val withOutTypeXml= <attribute id="g">
    <fixedValue>x3</fixedValue>
  </attribute>
}
