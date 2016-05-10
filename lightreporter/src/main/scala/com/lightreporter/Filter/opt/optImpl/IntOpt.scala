package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.opt.{ComparableOpt, Operator, ValueGetter}

/**
  * Created by y28yang on 5/10/2016.
  */
class IntOpt[T](optName:String, value:String, valueSelector: ValueGetter[T]) extends ComparableOpt[T,Int](optName,value,valueSelector){

  val intVal=value.toInt

  override def isPass(msg: T): Boolean = {
    val msgBool=valueSelector.getVal(msg).asInstanceOf[Int]
    comparator(intVal,msgBool)
  }
}
