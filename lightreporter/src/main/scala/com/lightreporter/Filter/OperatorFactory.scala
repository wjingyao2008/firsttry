package com.lightreporter.Filter

import com.lightreporter.Filter.opt.{Operator, ValueExtractor}

/**
  * Created by y28yang on 5/12/2016.
  */
trait OperatorFactory[T] {

  def getExtractor(name: String):ValueExtractor[T]


  def getOperator(name: String, optEnum:OperatorEnum.Value,value:String):Operator[T]

}
