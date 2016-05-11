package com.lightreporter.Filter.opt

import com.lightreporter.Filter.OperatorEnum.Equator
import com.lightreporter.Filter.basictype.BasicFilter
import com.lightreporter.Filter.opt.optImpl._

/**
  * Created by y28yang on 5/9/2016.
  */
trait ValueGetter[T] {

  def getKey():String

  def getVal(name:T):Any

  def createOperator(operatorString:String, value:String):Operator[T]
}

abstract class StringValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "~" => new SubStringOpt[T](operatorString,value,this)
      case _   => new StringOpt[T](operatorString,value,this)
    }
  }
}
abstract class BoolValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "=="  => new BooleanOpt[T](operatorString,value,this)
      case "!="  => new BooleanOpt[T](operatorString,value,this)
    }
  }
}

abstract class IntValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new IntOpt[T](operatorString,value,this)
    }
  }
}

abstract class ShortValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new ShortOpt[T](operatorString,value,this)
    }
  }
}

abstract class FloatValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new FloatOpt[T](operatorString,value,this)
    }
  }
}

abstract class LongValueGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case _  => new LongOpt[T](operatorString,value,this)
    }
  }
}

abstract class ArrayGetter[T] extends ValueGetter[T]{

  override def createOperator(operatorString: String, value: String): Operator[T] = {
    operatorString match {
      case "in"  => new ContainInSeqOpt[T](operatorString,value,this)
    }
  }
}


