package com.lightreporter.filterfunc.opt.optImpl


import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/10/2016.
  */
class ContainInSeqOpt[T](optName:String, value:String, val valueSelector: ValueExtractor[T]) extends Operator[T](optName,value){
  override def isPass(msg: T): Boolean = {
    val msgVal=valueSelector.getVal(msg).asInstanceOf[Array[String]]
    msgVal.contains(value)
  }
}
