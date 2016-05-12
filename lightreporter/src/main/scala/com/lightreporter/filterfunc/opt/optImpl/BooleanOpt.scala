package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor


/**
  * Created by y28yang on 5/10/2016.
  */
class BooleanOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T]) extends ComparableOpt[T,Boolean](optName,value,valueSelector){

  val booleanVal=value.toBoolean


  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Boolean]
    comparator(booleanVal,msgBool)
  }
}












