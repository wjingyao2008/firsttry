package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.opt.{ComparableOpt, ValueExtractor}

/**
  * Created by y28yang on 5/10/2016.
  */
class FloatOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T]) extends ComparableOpt[T,Float](optName,value,valueSelector){
  val floadVal=value.toFloat

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Float]
    comparator(floadVal,msgBool)
  }
}
