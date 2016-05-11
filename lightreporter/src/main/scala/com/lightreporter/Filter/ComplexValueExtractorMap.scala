package com.lightreporter.Filter

import com.lightreporter.Filter.opt.{ComparableOpt, Operator, ValueGetter}
import org.apache.log4j.Logger

/**
  * Created by y28yang on 5/11/2016.
  */
class ComplexValueExtractorMap[T1, T2](val valueExtractorMap1: ValueOperatorFactory[T1],
                                       val valueExtractorMap2: ValueOperatorFactory[T2]) extends ValueOperatorFactory[T1]{

  val log=Logger.getLogger(classOf[ComplexValueExtractorMap[T1,T2]])


  override def getSelector(name: String): ValueGetter[T1] = valueExtractorMap1.getSelector(name)

  def getComplexOperator(nameArray: Seq[String],optEnum: OperatorEnum.Value, value: String) = {
    val valueGetter1 = valueExtractorMap1.getSelector(nameArray(0))
    val valueGetter2 = valueExtractorMap2.getSelector(nameArray(1))
    new FieldOpt[T1,T2](optEnum.toString,value,valueGetter1,valueGetter2.createOperator(optEnum.toString,value))
  }

  override def getOperator(name: String, optEnum: OperatorEnum.Value, value: String): Operator[T1] = {
     val arrayStr=parseWihDot(name)
    getComplexOperator(arrayStr,optEnum,value)
  }

  def parseWihDot(name:String)={
    val dotArray=name.split(".").map(_.trim).filter(_.isEmpty)
    log.debug(s"try to split the name:$name with dot: ${dotArray.mkString(",")}")
    if(dotArray.size!=2) throw new UnsupportedOperationException(s"can't find combined dot value selector:$name")
    dotArray
  }
}


class FieldOpt[T,Field](optName:String, value:String, fieldGetter: ValueGetter[T],
                        operator:Operator[Field]) extends Operator[T](optName,value){

  override def isPass(msg: T): Boolean = {
    val field=fieldGetter.getVal(msg).asInstanceOf[Field]
    operator.isPass(field)
  }
}