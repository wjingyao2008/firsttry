package com.lightreporter.filterfunc.parser

import com.lightreporter.filterfunc._
import com.lightreporter.filterfunc.opt.OperatorEnum
import com.lightreporter.filterfunc.opt.optImpl.{ContainInSeqOpt, DoubleOpt, StringOpt, SubStringOpt}
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

class FilterParser[T](val operatorFactory: ExtractorLocator[T]) {

  val log = Logger.getLogger(classOf[FilterParser[T]])


  def readOneOperator(expression: String) = {
    val splits = splitOneOperator(expression)
    val name = splits._1(0)
    val value = splits._1(1)
    tryToCreateOperator(splits._2, name, value)
  }


  def tryToCreateOperator(operatorEnumVal: OperatorEnum.Value, first: String, last: String): Filter[T] = {
    if (isName(first) && isValue(last)) {
      createOpt(operatorEnumVal, first, last)
    } else if (isName(last) && isValue(first)) {
      val reversedEnumVal = OperatorEnum.reverse(operatorEnumVal)
      createOpt(reversedEnumVal, last, first)
    } else throw new UnsupportedOperationException(s"can't decide the name and value from:$first $last")
  }

  def isArrayInVal(optEnum: OperatorEnum.Value): Boolean = optEnum == OperatorEnum.in

  def createArrayOperator(plainName: String, optEnum: OperatorEnum.Value, value: String) = {
    val extractor = operatorFactory.getExtractor(plainName)
    val strValue = getStringVal(value)
    new ContainInSeqOpt[T](optEnum.toString,strValue,extractor)
  }

  def createOpt(optEnum: OperatorEnum.Value, name: String, value: String) = {
    log.debug(s"get name:$name:$value,with operator:$optEnum")
    val plainName = name.replace("$", "")
    if (isArrayInVal(optEnum)) {
      createArrayOperator(plainName, optEnum, value)
    } else if (isStringVal(value)) {
      createStringOperator(plainName, optEnum, value)
    } else if (isDouble(value)) {
      createDoubleOperator(plainName, optEnum, value)
    } else throw new UnsupportedOperationException(s"can't create operator with name:$name,value:$value,with operator:$optEnum")
  }


  def createStringOperator(name: String, optEnum: OperatorEnum.Value, value: String) = {
    val strValue = getStringVal(value)
    val extractor = operatorFactory.getExtractor(name)
    optEnum match {
      case OperatorEnum.~ => new SubStringOpt[T](optEnum.toString, strValue, extractor)
      case _ => new StringOpt[T](optEnum.toString, strValue, extractor)
    }
  }

  def createDoubleOperator(name: String, optEnum: OperatorEnum.Value, value: String) = {
    val extractor = operatorFactory.getExtractor(name)
    optEnum match {
      case OperatorEnum.~ => new SubStringOpt[T](optEnum.toString, value, extractor)
      case _ => new DoubleOpt[T](optEnum.toString, value, extractor)
    }
  }

  def isStringVal(a: String) = a.startsWith("'") && a.endsWith("'")

  def getStringVal(a: String) = a.substring(1, a.length - 1)

  def getNumberVal(a: String) = a.toDouble

  def splitOneOperator(exp: String): (Array[String], OperatorEnum.Value) = {
    for (operator <- OperatorEnum.values) {
      val arrayStr = exp.split(operator.toString).map(it => StringUtils.trimToEmpty(it))
        .filter(it => StringUtils.isNotBlank(it))
      if (arrayStr.length == 2)
        return (arrayStr, operator)
    }
    throw new UnsupportedOperationException(s"can not parse $exp")
  }

  def read(expression: String): Filter[T] = {
    readOneOperator(expression)
  }


  def isName(a: String) = a.startsWith("$") || (!StringUtils.isNumeric(a))

  def isValue(a: String) = isStringVal(a) | isDouble(a)


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
