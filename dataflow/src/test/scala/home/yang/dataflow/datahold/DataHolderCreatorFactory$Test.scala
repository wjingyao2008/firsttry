package home.yang.dataflow.datahold

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class DataHolderCreatorFactory$Test extends FunSuite with Matchers{

  test("testGetOrWithDefault") {
    val intCreator=DataHolderCreatorFactory.getOrWithDefault("int")
    val dataHolder=intCreator.create("yangTYPE","35")
    dataHolder.parse
    val intFilter=new IntFilter("yangTYPE",_ > 20)
    dataHolder.toOuterValue(intFilter) shouldBe true
  }
  test("test filter of string") {
    val intCreator=DataHolderCreatorFactory.getOrWithDefault("string")
    val dataHolder=intCreator.create("yangTYPE","35")
    dataHolder.parse
    val stringFilter=new StringFilter("yangTYPE",_ == "34")
    dataHolder.toOuterValue(stringFilter) shouldBe false

  }
}
