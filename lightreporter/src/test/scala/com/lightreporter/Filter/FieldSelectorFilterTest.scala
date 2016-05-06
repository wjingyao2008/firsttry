package com.lightreporter.Filter

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/5/2016.
  */
class FieldSelectorFilterTest extends FunSuite with Matchers{

  test("testSelfPass") {
    val fieldSelectorFilter:Filter[Data] = new FieldSelectorFilter[Data, Int](4, "<=",_.a)
    var data=Data(3,"1!")
    fieldSelectorFilter.isPass(data) shouldBe true

    data=Data(5,"1!")
    fieldSelectorFilter.isPass(data) shouldBe false

    data=Data(4,"1!")
    fieldSelectorFilter.isPass(data) shouldBe true

    val strFieldSelectorFilter:Filter[Data] = new FieldSelectorFilter[Data, String]("4", "==",_.b)
    strFieldSelectorFilter.isPass(data) shouldBe false

    val data2=Data(3,"4")
    strFieldSelectorFilter.isPass(data) shouldBe true

  }

  test("testSelfPass for type string") {

    var strFieldSelectorFilter:Filter[Data] = new FieldSelectorFilter[Data, String]("4", "==",_.b)
    var data=Data(3,"1!")
    strFieldSelectorFilter.isPass(data) shouldBe false

    var data2=Data(3,"4")
    strFieldSelectorFilter.isPass(data2) shouldBe true

  }



  case class Data(a: Int, b: String)

}
