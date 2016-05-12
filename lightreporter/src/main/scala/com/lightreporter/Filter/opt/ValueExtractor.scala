package com.lightreporter.Filter.opt

import com.lightreporter.Filter.OperatorEnum.Equator
import com.lightreporter.Filter.basictype.BasicFilter
import com.lightreporter.Filter.opt.optImpl._

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueExtractor[T] {

  def getKey():String

  def getVal(name:T):Any

  def createOperator(operatorString:String, value:String):Operator[T]
}

abstract class StringValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "~" => new SubStringOpt[T](operatorString,value,this)
      case _   => new StringOpt[T](operatorString,value,this)
    }
  }
}
abstract class BoolValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "=="  => new BooleanOpt[T](operatorString,value,this)
      case "!="  => new BooleanOpt[T](operatorString,value,this)
    }
  }
}

abstract class IntValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new IntOpt[T](operatorString,value,this)
    }
  }
}

abstract class ShortValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new ShortOpt[T](operatorString,value,this)
    }
  }
}

abstract class FloatValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new FloatOpt[T](operatorString,value,this)
    }
  }
}

abstract class LongValueExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new LongOpt[T](operatorString,value,this)
    }
  }
}

abstract class ArrayExtractor[T] extends ValueExtractor[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "in"  => new ContainInSeqOpt[T](operatorString,value,this)
    }
  }
}


