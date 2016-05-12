package com.lightreporter.filterfunc.opt

import com.lightreporter.filterfunc.extractor._
import com.lightreporter.filterfunc.{Data, Data2}
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/10/2016.
  */
class ValueExtractorTest extends FunSuite with Matchers{

  class IntExtractorImpl extends IntValueExtractor[Data]{
    override def getKey(): String = {
      "a"
    }

    override def getVal(name: Data): Any = name.a
  }

  class StringExtractorImpl extends StringValueExtractor[Data]{
    override def getKey(): String = {
      "b"
    }

    override def getVal(name: Data): Any = name.b
  }

  class ShortExtractorImpl extends ShortValueExtractor[Data]{
    override def getKey(): String = {
      "c"
    }

    override def getVal(name: Data): Any = name.c
  }

  class LongExtractorImpl extends LongValueExtractor[Data2]{
    override def getKey(): String = "a"

    override def getVal(name: Data2): Any = name.a
  }

  class ArrayExtractorImpl extends ArrayExtractor[Data2]{
    override def getKey(): String = "b"

    override def getVal(name: Data2): Any = name.b
  }

  class BoolExtractorImpl extends BoolValueExtractor[Data2]{
    override def getKey(): String = "c"

    override def getVal(name: Data2): Any = name.c
  }


  test("test int operator") {
    val data=Data(3,"43",1)
     val intSelector=new IntExtractorImpl
      intSelector.createOperator("==","3").isPass(data) shouldBe true
      intSelector.createOperator("<","5").isPass(data) shouldBe true
      intSelector.createOperator(">","2").isPass(data) shouldBe true

  }

  test("test string operator") {
    val data=Data(3,"43",1)
    val stringSelector=new StringExtractorImpl
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
    val shortSelector=new ShortExtractorImpl
    shortSelector.createOperator("==","1").isPass(data) shouldBe true
    shortSelector.createOperator("!=","2").isPass(data) shouldBe true
    shortSelector.createOperator(">","0").isPass(data) shouldBe true
    shortSelector.createOperator("<=","4").isPass(data) shouldBe true
    shortSelector.createOperator("<=","0").isPass(data) shouldBe false
  }



  test("test long operator") {
    val data=Data2(5,Array("1","2","3"),c = true)
    val longSelector=new LongExtractorImpl
    longSelector.createOperator("==","5").isPass(data) shouldBe true
    longSelector.createOperator("!=","2").isPass(data) shouldBe true
    longSelector.createOperator(">","0").isPass(data) shouldBe true
    longSelector.createOperator("<=","6").isPass(data) shouldBe true
    longSelector.createOperator("<=","4").isPass(data) shouldBe false
  }

  test("test array operator") {
    val data=Data2(5,Array("1","2","3"),c =true)
    val arrayContains=new ArrayExtractorImpl
    arrayContains.createOperator("in","5").isPass(data) shouldBe false
    arrayContains.createOperator("in","2").isPass(data) shouldBe true

    val boolSelector=new BoolExtractorImpl
    boolSelector.createOperator("==","true").isPass(data) shouldBe true
    boolSelector.createOperator("!=","false").isPass(data) shouldBe true

  }


}
