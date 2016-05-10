package com.lightreporter.Filter

import antlr.collections.AST
import org.jacorb.notification.filter.etcl._

/**
  * Created by y28yang on 5/9/2016.
  */
class FilterModule[T](val valueExtractorMap:ValueExtractorMap[T]) {

//
//  def andOperation(node: AndOperator):SimpleFilter[T]= {
//    val left=processNode(node.left())
//    val right=processNode(node.right())
//    val simpleFilter=new SimpleFilter[T]()
//    simpleFilter.andFilter=left
//    left.andFilter=right
//    org.jacorb.notification.filter.AbstractFilter
//    simpleFilter
//  }
//
//  def orOperation(node: OrOperator):SimpleFilter[T] = {
//    val left=processNode(node.left())
//    val right=processNode(node.right())
//    val simpleFilter=new SimpleFilter[T]()
//    simpleFilter.addOrFilter(left)
//    simpleFilter.addOrFilter(right)
//    simpleFilter
//  }
//
//  def getValue(right: AST): String = {
//    right.getFirstChild.toString
//  }
//
//  def getName(left: AST) = {
//    left.toString
//  }
//
//  def getSelector(name: String): ValueSelector[T] = {
//    valueExtractorMap.get(name)
//  }
//
//  def binOperation(node: BinaryOperator):SimpleFilter[T] = {
//    val name = node.left().asInstanceOf[IdentValue].getIdentifier
//    val value = node.right().asInstanceOf[NumberValue].getNumber.toString
//    val operator = convertOperator(node)
//    val fieldSelector = getSelector(name)
//    new FieldSelectorFilter[T](fieldSelector, operator, value)
//  }
//
//
//  def convertOperator(node: BinaryOperator): Operator.Value = {
//    node match {
//      case node: EqOperator => Operator.==
//      case node: GteOperator => Operator.>=
//      case node: GtOperator => Operator.>
//      case node: LteOperator => Operator.<=
//      case node: LtOperator => Operator.<
//      case node: NeqOperator => Operator.!=
//      case _ => {
//        val name = node.getName
//        throw new UnsupportedOperationException(name)
//      }
//
//    }
//  }
//
//  def operatorConvert(node: AbstractTCLNode)={
//
//  }
//
//  def readString(expression: String) = {
//    val root = TCLParser.parse(expression)
//    val simpleFilter=new SimpleFilter[T]()
//    try {
//      processNode(root)
//      println("_")
//    } catch {
//      case ex: UnsupportedOperationException => {
//        val exMsg = ex.getMessage
//        throw new UnsupportedOperationException(s"can't parse $expression on $exMsg")
//      }
//    }
//  }
//
//
//  def processNode(root: AbstractTCLNode): SimpleFilter[T] = {
//    root match {
//      case node: BinaryOperator => binOperation(node)
//      case node: AndOperator => andOperation(node)
//      case node: OrOperator => orOperation(node)
//      case _ => throw new UnsupportedOperationException(root.getName)
//    }
//  }
//
//  def convertToOperator(optStr: String) = {
//    //    optStr matches {
//    //      case "AndOperator" => _
//    //    }
//  }
}
