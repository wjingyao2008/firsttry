package com.lightreporter.Filter

import com.lightreporter.Filter.opt.ValueGetter

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */
class ValueExtractorMap[T] {

  var maps=new mutable.HashMap[String,ValueGetter[T]]()

  def add(name:String,valueSelector: ValueGetter[T])={
    maps+=name->valueSelector
  }

  def get(name:String)={
    val option=maps.get(name)
    if(option.isEmpty)throw new UnsupportedOperationException(s"can't find value selector from $name")
    option.get
  }


}
