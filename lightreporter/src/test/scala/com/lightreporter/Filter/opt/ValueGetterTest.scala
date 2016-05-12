package com.lightreporter.Filter.opt

import com.lightreporter.Filter.{Data, Data2}
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/10/2016.
  */
class ValueGetterTest extends FunSuite with Matchers{

  class IntGetterImpl extends IntValueGetter[Data]{
    override def getKey(): String = {
      "a"
    }

    override def getVal(name: Data): Any = name.a
  }

  class StringGetterImpl extends StringValueGetter[Data]{
    override def getKey(): String = {
      "b"
    }

    override def getVal(name: Data): Any = name.b
  }

  class ShortGetterImpl extends ShortValueGetter[Data]{
    override def getKey(): String = {
      "c"
    }

    override def getVal(name: Data): Any = name.c
  }

  class LongGetterImpl extends LongValueGetter[Data2]{
    override def getKey(): String = "a"

    override def getVal(name: Data2): Any = name.a
  }

  class ArrayGetterImpl extends ArrayGetter[Data2]{
    override def getKey(): String = "b"

    override def getVal(name: Data2): Any = name.b
  }

  class BoolGetterImpl extends BoolValueGetter[Data2]{
    override def getKey(): String = "c"

    override def getVal(name: Data2): Any = name.c
  }


  test("test int operator") {
    val data=Data(3,"43",1)
     val intSelector=new IntGetterImpl
      intSelector.createOperator("==","3").isPass(data) shouldBe true
      intSelector.createOperator("<","5").isPass(data) shouldBe true
      intSelector.createOperator(">","2").isPass(data) shouldBe true

  }

  test("test string operator") {
    val data=Data(3,"43",1)
    val stringSelector=new StringGetterImpl
    stringSelector.createOperator("==","43").isPass(data) shouldBe true
    stringSelector.createOperator(">","42").isPass(data) shouldBe true
    stringSelector.createOperator("==","41").isPass(data) shouldBe false
    stringSelector.createOperator("!=","42").isPass(data) shouldBe true
    stringSelector.createOperator("!=","43").isPass(data) shouldBe false
    stringSelector.createOperator("~","3").isPass(data) shouldBe true
    stringSelector.createOperator("~","4").isPass(data) shouldBe true
  }

  test("test short operator") {
    val data=Data(3,"43",1)
    val shortSelector=new ShortGetterImpl
    shortSelector.createOperator("==","1").isPass(data) shouldBe true
    shortSelector.createOperator("!=","2").isPass(data) shouldBe true
    shortSelector.createOperator(">","0").isPass(data) shouldBe true
    shortSelector.createOperator("<=","4").isPass(data) shouldBe true
    shortSelector.createOperator("<=","0").isPass(data) shouldBe false
  }



  test("test long operator") {
    val data=Data2(5,Array("1","2","3"),true)
    val longSelector=new LongGetterImpl
    longSelector.createOperator("==","5").isPass(data) shouldBe true
    longSelector.createOperator("!=","2").isPass(data) shouldBe true
    longSelector.createOperator(">","0").isPass(data) shouldBe true
    longSelector.createOperator("<=","6").isPass(data) shouldBe true
    longSelector.createOperator("<=","4").isPass(data) shouldBe false
  }

  test("test array operator") {
    val data=Data2(5,Array("1","2","3"),true)
    val arrayContains=new ArrayGetterImpl
    arrayContains.createOperator("in","5").isPass(data) shouldBe false
    arrayContains.createOperator("in","2").isPass(data) shouldBe true

    val boolSelector=new BoolGetterImpl
    boolSelector.createOperator("==","true").isPass(data) shouldBe true
    boolSelector.createOperator("!=","false").isPass(data) shouldBe true

  }


}
