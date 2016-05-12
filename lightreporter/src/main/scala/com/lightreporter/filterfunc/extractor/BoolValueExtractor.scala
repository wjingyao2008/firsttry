package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import com.lightreporter.filterfunc.opt.optImpl.BooleanOpt

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class BoolValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "=="  => new BooleanOpt[T](operatorString,value,this)
      case "!="  => new BooleanOpt[T](operatorString,value,this)
    }
  }
}
