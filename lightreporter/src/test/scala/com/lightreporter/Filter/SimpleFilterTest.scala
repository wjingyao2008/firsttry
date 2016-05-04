package com.lightreporter.Filter

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/4/2016.
  */
class SimpleFilterTest extends FunSuite with Matchers {

  test("testIsPass") {
    val map = Map("5" -> 5, "4" -> 4)
    var filter: Filter[Map[String, Int]] = new SmallThanFilter("5", 6)
    filter.isPass(map) shouldBe true
    filter = new LargerThanFilter("4", 6)
    filter.isPass(map) shouldBe false
  }


  test(" when (a<5 and b <5)or C>5, a=5,b=6,c=6") {
    val (a: SmallThanFilter, b: SmallThanFilter, c: LargerThanFilter) = createComplexAandBorC()
    val map = Map("a" -> 5, "b" -> 6, "c" -> 6)
    c.isPass(map) shouldBe true
    b.isPass(map) shouldBe false
    a.isPass(map) shouldBe true
  }

  test(" when (a<5 and b <5)or C>5,and a=4,b=2,c=3") {
    val (a, b, c) = createComplexAandBorC()
    val map = Map("a" -> 4, "b" -> 2, "c" -> 3)
    c.isPass(map) shouldBe false
    a.isPass(map) shouldBe true

  }


  def createComplexAandBorC(): (Filter[Map[String, Int]],
    Filter[Map[String, Int]],
    Filter[Map[String, Int]]) = {
    val a = new SmallThanFilter("a", 5)
    val b = new SmallThanFilter("b", 5)
    val c = new LargerThanFilter("c", 5)
    a.branchOfNext = b
    a.addToBranch(c)
    (a, b, c)
  }

  class SmallThanFilter(val key: String, val value: Int) extends SimpleFilter[Map[String, Int]] {
    override def selfPass(msg: Map[String, Int]): Boolean = {
      val ret = msg.get(key).get < value
      println(s"$key is $ret")
      ret
    }
  }

  class LargerThanFilter(val key: String, val value: Int) extends SimpleFilter[Map[String, Int]] {
    override def selfPass(msg: Map[String, Int]): Boolean = {
      val ret = msg.get(key).get > value
      println(s"$key is $ret")
      ret
    }
  }

}
