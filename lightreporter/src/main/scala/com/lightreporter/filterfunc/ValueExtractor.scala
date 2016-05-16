package com.lightreporter.filterfunc

import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueExtractor[T] {

  def getKey():String

  def getVal(msg:T):Any

}















