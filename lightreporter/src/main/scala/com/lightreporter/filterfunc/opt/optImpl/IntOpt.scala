package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor

/**
  * Created by y28yang on 5/10/2016.
  */
class IntOpt[T](optName: String, value: String, valueSelector: ValueExtractor[T]) extends
  ComparableOpt[T, Int](optName, value) {

  val intVal = value.toDouble.toInt

  override def isPass(msg: T): Boolean = {
    val msgBool = valueSelector.getVal(msg).asInstanceOf[Int]
    comparator(intVal, msgBool)
  }
}
