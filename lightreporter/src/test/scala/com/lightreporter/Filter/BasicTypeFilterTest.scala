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

}
