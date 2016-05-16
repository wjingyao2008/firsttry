package Corba

import java.util.Properties

import com.lightreporter.filterfunc.operatorfactory.SimpleExtractorLocator
import com.lightreporter.filterfunc.{Filter, FilterModule, ValueExtractor}
import com.lightreporter.registration.BroadCastModule
import org.omg.CORBA.ORB
import org.omg.CosNotification._
import org.omg.CosNotifyComm.SequencePushConsumerHelper
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 4/12/2016.
  */
class CorbaIntegrationTest extends FunSuite with Matchers {

  val orb = createIOR;
  val ior = "IOR:000000000000003349444C3A6F6D672E6F72672F436F734E6F74696679436F6D6D2F53657175656E636550757368436F6E73756D65723A312E300000000000010000000000000088000102000000000E31302E3134312E34352E3231370022B8000000325374616E64617264496D706C4E616D652F4D6E7124242F59656C6C6F774475636B5F5365715F50757368436F6E73756D65720000000000020000000000000008000000004A414300000000010000001C00000000000100010000000105010001000101090000000105010001"


  test("test whether connect to a remote clinet, and pushStructured,default close, you have to mannually open to test,") {
    val isRunTheTest = true
    if (isRunTheTest) {
      val filterModule = initFilterModule()
      val filter = createFilter("$type_name == 'yangtype2'", filterModule)
      val module = createBroadCast()

      register("user1", ior, module, filter)
      val msg = createMsg()
      module.sendMsg(msg)
      val msg2 = createMsg2()
      module.sendMsg(msg2)
      Thread.sleep(1000)
    }
  }

  test("compare equation") {
    val filterModule = initFilterModule()
    val filter = createFilter(" b== 'abc'", filterModule)
    var bAny = orb.create_any()
    bAny.insert_string("abc")
    val msg = createMsg()
    msg.filterable_data=Array[Property](new Property("b",bAny))
    filter.isPass(msg) shouldBe true

    bAny = orb.create_any()
    bAny.insert_string("s2")
    msg.filterable_data=Array[Property](new Property("b",bAny))
    filter.isPass(msg) shouldBe false
  }

  def createBroadCast() = {
    val broadcastModule = new BroadCastModule[StructuredEvent]()
    broadcastModule.init()
  }


  def register(regName: String, iorReceiver: String, module: BroadCastModule[StructuredEvent], filterStr: Filter[StructuredEvent] = null) = {
    val receiver = createReceiver(iorReceiver)
    if (filterStr == null)
      module.register(regName, receiver)
    else {
      module.register(regName, receiver, filterStr)
    }
  }


  def initFilterModule(): FilterModule[StructuredEvent] = {
    val handler = new NoneExtractorHandler()
    val operatorFactory = new SimpleExtractorLocator[StructuredEvent](
      handler
    )
    operatorFactory.add(new ValueExtractor[StructuredEvent] {
      override def getKey(): String = "type_name"

      override def getVal(name: StructuredEvent): Any = name.header.fixed_header.event_type.type_name
    })
    operatorFactory.add(new ValueExtractor[StructuredEvent] {
      override def getKey(): String = "domain_name"

      override def getVal(name: StructuredEvent): Any = name.header.fixed_header.event_type.domain_name
    })

    operatorFactory.add(new ValueExtractor[StructuredEvent] {
      override def getKey(): String = "remainder_of_body"

      override def getVal(name: StructuredEvent): Any = name.remainder_of_body
    })

    new FilterModule[StructuredEvent](operatorFactory)
  }


  def createFilter(filterStr: String, filterModule: FilterModule[StructuredEvent]): Filter[StructuredEvent] = {
    if (filterStr == null || filterStr.isEmpty) return null

    filterModule.readString(filterStr)
  }

  def createMsg() = {
    val structuredEvent = new StructuredEvent()
    structuredEvent.header = new EventHeader()
    structuredEvent.header.fixed_header = new FixedEventHeader(new EventType("domainbane", "yangtype"), "iamhead")
    val jacorbAny = orb.create_any()
    jacorbAny.insert_string("p1-value")
    structuredEvent.header.variable_header = Array(new Property("p1", jacorbAny))
    structuredEvent.filterable_data = Array.empty[Property]
    structuredEvent.remainder_of_body = orb.create_any()
    structuredEvent
  }

  def createMsg2() = {
    val structuredEvent = new StructuredEvent()
    structuredEvent.header = new EventHeader()
    structuredEvent.header.fixed_header = new FixedEventHeader(new EventType("domainbane", "yangtype2"), "iamhead")
    val jacorbAny = orb.create_any()
    jacorbAny.insert_string("p1-value")
    structuredEvent.header.variable_header = Array(new Property("p1", jacorbAny))
    structuredEvent.header
    structuredEvent.filterable_data = Array.empty[Property]
    structuredEvent.remainder_of_body = orb.create_any()
    structuredEvent
  }


  def createReceiver(ior: String) = {
    val spc = SequencePushConsumerHelper.narrow(orb.string_to_object(ior))
    new CorbaReceiver(spc)
  }


  def createIOR() = {
    var propert = new Properties()
    //    val inputStream = getClass.getResourceAsStream("/proxy-1/jacorb.properties")
    //    propert.load(inputStream)
    println("init org.omg.CORBA.ORB by given ");
    //    val jacorbFile= new java.io.File("D:\\mynote\\software\\UCSV1.3.6\\etc\\jacorb.properties");

    //    val  in1 = new FileInputStream(jacorbFile);
    propert.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
    propert.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");

    //    finalProperties.load(in1)
    val orb = ORB.init(new Array[String](0), propert);
    orb;
  }
}
