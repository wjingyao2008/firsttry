package com.lightreporter.Filter

import com.lightreporter.Filter.opt.{ComparableOpt, Operator, ValueGetter}

/**
  * Created by y28yang on 5/11/2016.
  */
class ComplexValueExtractorMap[T1, T2](val valueExtraorMap1: ValueExtractorMap[T1],
                                       val valueExtraorMap2: ValueExtractorMap[T2]) {
  def get(nameArray: Seq[String]) = {
    val valueGetter1 = valueExtraorMap1.get(nameArray(0))
    val valueGetter2 = valueExtraorMap2.get(nameArray(1))
    new FieldOpt[T1,T2](optName,value,valueGetter1,valueGetter2.createOperator())
  }
}

abstract class FieldValueGetter[T1] extends ValueGetter[T1] {
  override def getKey(): String = ???

  override def createOperator(operatorString: String, value: String): Operator[T1] = ???

  override def getVal(name: T1): Any = ???
}

class FieldOpt[T,Field](optName:String, value:String, fieldGetter: ValueGetter[T],
                        operator:Operator[Field]) extends Operator[T](optName,value){

  override def isPass(msg: T): Boolean = {
    val field=fieldGetter.getVal(msg).asInstanceOf[Field]
    operator.isPass(field)
  }
}