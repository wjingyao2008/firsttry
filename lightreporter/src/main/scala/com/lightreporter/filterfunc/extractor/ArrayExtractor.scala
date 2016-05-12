package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import com.lightreporter.filterfunc.opt.optImpl.ContainInSeqOpt

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
