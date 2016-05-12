package com.lightreporter.filterfunc.opt

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


  def reverse(operator:OperatorEnum.Value)={
    operator match {
      case OperatorEnum.<= => OperatorEnum.>=
      case OperatorEnum.< => OperatorEnum.>
      case OperatorEnum.>= => OperatorEnum.<=
      case OperatorEnum.> => OperatorEnum.<
      case default  => default
    }
  }
}
