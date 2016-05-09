package com.lightreporter.Filter


/**
  * Created by y28yang on 5/9/2016.
  */
object TypeEnum extends Enumeration{
  type TypeEnum =Value

  val string = Value("string")
  val  int= Value("int")
  val  long= Value("long")
  val  double= Value("double")
  val  boolean= Value("boolean")
  val  short = Value("short")
}
