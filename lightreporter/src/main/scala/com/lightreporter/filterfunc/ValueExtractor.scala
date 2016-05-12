package com.lightreporter.filterfunc

import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueExtractor[T] {

  def getKey():String

  def getVal(name:T):Any

  def createOperator(operatorString:String, value:String):Operator[T]
}















