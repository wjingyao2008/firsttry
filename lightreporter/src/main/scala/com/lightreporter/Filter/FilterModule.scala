package com.lightreporter.Filter

import antlr.collections.AST
import com.lightreporter.Filter.TypeEnum.TypeEnum
import org.jacorb.notification.filter.etcl._

/**
  * Created by y28yang on 5/9/2016.
  */
abstract class FilterModule[T](val valueSelector:ValueSelector[T]) {


  def andOperation(node: AndOperator) = {

  }

  def orOperation(node: OrOperator) = {

  }

//  def getValue(right: AST) =???

  def getName(left: AST) = ???

  def getSelector[T](name: String) = {

  }

  def binOperation(node: BinaryOperator) = {
    val left = node.getFirstChild
    val right = node.getFirstChild.getNextSibling
    val operator=convertOperator(node)
    val name=getName(left)
//    val value=getValue(right)
    val fieldSelector=getSelector(name)
//   new FieldSelectorFilter(_,operator,value)
  }



//  def createFilter(theType:TypeEnum,name:String,value:String,operator:Operator.Value)={
//    theType match {
//      case TypeEnum.string=> new FieldSelectorFilter[T,String](,operator,value)
//    }
//  }

  def convertOperator(node: BinaryOperator): Operator.Value = {
    node match {
      case node: EqOperator => Operator.==
      case node: GteOperator => Operator.>=
      case node: GtOperator => Operator.>
      case node: LteOperator => Operator.<=
      case node: LtOperator => Operator.<
      case node: NeqOperator => Operator.!=
      case _ => {
        val name = node.getName
        throw new UnsupportedOperationException(name)
      }

    }
  }

  def operatorConvert(node: AbstractTCLNode)
  def readString(expression: String) = {
    val root = TCLParser.parse(expression)
    try {
      processNode(root)
    } catch {
      case ex: UnsupportedOperationException => {
        val exMsg = ex.getMessage
        throw new UnsupportedOperationException(s"can't parse $expression on $exMsg")
      }
    }
  }


  def processNode(root: AbstractTCLNode): Any = {
    root match {
      case node: BinaryOperator => binOperation(node)
      case node: AndOperator => andOperation(node)
      case node: OrOperator => orOperation(node)
      case _ => throw new UnsupportedOperationException(root.getName)
    }
  }

  def convertToOperator(optStr: String) = {
//    optStr matches {
//      case "AndOperator" => _
//    }
  }
}
