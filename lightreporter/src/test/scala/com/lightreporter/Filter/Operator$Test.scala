package com.lightreporter.Filter

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by y28yang on 5/9/2016.
  */
class Operator$Test extends FunSuite with Matchers{

  test("test string to enum") {

    Operator.withName("<=") shouldBe Operator.<=
    Operator.withName(">=") shouldBe Operator.>=
    Operator.withName("<") shouldBe Operator.<
    Operator.withName(">") shouldBe Operator.>
    Operator.withName("==") shouldBe Operator.==
    Operator.withName("!=") shouldBe Operator.!=
  }

}
