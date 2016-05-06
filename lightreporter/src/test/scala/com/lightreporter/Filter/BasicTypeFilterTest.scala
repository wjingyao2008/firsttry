package com.lightreporter.Filter

import java.util.Comparator

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/4/2016.
  */
class BasicTypeFilterTest extends FunSuite with Matchers{

  test("testIsPass") {
    var basicFilter:Filter[Int]=null

    basicFilter=new BasicTypeFilter[Int](5,"==")
    basicFilter.isPass(5) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,"<=")
    basicFilter.isPass(3) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,">=")
    basicFilter.isPass(5) shouldBe true
    basicFilter.isPass(6) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,"<")
    basicFilter.isPass(4) shouldBe true
    basicFilter.isPass(5) shouldBe false


    basicFilter=new BasicTypeFilter[Int](5,">")
    basicFilter.isPass(6) shouldBe true
    basicFilter.isPass(5) shouldBe false

  }


  test("testIsPass for string") {
    var basicFilter:Filter[String]=null

    basicFilter=new BasicTypeFilter[String]("4","==")
    basicFilter.isPass("4") shouldBe true

    basicFilter=new BasicTypeFilter[String]("4","!=")
    basicFilter.isPass("3") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPass("a") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPass("b") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPass("c") shouldBe false
  }

}
