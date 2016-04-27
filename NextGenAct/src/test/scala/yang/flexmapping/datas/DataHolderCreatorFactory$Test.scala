package yang.flexmapping.datas

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 4/10/2016.
  */
class DataHolderCreatorFactory$Test extends FunSuite with Matchers{

  test("testGetOrWithDefault") {

   typeCodeShouldBeSame("string")
   typeCodeShouldBeSame("int")
   typeCodeShouldBeSame("bool")
   typeCodeShouldBeSame("time")
   typeCodeShouldBeSame("short")
   typeCodeShouldBeSame("ulong")
   typeCodeShouldBeSame("ushort")

    DataHolderCreatorFactory.getOrWithDefault("other").typeCode shouldBe "string"
  }

  def typeCodeShouldBeSame(typeCode:String): Unit ={
    val creator=DataHolderCreatorFactory.getOrWithDefault("string").typeCode shouldBe "string"
  }

}
