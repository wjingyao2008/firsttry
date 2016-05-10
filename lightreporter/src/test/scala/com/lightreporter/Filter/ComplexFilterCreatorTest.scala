package com.lightreporter.Filter

import org.scalatest.FunSuite

/**
  * Created by y28yang on 5/9/2016.
  */

class ComplexFilterCreatorTest extends FunSuite {
  val valueExtractorMap=new ValueExtractorMap[Data]
//  valueExtractorMap.add("a",new DataValueIntSelector)
//  valueExtractorMap.add("b",new DataValueStringSelector)

  test("test simple string expression"){
    var str="(a < 1 and b>2) or c==3"
    val filterModule=new FilterModule[Data](valueExtractorMap)
//    filterModule.readString(str)
  }

  test("test_mthint") {
  var str=""

  str="1 <  b"
  str="1 <=  b"
  str="a == 1"
  str="((a < 1 and b>2) or c==3 ) and $c.d == 2"
   str.split("and|or").foreach(println(_))

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
}

