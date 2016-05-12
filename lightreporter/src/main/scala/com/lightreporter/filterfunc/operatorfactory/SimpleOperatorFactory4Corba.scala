package com.lightreporter.filterfunc.operatorfactory

import com.lightreporter.filterfunc.extractor.AnyData
import com.lightreporter.filterfunc.opt.another.{OperatorComparable, OperatorComparetor}
import com.lightreporter.filterfunc.opt.{Operator, OperatorEnum}
import com.lightreporter.filterfunc.{OperatorFactory, ValueExtractor}
import org.apache.log4j.Logger
import org.omg.CORBA.TCKind

import scala.collection.mutable

/**
  * Created by y28yang on 5/9/2016.
  */

class SimpleOperatorFactory4Corba extends OperatorFactory[AnyData] {
  val log = Logger.getLogger(classOf[SimpleOperatorFactory4Corba])
  var maps = new mutable.HashMap[String, ValueExtractor[AnyData]]()

  def add(name: String, valueSelector: ValueExtractor[AnyData]) = {
    maps += name -> valueSelector
  }

  def add(valueSelector: ValueExtractor[AnyData]) = {
    val name = valueSelector.getKey()
    maps += name -> valueSelector
  }

  override def getExtractor(name: String): ValueExtractor[AnyData] = this.get(name)

  override def getOperator(name: String, optEnum: OperatorEnum.Value, value: String): Operator[AnyData] = {
    val selector = getExtractor(name)
    val operator = selector.createOperator(optEnum.toString, value)
    operator
  }


  def get(name: String) = {
    val option = maps.get(name.trim)
    if (option.isEmpty) {
      throw new UnsupportedOperationException(s"can't find value selector from:{$name}.")
    }
    option.get
  }
}

class AnyDataExtractor extends ValueExtractor[AnyData] {
  override def getKey(): String = "a"

  override def createOperator(operatorString: String, value: String): Operator[AnyData] = ???

  override def getVal(name: AnyData): Any = name.a
}

class AnyDataOperator(optName: String, value: String, val valueSelector: AnyDataExtractor) extends Operator[AnyData](optName, value) {

  val operatorEnum = OperatorEnum.withName(optName)

  override def isPass(msg: AnyData): Boolean = {
    val theAny = valueSelector.getVal(msg).asInstanceOf[org.omg.CORBA.Any]
    val theAnyKind = theAny.`type`().kind().value() match {
      case TCKind._tk_long => {
        val left = theAny.extract_long()
        val comparator = OperatorComparetor.intOpt.get(operatorEnum)
        val right=value.toDouble.toInt
        comparator(right,left)
      }
    }
  }


}
