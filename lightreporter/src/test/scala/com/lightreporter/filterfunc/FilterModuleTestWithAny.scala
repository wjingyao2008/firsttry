package com.lightreporter.filterfunc

import java.util.Properties

import com.lightreporter.filterfunc.extractor.AnyData
import org.omg.CORBA.ORB
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/12/2016.
  */

class FilterModuleTestWithAny extends FunSuite with Matchers{

  val orb=getOrb()
  test("a < 1") {
    val filter=createFilterWith("(a < 1 and c>2) or d<=3")
    val anyVal=orb.create_any()
    anyVal.insert_ulong(3)
    filter.isPass(AnyData(anyVal)) shouldBe true
  }

  def createFilterWith(filter:String): Filter[AnyData] = {
    val filterModule = new FilterModule[AnyData](null)
    filterModule.readString(filter)
  }



  def getOrb() = {
    var properties=new Properties()
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
