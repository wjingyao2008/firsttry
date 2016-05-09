package com.lightreporter.Filter

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/4/2016.
  */
class SimpleFilterTest extends FunSuite with Matchers {

  test(" when 5<6,should be true,and when 4>6 should be false") {
    val map = Map("5" -> 5, "4" -> 4)
    var filter: Filter[Map[String, Int]] = new SmallThanFilter("5", 6)
    filter.isPass(map) shouldBe true
    filter = new LargerThanFilter("4", 6)
    filter.isPass(map) shouldBe false
  }


  test(" when (a<5 and b <5)or C>5, a=5,b=6,c=6") {
    val (a: SmallThanFilter, b: SmallThanFilter, c: LargerThanFilter) = createComplexAandBorC()
    val map = crt_abc(5,6,6)
    c.isPass(map) shouldBe true
    b.isPass(map) shouldBe false
    a.isPass(map) shouldBe true
  }

  test(" when (a<5 and b <5)or C>5,and a=4,b=2,c=3") {
    val (a, b, c) = createComplexAandBorC()
    val map = crt_abc(4,2,3)
    c.isPass(map) shouldBe false
    a.isPass(map) shouldBe true

  }



  test(" when a<5 or b <5 or c>5") {
    val (a, b, c) = createComplex_A_or_B_or_C()

    a.isPass(crt_abc(4,6,6)) shouldBe true
    a.isPass(crt_abc(6,4,6)) shouldBe true
    a.isPass(crt_abc(6,6,7)) shouldBe true
  }



  test(" when a<5 and b <5 and c>5") {
    val (a, b, c) = createComplex_A_and_B_and_C()

    a.isPass(crt_abc(4,4,6)) shouldBe true
    a.isPass(crt_abc(6,4,6)) shouldBe false
    a.isPass(crt_abc(4,6,7)) shouldBe false
    a.isPass(crt_abc(4,4,5)) shouldBe false
  }

  def crt_abc(a:Int,b:Int,c:Int)=Map("a" -> a, "b" -> b, "c" -> c)


  def createComplex_A_and_B_and_C(a:Int=5,b:Int=5,c:Int=5): (Filter[Map[String, Int]],
    Filter[Map[String, Int]],
    Filter[Map[String, Int]]) = {
    val aF = new SmallThanFilter("a", a)
    val bF = new SmallThanFilter("b", b)
    val cF = new LargerThanFilter("c", c)
    aF.andFilter=bF
    bF.andFilter=cF
    (aF, bF, cF)
  }



  def createComplex_A_or_B_or_C(a:Int=5,b:Int=5,c:Int=5): (Filter[Map[String, Int]],
    Filter[Map[String, Int]],
    Filter[Map[String, Int]]) = {
    val aF = new SmallThanFilter("a", a)
    val bF = new SmallThanFilter("b", b)
    val cF = new LargerThanFilter("c", c)
    aF.addOrFilter(cF)
    aF.addOrFilter(bF)
    (aF, bF, cF)
  }



  def createComplexAandBorC(aV:Int=5,bV:Int=5,cV:Int=5): (Filter[Map[String, Int]],
    Filter[Map[String, Int]],
    Filter[Map[String, Int]]) = {
    val a = new SmallThanFilter("a", aV)
    val b = new SmallThanFilter("b", bV)
    val c = new LargerThanFilter("c", cV)
    a.andFilter = b
    a.addOrFilter(c)
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
