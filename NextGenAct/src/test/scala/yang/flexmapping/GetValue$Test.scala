package yang.flexmapping

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.flexmapping.util.GetHandlerInterface
import org.scalatest.{FunSuite, Matchers}
import yang.flexmapping.getval.GetValue
import yang.flexmapping.getval.handler.AttributeNameTypeHandler
import org.mockito.Mockito
import org.mockito.Mockito.{mock, _}
import org.mockito.Matchers._
import org.scalatest.mock.MockitoSugar


/**
  * Created by y28yang on 4/9/2016.
  */
class GetValue$Test extends FunSuite with Matchers with  MockitoSugar{

  test("testGetValForMulti") {
    val multi = GetValue.parse(withMultiAttri)
    val events = new java.util.HashMap[EventField, String]()

    val handler=mock[GetHandlerInterface]
    when(handler.getHandler(org.mockito.Matchers.eq("alarmText"),any[util.Map[EventField, String]])).thenReturn("1")
    when(handler.getHandler(org.mockito.Matchers.eq("additionalInfo"),any[util.Map[EventField, String]])).thenReturn("2")
    when(handler.getHandler(org.mockito.Matchers.eq("userAddInfo"),any[util.Map[EventField, String]])).thenReturn("3")
    when(handler.getHandler(org.mockito.Matchers.eq("diagInfo"),any[util.Map[EventField, String]])).thenReturn("4")

    AttributeNameTypeHandler.handler=handler

    multi.getValue(events) shouldBe "1|2|3|4"
  }


  test("testGetValOneMulti") {
    val oneAttri = GetValue.parse(withOneAttri)
    val events = new java.util.HashMap[EventField, String]()
    val handler=mock[GetHandlerInterface]
    when(handler.getHandler(org.mockito.Matchers.eq("alarmText"),any[util.Map[EventField, String]])).thenReturn("1")
    when(handler.getHandler(org.mockito.Matchers.eq("other"),any[util.Map[EventField, String]])).thenReturn("2")

    AttributeNameTypeHandler.handler=handler
    events.put(EventField.ALARM_TEXT, "1")
    oneAttri.getValue(events) shouldBe "1"
  }

  test("testGetValNoOneAttri") {
    intercept[IllegalArgumentException] {
      val oneAttri = GetValue.parse(NoOneAttri)
    }
  }


  val NoOneAttri = <attribute id="j">
  </attribute>


  val withOneAttri = <attribute id="j">
    <fromEvent attributeName="alarmText"/>
  </attribute>

  val withMultiAttri = <attribute id="j">
    <fromEvent attributeName="alarmText"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="additionalInfo"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="userAddInfo"/>
    <fixedValue>|</fixedValue>
    <fromEvent attributeName="diagInfo"/>
  </attribute>
}
