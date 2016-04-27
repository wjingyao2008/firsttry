package tool

import java.util.Properties

import org.omg.CORBA.ORB
import org.omg.CosNotification._
import org.omg.CosNotifyComm.SequencePushConsumerHelper
import org.scalatest.FunSuite

/**
  * Created by y28yang on 4/12/2016.
  */
class CorbaTest extends FunSuite{
  test("test whether connect to a remote clinet, and pushStructured,default close, you have to mannually open to test,") {
    val isRunTheTest = true

    if (isRunTheTest) {
      val ior = "IOR:000000000000003349444C3A6F6D672E6F72672F436F734E6F74696679436F6D6D2F53657175656E636550757368436F6E73756D65723A312E300000000000010000000000000088000102000000000E31302E3134312E34342E3139320022B8000000325374616E64617264496D706C4E616D652F4D6E7124242F59656C6C6F774475636B5F5365715F50757368436F6E73756D65720000000000020000000000000008000000004A414300000000010000001C00000000000100010000000105010001000101090000000105010001"
      tryToSendMsgToRemote(ior)
    }
  }

  def tryToSendMsgToRemote(ior: String) = {
    var propert:Properties=new Properties()
    val inputStream=getClass.getResourceAsStream("/proxy-1/jacorb.properties")
    propert.load(inputStream)
    val orb = getOrb(propert);

    val spc = SequencePushConsumerHelper.narrow(orb.string_to_object(ior))
    println(spc._non_existent())


    val time = System.currentTimeMillis()
    (1 to 5000).foreach(_ => {
      val structuredEvent = new StructuredEvent()
      structuredEvent.header = new EventHeader()
      structuredEvent.header.fixed_header = new FixedEventHeader(new EventType("domanbane", "yangtype"), "iamhead")
      val jacorbAny = orb.create_any()
      jacorbAny.insert_string("anyValue")
      structuredEvent.header.variable_header = Array(new Property("p1", jacorbAny))
      structuredEvent.filterable_data = Array.empty[Property]
      structuredEvent.remainder_of_body = orb.create_any()
      spc.push_structured_events(Array(structuredEvent))

    })
    println(System.currentTimeMillis() - time)
  }


  def getOrb(properties: Properties) = {
    println("init org.omg.CORBA.ORB by given ");
    //    val jacorbFile= new java.io.File("D:\\mynote\\software\\UCSV1.3.6\\etc\\jacorb.properties");
    val finalProperties = properties
    //    val  in1 = new FileInputStream(jacorbFile);
    finalProperties.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
    finalProperties.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");

    //    finalProperties.load(in1)
    val orb = ORB.init(new Array[String](0), finalProperties);
    orb;
  }
}
