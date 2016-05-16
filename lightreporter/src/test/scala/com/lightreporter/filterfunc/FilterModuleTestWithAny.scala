package com.lightreporter.filterfunc

import java.util.Properties

import com.lightreporter.filterfunc.operatorfactory.SimpleExtractorLocator
import org.omg.CORBA.ORB
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/12/2016.
  */
case class AnyData(a: org.omg.CORBA.Any = null,
                   b: org.omg.CORBA.Any=null,
                   c: org.omg.CORBA.Any=null)

class FilterModuleTestWithAny extends FunSuite with Matchers {

  val orb = getOrb()
  test("a < 1") {
    val filter = createFilterWith("a < 5.0")
    var anyVal = orb.create_any()
    anyVal.insert_ulong(3)
    filter.isPass(AnyData(anyVal)) shouldBe true
    anyVal = orb.create_any()
    anyVal.insert_ulong(5)
    filter.isPass(AnyData(anyVal)) shouldBe false
  }

  test("a == 'a1'") {
    val filter = createFilterWith("a == 'a1' ")
    var anyVal = orb.create_any()
    anyVal.insert_string("a1")
    filter.isPass(AnyData(anyVal)) shouldBe true
    anyVal = orb.create_any()
    anyVal.insert_string("a2")
    filter.isPass(AnyData(anyVal)) shouldBe false
  }

  test("(a < 1 and c>2) or d<=3") {
    val filter = createFilterWith("(a < 1 and b>2) or c=='3'")
    val a = orb.create_any()
    a.insert_ulong(0)
    val b = orb.create_any()
    b.insert_longlong(3)
    val c = orb.create_any()
    c.insert_string("5")
    filter.isPass(AnyData(a,b,c)) shouldBe true
  }

  def createFilterWith(filter: String): Filter[AnyData] = {
    val extractorLocator = new SimpleExtractorLocator[AnyData]
    extractorLocator.add(new ValueExtractor[AnyData] {

      override def getKey(): String = "a"

      override def getVal(msg: AnyData): Any = msg.a
    })
    extractorLocator.add(new ValueExtractor[AnyData] {

      override def getKey(): String = "b"

      override def getVal(msg: AnyData): Any = msg.b
    })
    extractorLocator.add(new ValueExtractor[AnyData] {

      override def getKey(): String = "c"

      override def getVal(msg: AnyData): Any = msg.c
    })
    val filterModule = new FilterModule[AnyData](extractorLocator)
    filterModule.readString(filter)
  }


  def getOrb() = {
    var properties = new Properties()
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
