package com.lightreporter.filterfunc

/**
  * Created by y28yang on 5/4/2016.
  */
class DefaultAllPassFilter[T] extends Filter[T]{
  override def isPass(msg: T): Boolean = true
}
