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
    filterModule.readString(str)
  }


}

