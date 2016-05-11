package com.lightreporter.Filter

import com.lightreporter.Filter.opt.{Operator, ValueGetter}
import org.apache.log4j.Logger

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */

class ValueExtractorMap[T] extends ValueOperatorFactory[T]{
  val log=Logger.getLogger(classOf[ValueExtractorMap[T]])

  var maps=new mutable.HashMap[String,ValueGetter[T]]()

  def add(name:String,valueSelector: ValueGetter[T])={
    maps+=name->valueSelector
  }


  def getSelector(name: String): ValueGetter[T] = {
    this.get(name)
  }

  def getOperator(name: String,optEnum: OperatorEnum.Value, value:String)={
    val selector=getSelector(name)
    val operator = selector.createOperator(optEnum.toString, value)
    operator
  }

  def get(name:String)={
    val option=maps.get(name.trim)
    if(option.isEmpty){
      throw new UnsupportedOperationException(s"can't find value selector from:{$name}.")
    }
    option.get
  }




}
