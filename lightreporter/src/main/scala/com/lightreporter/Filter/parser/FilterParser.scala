package com.lightreporter.Filter.parser

import com.lightreporter.Filter._
import com.lightreporter.Filter.opt.ValueGetter
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

/**
  * Created by y28yang on 5/10/2016.
  */
class FilterParser[T](val valueExtractorMap: ValueExtractorMap[T]) {

  val log=Logger.getLogger(classOf[FilterParser[T]])

  def getSelector(name: String): ValueGetter[T] = {
    valueExtractorMap.get(name)
  }


  def readOneOperator(expression: String)= {
    val splits = splitOneOperator(expression)
    val name = splits._1(0)
    val value = splits._1(1)
    tryToCreatOperator(splits._2, name, value)
  }


  def tryToCreatOperator(operatorEnumVal: OperatorEnum.Value, first: String, last: String):Filter[T]= {
    log.debug(s"get name:$first,value:$last,with operator:$operatorEnumVal")
    if (isName(first) && (isValue(last))) {
      createOpt(operatorEnumVal, first, last)
    } else if (isName(last) && (isValue(first))) {
      val reversedEnumVal=OperatorEnum.reverse(operatorEnumVal)
      createOpt(reversedEnumVal, last, first)
    } else throw new UnsupportedOperationException(s"can't decide the name and value from:$first $last")
  }

  def createOpt(optEnum: OperatorEnum.Value, name: String, value: String)= {
    val plainName = name.replace("$", "")
    val selector = getSelector(plainName)
    val plainValue = getPlainVal(value)
    val operator = selector.createOperator(optEnum.toString, plainValue)
    operator
  }

  def getPlainVal(a: String) = {
    if (a.startsWith("'") && a.endsWith("'")) {
      a.substring(1, a.length - 1)
    } else a
  }

  def splitOneOperator(exp: String): (Array[String], OperatorEnum.Value) = {
    for (spliter <- OperatorEnum.values) {
      val arrayStr = exp.split(spliter.toString).map(StringUtils.trimToEmpty(_)).filter(StringUtils.isNotBlank(_))
      if (arrayStr.size == 2)
        return (arrayStr, spliter)
    }
    throw new UnsupportedOperationException(s"can not parse $exp")
  }

  def read(expression: String): Filter[T] = {
    readOneOperator(expression)
  }

  def process(expression: String): Filter[T] = {
    val basicFilter = readOneOperator(expression)
    new SimpleFilter[T]()
  }


  def isName(a: String) = a.startsWith("$")||(!StringUtils.isNumeric(a))

  def isValue(a: String) = (a.startsWith("'") && a.endsWith("'")) | StringUtils.isNumeric(a) | isFload(a) | isDouble(a)

  def isFload(a: String) = {
    var isFload = false
    try {
      a.toFloat
      isFload = true
    } catch {
      case e: NumberFormatException => isFload = false
    }
    isFload
  }

  def isLong(a: String) = {
    var isLong = false
    try {
      a.toLong
      isLong = true
    } catch {
      case e: NumberFormatException => isLong = false
    }
    isLong
  }


  def isDouble(a: String) = {
    var isDouble = false
    try {
      a.toDouble
      isDouble = true
    } catch {
      case e: NumberFormatException => isDouble = false
    }
    isDouble
  }

}
