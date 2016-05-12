package com.lightreporter.Filter.extractor

import com.lightreporter.Filter.opt.{Operator, ValueExtractor}
import com.lightreporter.Filter.opt.optImpl.{StringOpt, SubStringOpt}

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
