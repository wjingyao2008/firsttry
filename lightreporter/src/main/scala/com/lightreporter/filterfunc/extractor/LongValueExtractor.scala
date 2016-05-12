package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import com.lightreporter.filterfunc.opt.optImpl.LongOpt

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class LongValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new LongOpt[T](operatorString,value,this)
    }
  }
}
