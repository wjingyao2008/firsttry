package com.lightreporter.Filter.operatorfactory

import com.lightreporter.Filter.opt.ValueExtractor
import com.lightreporter.Filter.{OperatorEnum, OperatorFactory}
import org.apache.log4j.Logger

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */

class SimpleOperatorFactory[T] extends OperatorFactory[T]{
  val log=Logger.getLogger(classOf[SimpleOperatorFactory[T]])

  var maps=new mutable.HashMap[String,ValueExtractor[T]]()

  def add(name:String,valueSelector: ValueExtractor[T])={
    maps+=name->valueSelector
  }


  def getExtractor(name: String): ValueExtractor[T] = {
    this.get(name)
  }

  def getOperator(name: String,optEnum: OperatorEnum.Value, value:String)={
    val selector=getExtractor(name)
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
