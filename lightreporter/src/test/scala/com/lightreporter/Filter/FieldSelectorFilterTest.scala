package com.lightreporter.Filter

import com.lightreporter.Filter.Operator.Equator
import com.lightreporter.Filter.basictype.{BasicFilter, IntegerFilter, StringFilter}
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/5/2016.
  */
class FieldSelectorFilterTest extends FunSuite with Matchers {

  test("testSelfPass") {

    val fieldSelectorFilter: Filter[Data] = new FieldSelectorFilter[Data](new DataValueIntSelector, Operator.<=, "4")
    var data = Data(3, "1!")
    fieldSelectorFilter.isPass(data) shouldBe true

    data = Data(5, "1!")
    fieldSelectorFilter.isPass(data) shouldBe false

    data = Data(4, "1!")
    fieldSelectorFilter.isPass(data) shouldBe true

  }

  test("test for string '4' should not == '1!") {
    val data = Data(4, "1!")
    val strFieldSelectorFilter: Filter[Data] = new FieldSelectorFilter[Data](new DataValueStringSelector, Operator.==, "4")
    strFieldSelectorFilter.isPass(data) shouldBe false
  }


  test("test for string '4' should == '4") {
    val strFieldSelectorFilter: Filter[Data] = new FieldSelectorFilter[Data](new DataValueStringSelector, Operator.==, "4")
    val data2 = Data(3, "4")
    strFieldSelectorFilter.isPass(data2) shouldBe true
  }

  test("test for string '4' should == '41") {
    val strFieldSelectorFilter: Filter[Data] = new FieldSelectorFilter(new DataValueStringSelector, Operator.==, "4")
    val data2 = Data(3, "4")
    strFieldSelectorFilter.isPass(data2) shouldBe true
  }

  test("testSelfPass for type string") {

    var strFieldSelectorFilter: Filter[Data] = new FieldSelectorFilter[Data](new DataValueStringSelector, Operator.==, "4")
    var data = Data(3, "1!")
    strFieldSelectorFilter.isPass(data) shouldBe false

    var data2 = Data(3, "4")
    strFieldSelectorFilter.isPass(data2) shouldBe true

  }


  case class Data(a: Int, b: String)

  class DataValueStringSelector extends ValueSelector[Data] {
    override def getVal(name: Data): Any = name.b

    override def getBasicFilter(equator: Equator, value: String): BasicFilter = new StringFilter(equator, value)
  }

  class DataValueIntSelector extends ValueSelector[Data] {
    override def getVal(name: Data): Any = name.a

    override def getBasicFilter(equator: Equator, value: String): BasicFilter = new IntegerFilter(equator, value)
  }

}
