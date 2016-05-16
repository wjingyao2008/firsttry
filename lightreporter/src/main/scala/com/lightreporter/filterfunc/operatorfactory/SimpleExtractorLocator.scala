package com.lightreporter.filterfunc.operatorfactory

import com.lightreporter.filterfunc.opt.OperatorEnum
import com.lightreporter.filterfunc.{DefaultRuntimeExtractor, ExtractorLocator, ValueExtractor}
import org.apache.log4j.Logger

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */

class SimpleExtractorLocator[T](val ifGetNoneExtractorHandler:IfGetNoneExtractorHandler[T]=new DefaultNoneExtractor[T]) extends ExtractorLocator[T]{
  val log=Logger.getLogger(classOf[SimpleExtractorLocator[T]])

  var maps=new mutable.HashMap[String,ValueExtractor[T]]()

  def add(name:String,valueSelector: ValueExtractor[T])={
    maps+=name->valueSelector
  }
  def add(valueSelector: ValueExtractor[T])={
    val name=valueSelector.getKey()
    maps+=name->valueSelector
  }

  def getExtractor(name: String): ValueExtractor[T] = {
    this.get(name)
  }



  def get(name:String)={
    val option=maps.get(name.trim)
    if(option.isEmpty){
      ifGetNoneExtractorHandler.getNone(name)
    } else option.get
  }



}
