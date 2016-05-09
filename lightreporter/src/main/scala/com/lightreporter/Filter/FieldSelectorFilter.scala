package com.lightreporter.Filter

import com.lightreporter.Filter.Operator.Equator
import com.lightreporter.Filter.basictype.{BasicFilter, BasicTypeFilter}

/**
  * Created by y28yang on 5/5/2016.
  */
class FieldSelectorFilter[T](val valueSelector:ValueSelector[T], equator: Equator, value:String) extends SimpleFilter[T]{

  val basicFilter=valueSelector.getBasicFilter(equator,value)

  protected override def selfPass(msg: T): Boolean = {
    val fieldValue=valueSelector.getVal(msg)
    basicFilter.isPass(fieldValue)
  }


}
