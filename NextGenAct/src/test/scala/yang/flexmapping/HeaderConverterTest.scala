package yang.flexmapping

import org.scalatest.{FunSuite, Matchers}
import yang.flexmapping.process.HeaderConverter

import scala.xml._
/**
  * Created by y28yang on 4/9/2016.
  */
class HeaderConverterTest extends FunSuite with Matchers{

  test("testProcess") {

    val headerConverter=new HeaderConverter(headXML)
    val events=new java.util.HashMap[String, String]()
    events.put("irpVersion","v1.1")
    events.put("3gppEventType","3pptest")
//    headerConverter.domainNameGetVal.getValue(events) shouldBe "v1.1"
//    headerConverter.eventTypeGetVal.getValue(events) shouldBe "x3"
//    headerConverter.eventNameGetVal.getValue(events) shouldBe "3pptest"
  }

  val headXML= <mapping logName="ACK"><filter>
    <checkEvent>alarmAck</checkEvent>
  </filter>
  <domainName>
    <fromEvent attributeName="irpVersion"/>
  </domainName>
    <typeName>
      <fixedValue>x3</fixedValue>
    </typeName>
    <eventName>
      <fromEvent attributeName="3gppEventType"/>
    </eventName></mapping>
}
