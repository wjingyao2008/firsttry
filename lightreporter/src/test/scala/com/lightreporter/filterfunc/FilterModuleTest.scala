package com.lightreporter.filterfunc

import com.lightreporter.filterfunc.operatorfactory.{ComplexExtractorLocator, SimpleExtractorLocator}
import com.lightreporter.filterfunc.opt._
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/11/2016.
  */
class FilterModuleTest extends FunSuite with Matchers{
  val valueExtractorMap = getValueExtractorMap()
  val valueExtractorMap2 = getValueExtractorMap2()





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


  test("single dot") {
    val filter= createComplexFilterWith("$.b== '3'")
    filter.isPass(Data(0,"3")) shouldBe true
    filter.isPass(Data(0,"2")) shouldBe false
  }



  test("two dot,f.e=='3'") {
    val filter= createComplexFilterWith("$.f.e== '3'")
    filter.isPass(Data(f = Data2(e="3"))) shouldBe true
    filter.isPass(Data(f = Data2(e="4"))) shouldBe false
  }


//  test("two dot,f.c equals true") {
//    val filter= createComplexFilterWith("$.b.c== true")
//    filter.isPass(Data(f = Data2(c=true))) shouldBe true
//    filter.isPass(Data(f = Data2(c=false))) shouldBe false
//  }




  test("a <= -1.4") {
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

  test("scenario list") {
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
    val complexFactory=new ComplexExtractorLocator[Data,Data2](valueExtractorMap,valueExtractorMap2)
    val filterModule = new FilterModule[Data](complexFactory)
    filterModule.readString(filter)
  }


  def getValueExtractorMap():ExtractorLocator[Data]  = {
    val valueExtractorMap= new SimpleExtractorLocator[Data]
    valueExtractorMap.add("c", new ValueExtractor[Data] {
      override def getVal(name: Data): Any = name.c

      override def getKey(): String = "c"
    })
    valueExtractorMap.add("d", new ValueExtractor[Data] {
      override def getVal(name: Data): Any = name.d

      override def getKey(): String = "d"
    })
    valueExtractorMap.add("b", new ValueExtractor[Data] {
      override def getVal(name: Data): Any = name.b

      override def getKey(): String = "b"
    })

    valueExtractorMap.add("e", new ValueExtractor[Data] {
      override def getVal(name: Data): Any = name.e

      override def getKey(): String = "e"
    })
    valueExtractorMap.add("a", new ValueExtractor[Data] {
      override def getVal(name: Data): Any = name.a

      override def getKey(): String = "a"
    })

    valueExtractorMap.add("f", new ValueExtractor[Data] {

      override def getVal(name: Data): Any = name.f

      override def getKey(): String = "f"
    })

    valueExtractorMap
  }


  def getValueExtractorMap2():ExtractorLocator[Data2]  = {
    val valueExtractorMap= new SimpleExtractorLocator[Data2]
    valueExtractorMap.add("e", new ValueExtractor[Data2] {
      override def getVal(name: Data2): Any = name.e

      override def getKey(): String = "e"
    })

    valueExtractorMap.add("c", new ValueExtractor[Data2] {
      override def getVal(name: Data2): Any = name.c

      override def getKey(): String = "c"
    })

    valueExtractorMap
  }

}
