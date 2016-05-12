package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import com.lightreporter.filterfunc.opt.optImpl.{StringOpt, SubStringOpt}

/**
  * Created by y28yang on 5/12/2016.
  */
abstract class StringValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "~" => new SubStringOpt[T](operatorString,value,this)
      case _   => new StringOpt[T](operatorString,value,this)
    }
  }
}
