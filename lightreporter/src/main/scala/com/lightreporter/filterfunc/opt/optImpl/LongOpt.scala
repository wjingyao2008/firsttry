package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor

/**
  * Created by y28yang on 5/10/2016.
  */
class LongOpt[T](optName: String, value: String, valueSelector: ValueExtractor[T])
  extends ComparableOpt[T, Long](optName, value) {

  val longVal = value.toDouble.toLong

  override def isPass(msg: T): Boolean = {
    val msgBool = valueSelector.getVal(msg).asInstanceOf[Long]
    comparator(longVal, msgBool)
  }
}
