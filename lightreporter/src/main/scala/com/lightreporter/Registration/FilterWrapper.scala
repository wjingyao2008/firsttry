package com.lightreporter.Registration

/**
  * Created by y28yang on 5/4/2016.
  */
class FilterWrapper[T](@volatile var filter: Filter[T]=new DefaultFilter[T]()) {

}
class DefaultFilter[T] extends Filter[T]{
  override def isPass(msg: T): Boolean = true
}


