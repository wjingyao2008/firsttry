package com.lightreporter.Filter

import com.lightreporter.Filter.Operator.Equator
import com.lightreporter.Filter.basictype.BasicFilter

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueSelector[T] {

  def getVal(name:T):Any

  def getBasicFilter(equator: Equator, value:String):BasicFilter
}
