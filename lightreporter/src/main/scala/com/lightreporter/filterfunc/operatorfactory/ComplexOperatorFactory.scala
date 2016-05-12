package com.lightreporter.filterfunc.operatorfactory

import com.lightreporter.filterfunc.opt.optImpl.FieldOpt
import com.lightreporter.filterfunc.opt.{Operator, OperatorEnum}
import com.lightreporter.filterfunc.{OperatorFactory, ValueExtractor}
import org.apache.log4j.Logger

class ComplexOperatorFactory[T1, T2](val valueExtractorMap1: OperatorFactory[T1],
                                     val valueExtractorMap2: OperatorFactory[T2]) extends OperatorFactory[T1] {

  val log = Logger.getLogger(classOf[ComplexOperatorFactory[T1, T2]])


  override def getExtractor(name: String): ValueExtractor[T1] = valueExtractorMap1.getExtractor(name)

  def getComplexOperator(nameArray: Seq[String], optEnum: OperatorEnum.Value, value: String) = {
    val valueGetter1 = valueExtractorMap1.getExtractor(nameArray(0))
    if (nameArray.size == 1) {
      valueGetter1.createOperator(optEnum.toString, value)
    } else if(nameArray.size == 2) {
      val valueGetter2 = valueExtractorMap2.getExtractor(nameArray(1))
      new FieldOpt[T1, T2](optEnum.toString, value, valueGetter1, valueGetter2.createOperator(optEnum.toString, value))
    } else {
      val outValue=nameArray.mkString(",")
      throw new UnsupportedOperationException(s"can't find combined dot value selector array: $outValue")
    }
  }

  override def getOperator(name: String, optEnum: OperatorEnum.Value, value: String): Operator[T1] = {
    val arrayStr = parseWihDot(name)
    getComplexOperator(arrayStr, optEnum, value)
  }

  def parseWihDot(name: String) = {
    log.debug(s"input:$name")
    val dotArray = name.split('.').map(_.trim).filter(_.nonEmpty)
    val output = dotArray.mkString(",")
    log.debug(s"try to split the name:$name with dot: $output")
    dotArray
  }

}


