package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.opt.{Operator, ValueGetter}

/**
  * Created by y28yang on 5/11/2016.
  */
class ComplexOperator[T](optName:String,value:String,val fieldSelector:FieldExtractor) extends Operator[T](optName,value) {

  override def isPass(msg: T): Boolean = {
    fieldSelector.
  }

}

abstract class FieldExtractor(val key:String) {

  def getField(inputMsg: AnyRef):Any

  def getOperator()
}