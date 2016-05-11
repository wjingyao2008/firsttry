package com.lightreporter.Filter

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/9/2016.
  */
class OperatorEnum$Test extends FunSuite with Matchers{

  test("test string to enum") {

    OperatorEnum.withName("<=") shouldBe OperatorEnum.<=
    OperatorEnum.withName(">=") shouldBe OperatorEnum.>=
    OperatorEnum.withName("<") shouldBe OperatorEnum.<
    OperatorEnum.withName(">") shouldBe OperatorEnum.>
    OperatorEnum.withName("==") shouldBe OperatorEnum.==
    OperatorEnum.withName("!=") shouldBe OperatorEnum.!=

    OperatorEnum.reverse(OperatorEnum.withName("!=")) shouldBe OperatorEnum.!=
    OperatorEnum.reverse(OperatorEnum.withName("<=")) shouldBe OperatorEnum.>=
  }

}
