package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor

/**
  * Created by y28yang on 5/10/2016.
  */
class FloatOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T]) extends ComparableOpt[T,Float](optName,value){
  val floatVal=value.toFloat

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Float]
    comparator(floatVal,msgBool)
  }
}
