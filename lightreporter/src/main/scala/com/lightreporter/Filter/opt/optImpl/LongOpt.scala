package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.opt.{ComparableOpt, Operator, ValueGetter}

/**
  * Created by y28yang on 5/10/2016.
  */
class LongOpt[T](optName:String, value:String, valueSelector: ValueGetter[T]) extends ComparableOpt[T,Long](optName,value,valueSelector){

  val longVal=value.toDouble.toLong

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Long]
    comparator(longVal,msgBool)
  }
}
