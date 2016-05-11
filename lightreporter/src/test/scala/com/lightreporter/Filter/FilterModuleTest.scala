package com.lightreporter.Filter

import com.lightreporter.Filter.opt._
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/11/2016.
  */
class FilterModuleTest extends FunSuite with Matchers{
  val valueExtractorMap = getValueExtractorMap

  test("(a < 1 and c>2) or d<=3") {
    val filter=createFilterWith("(a < 1 and c>2) or d<=3")
    filter.isPass(Data(0,"2",4)) shouldBe true
    filter.isPass(Data(1,"3",1,3)) shouldBe true
    filter.isPass(Data(1,"3",1,4)) shouldBe false
  }

  test("((a < 1 and c>2) or d<=3)") {
    val filter=createFilterWith("(a < 1 and c>2) or d<=3")
    filter.isPass(Data(0,"2",4)) shouldBe true
    filter.isPass(Data(1,"3",1,3)) shouldBe true
    filter.isPass(Data(1,"3",1,4)) shouldBe false
  }


  test("(a < 1 and 2<c) or d<=3") {
    val filter=createFilterWith("(a < 1 and 2<c) or d<=3")
    filter.isPass(Data(0,"2",4)) shouldBe true
    filter.isPass(Data(1,"3",1,3)) shouldBe true
    filter.isPass(Data(1,"3",1,4)) shouldBe false
  }



  test("$b== '3'") {
    val filter= createFilterWith("$b== '3'")
    filter.isPass(Data(0,"3")) shouldBe true
    filter.isPass(Data(0,"2")) shouldBe false
  }


  test("$.b== '3'") {
    val filter= createComplexFilterWith("$.b== '3'")
    filter.isPass(Data(0,"3")) shouldBe true
    filter.isPass(Data(0,"2")) shouldBe false
  }
  test("$.f.e== '3' ") {
    val filter= createComplexFilterWith("$.b.c== '3'")
    filter.isPass(Data(f = Data2(e="3"))) shouldBe true
    filter.isPass(Data(f = Data2(e="4"))) shouldBe false

  }

//  test("$.f.c== true ") {
//    val filter= createComplexFilterWith("$.b.c== '3'")
//    filter.isPass(Data(0,"1",true)) shouldBe true
//    filter.isPass(Data(0,"2",false)) shouldBe false
//  }


  test("a <= -1") {
    val filter = createFilterWith("a <= -1")
    filter.isPass(Data(-1, "3")) shouldBe true
    filter.isPass(Data(3, "2")) shouldBe false
  }

  test("-1 >=a") {
    val filter = createFilterWith("-1 >=a")
    filter.isPass(Data(-1, "3")) shouldBe true
    filter.isPass(Data(3, "2")) shouldBe false
  }


  test("a == -1") {
    val filter = createFilterWith("a == -1")
    filter.isPass(Data(-1, "3")) shouldBe true
    filter.isPass(Data(-3, "2")) shouldBe false
  }

  test("-1 == a"){
    val filter= createFilterWith("-1 == a")
    filter.isPass(Data(-1,"3")) shouldBe true
    filter.isPass(Data(-3,"2")) shouldBe false
  }

  test("a == 1") {
    val filter= createFilterWith("a == 1")
    filter.isPass(Data(1,"3")) shouldBe true
    filter.isPass(Data(-3,"2")) shouldBe false
  }

  test("e == 1") {
    val filter= createFilterWith("a == 1")
    filter.isPass(Data(1,"3",1,1,Array("a","b","c"))) shouldBe true
    filter.isPass(Data(-3,"2",2,3,Array("e","g","f"))) shouldBe false
  }

  test(" $b ~ '3' ") {
    val filter = createFilterWith(" $b ~ '3'  ")
    filter.isPass(Data(1, "31", 2)) shouldBe true
    filter.isPass(Data(1, "12", 4)) shouldBe false
  }

  test(" '3'~$b   ") {
    val filter = createFilterWith(" '3'~$b  ")
    filter.isPass(Data(1, "31", 2)) shouldBe true
    filter.isPass(Data(1, "12", 4)) shouldBe false
  }



  //  str="$.\\c == '\\b'"

  test("test_mthint") {
    var str=""

    str="1 <  b"
    str="1 <=  b"
    str="a == 1"
    str="((a < 1 and b>2) or c==3 ) and $c.d == 2"

    str="a < 1 or $c.d == 2"

    str="a < 1 or $c.d == 2 and $b > 3"
    str="a < 1 or $c.d == 2 and 3 > $b"
    str="a < 1 or $c.d == 2 or $b > 3"
    str="a < 1 and $c.d == 2 and $b > 3"
    str="a < 1 and $c.d == 2 and $b > 3"
    str="$a(c) == 'string'"
    str="$.\\c == 'b'"
    str="(a < 1 or $c.d == 2) and 3 > $b"

    str="a < 1 and ($c.d == 2 or 3 > $b)"
    str="a == 1 or a >1 and $c > 1 or $d <= 3"
    str="a == 1 or a >1 and $c > 1 or $d <= 3 and $b >= 10"
    str="a == 1 and a >1 and ($c > 1 or $d <= 3)"
    str="a == -1"
    str="a == +1 and $.c.d == 'string'"
    str="a != 1"
    str="8 == a"
    str="(a < 1 or $c.d == 2) and (3 > $b or $c <= 4)"

  }


  def createFilterWith(filter:String): Filter[Data] = {
    val filterModule = new FilterModule[Data](valueExtractorMap)
    filterModule.readString(filter)
  }

  def createComplexFilterWith(filter:String): Filter[Data] = {
    val complexFacotry=new ComplexValueExtractorMap[Data,Data2](valueExtractorMap,getValueExtractorMap2())
    val filterModule = new FilterModule[Data](complexFacotry)
    filterModule.readString(filter)
  }


  def getValueExtractorMap():ValueOperatorFactory[Data]  = {
    val valueExtractorMap= new ValueExtractorMap[Data]
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
    valueExtractorMap.add("a", new IntValueGetter[Data] {
      override def getVal(name: Data): Any = name.a

      override def getKey(): String = "a"
    })
    valueExtractorMap
  }


  def getValueExtractorMap2():ValueOperatorFactory[Data2]  = {
    val valueExtractorMap= new ValueExtractorMap[Data2]
    valueExtractorMap.add("e", new BoolValueGetter[Data2] {
      override def getVal(name: Data2): Any = name.e

      override def getKey(): String = "e"
    })

    valueExtractorMap.add("c", new BoolValueGetter[Data2] {
      override def getVal(name: Data2): Any = name.c

      override def getKey(): String = "c"
    })

    valueExtractorMap
  }

}
