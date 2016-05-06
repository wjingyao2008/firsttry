package com.lightreporter.Filter

/**
  * Created by y28yang on 5/5/2016.
  */
class FieldSelectorFilter[T,U](val field: Filter[U],val valueSelector:(T)=>U) extends SimpleFilter[T]{
  protected override def selfPass(msg: T): Boolean = {
    val fieldValue=valueSelector(msg)
    field.isPass(fieldValue)
  }

  def this(value:Comparable[U],repl:String,valueSelector:(T)=>U)=this(new BasicTypeFilter[U](value,repl),valueSelector)



}
