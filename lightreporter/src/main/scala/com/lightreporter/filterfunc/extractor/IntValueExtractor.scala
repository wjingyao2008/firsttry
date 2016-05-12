package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import com.lightreporter.filterfunc.opt.optImpl.IntOpt

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class IntValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new IntOpt[T](operatorString,value,this)
    }
  }
}
