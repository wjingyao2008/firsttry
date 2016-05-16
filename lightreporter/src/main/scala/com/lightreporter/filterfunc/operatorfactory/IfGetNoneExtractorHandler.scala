package com.lightreporter.filterfunc.operatorfactory

import com.lightreporter.filterfunc.ValueExtractor

/**
  * Created by y28yang on 5/16/2016.
  */
trait IfGetNoneExtractorHandler[T] {
  def getNone(name: String): ValueExtractor[T]
}

class DefaultNoneExtractor[T] extends IfGetNoneExtractorHandler[T]{
  override def getNone(name: String): ValueExtractor[T] = {
    throw new UnsupportedOperationException(s"can't find value selector from:{$name}.")
  }
}
