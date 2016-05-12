package com.lightreporter.filterfunc.parser

import com.lightreporter.filterfunc._
import com.lightreporter.filterfunc.opt.OperatorEnum
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

class FilterParserWithCorba[T](val operatorFactory: OperatorFactory[T]) {

  val log = Logger.getLogger(classOf[FilterParserWithCorba[T]])


  def readOneOperator(expression: String) = {
    val splits = splitOneOperator(expression)
    val name = splits._1(0)
    val value = splits._1(1)
    tryToCreateOperator(splits._2, name, value)
  }


  def tryToCreateOperator(operatorEnumVal: OperatorEnum.Value, first: String, last: String): Filter[T] = {
    log.debug(s"get name:$first,value:$last,with operator:$operatorEnumVal")
    if (isName(first) && isValue(last)) {
      createOpt(operatorEnumVal, first, last)
    } else if (isName(last) && isValue(first)) {
      val reversedEnumVal = OperatorEnum.reverse(operatorEnumVal)
      createOpt(reversedEnumVal, last, first)
    } else throw new UnsupportedOperationException(s"can't decide the name and value from:$first $last")
  }

  def createOpt(optEnum: OperatorEnum.Value, name: String, value: String) = {
    operatorFactory.getOperator(name, optEnum, value)
  }

  def getPlainVal(a: String) = {
    if (a.startsWith("'") && a.endsWith("'")) {
      a.substring(1, a.length - 1)
    } else a
  }

  def splitOneOperator(exp: String): (Array[String], OperatorEnum.Value) = {
    for (operator <- OperatorEnum.values) {
      val arrayStr = exp.split(operator.toString).map(it=>StringUtils.trimToEmpty(it))
                        .filter(it=>StringUtils.isNotBlank(it))
      if (arrayStr.length == 2)
        return (arrayStr, operator)
    }
    throw new UnsupportedOperationException(s"can not parse $exp")
  }

  def read(expression: String): Filter[T] = {
    readOneOperator(expression)
  }



  def isName(a: String) = a.startsWith("$") || (!StringUtils.isNumeric(a))

  def isValue(a: String) = (a.startsWith("'") && a.endsWith("'")) | StringUtils.isNumeric(a) | isFloat(a) | isDouble(a)

  def isFloat(a: String) = {
    var isFloat = false
    try {
      a.toFloat
      isFloat = true
    } catch {
      case e: NumberFormatException => isFloat = false
    }
    isFloat
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
