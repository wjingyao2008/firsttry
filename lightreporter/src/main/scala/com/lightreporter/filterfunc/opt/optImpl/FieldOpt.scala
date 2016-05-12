package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/12/2016.
  */
class FieldOpt[T, Field](optName: String, value: String, fieldGetter: ValueExtractor[T],
                         operator: Operator[Field]) extends Operator[T](optName, value) {

  override def isPass(msg: T): Boolean = {
    val field = fieldGetter.getVal(msg).asInstanceOf[Field]
    operator.isPass(field)
  }
}
