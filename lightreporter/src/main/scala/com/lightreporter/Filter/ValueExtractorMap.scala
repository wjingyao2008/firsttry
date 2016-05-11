package com.lightreporter.Filter

import com.lightreporter.Filter.opt.ValueGetter
import org.apache.log4j.Logger

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */
class ValueExtractorMap[T] {
  val log=Logger.getLogger(classOf[ValueExtractorMap[T]])

  var maps=new mutable.HashMap[String,ValueGetter[T]]()

  def add(name:String,valueSelector: ValueGetter[T])={
    maps+=name->valueSelector
  }

  def get(name:String)={
    val option=maps.get(name.trim)
    if(option.isEmpty){

      throw new UnsupportedOperationException(s"can't find value selector from:{$name}.")
    }
    option.get
  }

  def tryWithDot(name:String)={
    val dotArray=name.split(".").map(_.trim).filter(_.isEmpty)
    log.debug(s"try to split the name:$name with dot: ${dotArray.mkString(",")}")
    if(dotArray.size<2) throw new UnsupportedOperationException(s"can't find combined dot value selector:$name")
    val valuseSelector=this.get("."+dotArray.head)
    valuseSelector.
  }


}
