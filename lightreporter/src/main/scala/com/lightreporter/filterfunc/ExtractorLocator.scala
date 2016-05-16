package com.lightreporter.filterfunc

import com.lightreporter.filterfunc.opt.{Operator, OperatorEnum}

/**
  * Created by y28yang on 5/12/2016.
  */
trait ExtractorLocator[T] {

  def getExtractor(name: String):ValueExtractor[T]



}
