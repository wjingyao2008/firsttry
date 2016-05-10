package com.lightreporter.Filter



/**
  * Created by y28yang on 5/9/2016.
  */
object OperatorEnum extends Enumeration{

  type Equator =Value

  val <= = Value("<=")
  val <  = Value("<")
  val >= = Value(">=")
  val >  = Value(">")
  val == = Value("==")
  val ~ = Value("~")
  val != = Value("!=")
  val in = Value("in")
}
