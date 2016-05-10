package com.lightreporter.Filter.opt.optImpl

import com.lightreporter.Filter.Filter
import com.lightreporter.Filter.opt.Operator

/**
  * Created by y28yang on 5/10/2016.
  */
class OperatorInverse[T](val operator: Operator[T]) extends Filter[T]{
  override def isPass(msg: T): Boolean = !operator.isPass(msg)
}
