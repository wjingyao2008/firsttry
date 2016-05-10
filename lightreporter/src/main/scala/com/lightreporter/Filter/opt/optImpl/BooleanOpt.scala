package com.lightreporter.Filter.opt.optImpl


import com.lightreporter.Filter.opt.{ComparableOpt, ValueGetter}

/**
  * Created by y28yang on 5/10/2016.
  */
class BooleanOpt[T](optName:String, value:String, valueSelector: ValueGetter[T]) extends ComparableOpt[T,Boolean](optName,value,valueSelector){

  val booleanVal=value.toBoolean


  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Boolean]
    comparator(booleanVal,msgBool)
  }
}












