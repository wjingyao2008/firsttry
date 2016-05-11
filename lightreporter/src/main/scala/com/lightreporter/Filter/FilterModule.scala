package com.lightreporter.Filter

import com.lightreporter.Filter.parser.{AndFilter, FilterParser, FilterTree, OrFilter}
import org.apache.log4j.Logger
import org.jacorb.notification.filter.etcl._

/**
  * Created by y28yang on 5/9/2016.
  */
class FilterModule[T](val valueExtractorMap:ValueOperatorFactory[T]) {

  val log=Logger.getLogger(classOf[FilterParser[T]])
  val parser=new FilterParser[T](valueExtractorMap)

  def andOperation(node: AndOperator)={
    val left=processNode(node.left())
    val right=processNode(node.right())
    val andFilter=new AndFilter[T](left,right)
    andFilter
  }

  def orOperation(node: OrOperator) = {
    val left=processNode(node.left())
    val right=processNode(node.right())
    val orFilter=new OrFilter[T](left,right)
    orFilter
  }

  def getNameAndRight(node: BinaryOperator) = {
    var left = node.left()
    var right = node.right()
    var operator = convertOperator(node)
    if ((isName(left) && isName(right)) || (isValue(left) && isValue(right))) {
      throw new UnsupportedOperationException("can't decide left and right")
    } else if (isName(right)) {
      val temp = left
      left = right
      right = temp
      operator=OperatorEnum.reverse(operator)
    }
    (left, right,operator)
  }

  def makeValue(node: AbstractTCLNode):String = {
    if(isMinusOrPlus(node)) {
      val down= node.left()
      if (down.hasNextSibling) {
        throw new UnsupportedOperationException(node.toStringTree)
      }
      else {
        var valueStr= down.toString
        if (node.isInstanceOf[MinusOperator]) {
          valueStr= "-" + valueStr
        }
        return valueStr
      }
    } else
    {
      return node.toString
    }
  }

  def binOperation(node: BinaryOperator):Filter[T] = {

    log.debug(s"received binary tree:${node.toStringTree}" )
    var nameAndValue= getNameAndRight(node)
    val name=makeName(nameAndValue._1)
    val value = makeValue(nameAndValue._2)
    val operator=nameAndValue._3
    log.debug(s"extract name:$name,opt:$operator,value:$value")
    parser.tryToCreatOperator(operator,name,value)
  }

  def makeName(node:AbstractTCLNode)={
    var noParenth=node.toStringTree.replace("(","").replace(")","").trim
    if(noParenth.startsWith(".")){
      noParenth=noParenth.replaceFirst(".","").trim
    }
    noParenth
  }


  def convertOperator(node: BinaryOperator): OperatorEnum.Value = {
    node match {
      case node: EqOperator => OperatorEnum.==
      case node: GteOperator => OperatorEnum.>=
      case node: GtOperator => OperatorEnum.>
      case node: LteOperator => OperatorEnum.<=
      case node: LtOperator => OperatorEnum.<
      case node: NeqOperator => OperatorEnum.!=
      case node: SubstrOperator => OperatorEnum.~
      case node: InOperator => OperatorEnum.in
      case _ => {
        val name = node.getName
        throw new UnsupportedOperationException(name)
      }

    }
  }


  def readString(expression: String) = {
    val root = TCLParser.parse(expression)
    try {
      processNode(root)
    } catch {
      case ex: UnsupportedOperationException => {
        throw new UnsupportedOperationException(s"can't parse $expression on $expression",ex)
      }
    }
  }


  def processNode(root: AbstractTCLNode): Filter[T] = {
    root match {
      case node: BinaryOperator => binOperation(node)
      case node: AndOperator => andOperation(node)
      case node: OrOperator => orOperation(node)
      case _ => throw new UnsupportedOperationException(root.getName)
    }
  }

  protected def isMinusOrPlus(node: AbstractTCLNode): Boolean = {
    return node.isInstanceOf[MinusOperator] || node.isInstanceOf[PlusOperator]
  }

  def isName(node: AbstractTCLNode): Boolean = {
    return node.isInstanceOf[ETCLComponentName] || node.isInstanceOf[RuntimeVariableNode] || node.isInstanceOf[IdentValue]
  }

  def isValue(node: AbstractTCLNode): Boolean = {
    return node.isInstanceOf[DotOperator] || node.isInstanceOf[AssocOperator] || node.isInstanceOf[BoolValue] || node.isInstanceOf[NumberValue] || node.isInstanceOf[StringValue]
  }
}
