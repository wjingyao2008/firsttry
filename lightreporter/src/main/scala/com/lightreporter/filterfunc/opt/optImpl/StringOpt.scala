package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/10/2016.
  */
class StringOpt[T](optName:String, value:String, valueSelector: ValueExtractor[T])
  extends ComparableOpt[T,String](optName,value){

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).toString
    comparator(value,msgBool)
  }
}
