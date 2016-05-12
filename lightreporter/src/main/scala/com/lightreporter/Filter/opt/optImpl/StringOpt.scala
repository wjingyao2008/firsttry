package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.opt.{ComparableOpt, Operator, ValueExtractor}

/**
  * Created by y28yang on 5/10/2016.
  */
class StringOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T]) extends ComparableOpt[T,String](optName,value,valueSelector){

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[String]
    comparator(value,msgBool)
  }
}
