package com.lightreporter.Filter

/**
  * Created by y28yang on 5/4/2016.
  */
class DefaultFilter[T] extends Filter[T]{
  override def isPass(msg: T): Boolean = true
}
