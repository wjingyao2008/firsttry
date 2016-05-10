package com.lightreporter.Filter

import java.util.Comparator

import com.lightreporter.Filter.basictype.BasicTypeFilter
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/4/2016.
  */
class BasicTypeFilterTest extends FunSuite with Matchers{

  test("testIsPass") {
    var basicFilter=new BasicTypeFilter[Int](5,"==")
    basicFilter.isPassBasic(5) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,"<=")
    basicFilter.isPassBasic(3) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,">=")
    basicFilter.isPassBasic(5) shouldBe true
    basicFilter.isPassBasic(6) shouldBe true

    basicFilter=new BasicTypeFilter[Int](5,"<")
    basicFilter.isPassBasic(4) shouldBe true
    basicFilter.isPassBasic(5) shouldBe false


    basicFilter=new BasicTypeFilter[Int](5,">")
    basicFilter.isPassBasic(6) shouldBe true
    basicFilter.isPassBasic(5) shouldBe false

  }


  test("testIsPass for string") {


    var basicFilter=new BasicTypeFilter[String]("4","==")
    basicFilter.isPassBasic("4") shouldBe true

    basicFilter=new BasicTypeFilter[String]("4","!=")
    basicFilter.isPassBasic("3") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPassBasic("a") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPassBasic("b") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b","<=")
    basicFilter.isPassBasic("c") shouldBe false
  }

  test("testIsPass for string with enum") {
    var basicFilter=new BasicTypeFilter[String]("4",OperatorEnum.==)
    basicFilter.isPassBasic("4") shouldBe true

    basicFilter=new BasicTypeFilter[String]("4",OperatorEnum.!=)
    basicFilter.isPassBasic("3") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b",OperatorEnum.<=)
    basicFilter.isPassBasic("a") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b",OperatorEnum.<=)
    basicFilter.isPassBasic("b") shouldBe true

    basicFilter=new BasicTypeFilter[String]("b",OperatorEnum.<=)
    basicFilter.isPassBasic("c") shouldBe false
  }
}
