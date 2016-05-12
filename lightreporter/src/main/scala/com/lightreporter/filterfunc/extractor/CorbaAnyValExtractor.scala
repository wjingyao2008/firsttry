package com.lightreporter.filterfunc.extractor

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator
import org.omg.CORBA.{Any, ORB}
/**
  * Created by y28yang on 5/12/2016.
  */
class CorbaAnyValExtractor extends ValueExtractor[Any]{
  override def getKey(): String = ???

  override def createOperator(operatorString: String, value: String): Operator[Any] = ???

  override def getVal(name: Any): Any = ???
}
