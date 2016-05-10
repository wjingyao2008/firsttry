package com.lightreporter.Filter

import com.lightreporter.Filter.OperatorEnum.Equator
import com.lightreporter.Filter.basictype.BasicFilter

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueSelector[T] {

  def getVal(name:T):Any

  def createBasicTypeFilter(equator: Equator, value:String):BasicFilter
}
