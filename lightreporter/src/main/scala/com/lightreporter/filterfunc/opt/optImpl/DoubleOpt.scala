package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor

/**
  * Created by y28yang on 5/10/2016.
  */
class DoubleOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T]) extends ComparableOpt[T,Double](optName,value){
  val doubleVal=value.toDouble

  override def isPass(msg: T): Boolean = {
    val msgStr=valueSelector.getVal(msg).toString
    try {
      comparator(doubleVal, msgStr.toDouble)
    } catch {
      case _ => false
    }
  }
}
