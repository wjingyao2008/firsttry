package com.lightreporter.Filter

import com.lightreporter.Filter.Operator.Equator


/**
  * Created by y28yang on 5/9/2016.
  */
class ComplexFilterCreator[DataType,ComVal] {

  var stackLeftBrace=new scala.collection.mutable.Stack[(Char,Int)]()
  var stackRightBrace=new scala.collection.mutable.Queue[(Char,Int)]()

  def int(input:String)={
    val indexedSeq=input.zipWithIndex
    indexedSeq.foreach(item=>{
      if(item._1.equals("("))
        stackLeftBrace.push(item)
      else if(item._1.equals(")"))
        stackRightBrace.enqueue(item)
    } )

    if(stackLeftBrace.size!=stackRightBrace.size) throw new IllegalArgumentException("the left brace number is not same with right,can not parse")

    while(stackLeftBrace.nonEmpty){
      parseOneSegment(input)
    }

  }

  def parseOneSeqWithOutBrace(singleStr:String)={
    val andIndex=singleStr.indexOf("and")
    val orIndex=singleStr.indexOf("or")

  }


  def parseOneSegment(input:String)={
    val left=stackLeftBrace.pop()
    val right=stackRightBrace.dequeue()

    val segment=input.substring(left._2+1,right._2)

  }

}
