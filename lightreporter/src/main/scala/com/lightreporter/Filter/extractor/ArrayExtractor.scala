package com.lightreporter.Filter.extractor

import com.lightreporter.Filter.opt.{Operator, ValueExtractor}
import com.lightreporter.Filter.opt.optImpl.ContainInSeqOpt

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class ArrayExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "in"  => new ContainInSeqOpt[T](operatorString,value,this)
    }
  }
}
