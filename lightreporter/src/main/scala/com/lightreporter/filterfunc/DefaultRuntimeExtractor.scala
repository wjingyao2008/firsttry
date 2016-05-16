package com.lightreporter.filterfunc

/**
  * Created by y28yang on 5/16/2016.
  */
trait DefaultRuntimeExtractor[T] extends ValueExtractor[T]{
  def setDefaultRuntimeName(name:String)
  def getDefaultRuntimeName():String
}
