package com.lightreporter.Filter.extractor

import com.lightreporter.Filter.opt.{Operator, ValueExtractor}
import com.lightreporter.Filter.opt.optImpl.ShortOpt

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class ShortValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new ShortOpt[T](operatorString,value,this)
    }
  }
}
