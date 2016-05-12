package com.lightreporter.Filter

import com.lightreporter.Filter.opt.{Operator, ValueGetter}

/**
  * Created by y28yang on 5/12/2016.
  */
trait ValueOperatorFactory[T] {

  def getSelector(name: String):ValueGetter[T]


  def getOperator(name: String, optEnum:OperatorEnum.Value,value:String):Operator[T]

}
