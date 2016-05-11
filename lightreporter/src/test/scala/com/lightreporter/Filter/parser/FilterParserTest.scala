package com.lightreporter.Filter.parser

import com.lightreporter.Filter.opt._
import com.lightreporter.Filter.{Data, ValueExtractorMap}
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/10/2016.
  */
class FilterParserTest extends FunSuite with Matchers {

  val valueExtractorMap = getValueExtractorMap
  val filterParser = new FilterParser[Data](valueExtractorMap)
  test("c==3") {
    val exp = "c==3"
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 3)) shouldBe true
    filter.isPass(Data(1, "1", 2)) shouldBe false
  }

  test(" c == 3 ") {
    val exp = " c == 3 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 3)) shouldBe true
    filter.isPass(Data(1, "1", 2)) shouldBe false
  }

  test(" c < 3 ") {
    val exp = " c < 3 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" 3>c ") {
    val exp = " 3>c "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" c<=3 ") {
    val exp = " c<=3 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 3)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
    filter.isPass(Data(1, "1", 2)) shouldBe true
  }


  test(" 3>=c ") {
    val exp = " 3>=c "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 3)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
    filter.isPass(Data(1, "1", 2)) shouldBe true
  }


  test(" 3> $c ") {
    val exp = " 3> $c "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }


  test(" +3> $c ") {
    val exp = " +3> $c "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" -3> $c ") {
    val exp = " -3> $c "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", -4)) shouldBe true
    filter.isPass(Data(1, "1", -3)) shouldBe false
  }
  //TODO
  //  test(" 3> $.c ") {
  //    val exp = " 3> $.c "
  //    val filter=filterParser.read(exp)
  //    filter.isPass(Data(1,"1",2)) shouldBe true
  //    filter.isPass(Data(1,"1",4)) shouldBe false
  //  }


  test(" c < -3 ") {
    val exp = " c < -3 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", -4)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }


  test(" c < +3 ") {
    val exp = " c < +3 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" d < 1.2 ") {
    val exp = " d < 1.2 "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2, 1.1f)) shouldBe true
    filter.isPass(Data(1, "1", 4, 1.3f)) shouldBe false
  }

  test(" 1.2>d  ") {
    val exp = " 1.2>d "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "1", 2, 1.1f)) shouldBe true
    filter.isPass(Data(1, "1", 4, 1.3f)) shouldBe false
  }

  test(" $b ~ '3' ") {
    val exp = " $b ~ '3'  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "31", 2)) shouldBe true
    filter.isPass(Data(1, "12", 4)) shouldBe false
  }

  test(" '3'~$b  ") {
    val exp = " '3'~$b  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "31", 2)) shouldBe true
    filter.isPass(Data(1, "12", 4)) shouldBe false
  }

  test(" $b =='3' ") {
    val exp = " $b =='3'  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "3", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" '3' == $b ") {
    val exp = " '3' == $b  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "3", 2)) shouldBe true
    filter.isPass(Data(1, "1", 4)) shouldBe false
  }

  test(" '\'3\'' == $b ") {
    val exp = " '\'3\'' == $b  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "'3'", 2)) shouldBe true
    filter.isPass(Data(1, "'1'", 4)) shouldBe false
  }

  test(" '\\3\\' == $b ") {
    val exp = " '\\3\\' == $b  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "\\3\\", 2)) shouldBe true
    filter.isPass(Data(1, "'1'", 4)) shouldBe false
  }


  test(" $e(1) =='1' currently not supported") {
    //TODO
    //    val exp = " $e(1) =='1'  "
    //    val filter=filterParser.read(exp)
    //    filter.isPass(Data(1,"3",2,1.0f,Array("1","2"))) shouldBe true
    //    filter.isPass(Data(1,"1",4,1.0f,Array("5"))) shouldBe false
  }


  test(" 'UK' in $e ") {
    val exp = " 'UK' in $e  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "3", 2, 1.0f, Array("UK", "CN"))) shouldBe true
    filter.isPass(Data(1, "1", 4, 1.0f, Array("CN"))) shouldBe false
  }





  test(" a==1 or b== '3' ") {
    val exp = " a==1 or b== '3'  "
    val filter = filterParser.read(exp)
    filter.isPass(Data(1, "3")) shouldBe true
    filter.isPass(Data(1, "2")) shouldBe true
    filter.isPass(Data(2, "3")) shouldBe true
    filter.isPass(Data(1, "'1'")) shouldBe false
  }



  def getValueExtractorMap = {
    val valueExtractorMap = new ValueExtractorMap[Data]
    valueExtractorMap.add("c", new ShortValueGetter[Data] {
      override def getVal(name: Data): Any = name.c

      override def getKey(): String = "c"
    })
    valueExtractorMap.add("d", new FloatValueGetter[Data] {
      override def getVal(name: Data): Any = name.d

      override def getKey(): String = "d"
    })
    valueExtractorMap.add("b", new StringValueGetter[Data] {
      override def getVal(name: Data): Any = name.b

      override def getKey(): String = "b"
    })

    valueExtractorMap.add("e", new ArrayGetter[Data] {
      override def getVal(name: Data): Any = name.e

      override def getKey(): String = "e"
    })

    valueExtractorMap
  }

  test("test_mthint") {
    var str = ""

    str = "1 <  b"
    str = "1 <=  b"
    str = "a == 1"
    str = "((a < 1 and b>2) or c==3 ) and $c.d == 2"

    str = "a < 1 or $c.d == 2"

    str = "a < 1 or $c.d == 2 and $b > 3"
    str = "a < 1 or $c.d == 2 and 3 > $b"
    str = "a < 1 or $c.d == 2 or $b > 3"
    str = "a < 1 and $c.d == 2 and $b > 3"
    str = "a < 1 and $c.d == 2 and $b > 3"
    str = "$a(c) == 'string'"
    str = "$.\\c == 'b'"
    str = "(a < 1 or $c.d == 2) and 3 > $b"

    str = "a < 1 and ($c.d == 2 or 3 > $b)"
    str = "a == 1 or a >1 and $c > 1 or $d <= 3"
    str = "a == 1 or a >1 and $c > 1 or $d <= 3 and $b >= 10"
    str = "a == 1 and a >1 and ($c > 1 or $d <= 3)"
    str = "a == -1"
    str = "a == +1 and $.c.d == 'string'"
    str = "a != 1"
    str = "8 == a"
    str = "(a < 1 or $c.d == 2) and (3 > $b or $c <= 4)"

  }
}
