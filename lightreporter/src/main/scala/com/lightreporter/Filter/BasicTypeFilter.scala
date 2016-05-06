package com.lightreporter.Filter

import java.util.Comparator

/**
  * Created by y28yang on 5/4/2016.
  */
class BasicTypeFilter[T](val value:Comparable[T],val repl:String) extends Filter[T]{

  val testPass=getCompare(repl)


  override def isPass(msg: T): Boolean = {

    testPass(value,msg)
  }

  def getCompare(repl:String)={
    val isPass:(Comparable[T],T)=>Boolean= repl match {
      case "==" => (t1,t2)=>t1.compareTo(t2)==0
      case "!=" => (t1,t2)=>t1.compareTo(t2)!=0
      case ">=" => (t1,t2)=>t1.compareTo(t2)<=0
      case "<=" => (t1,t2)=>t1.compareTo(t2)>=0
      case "<" => (t1,t2)=>t1.compareTo(t2)>0
      case ">" => (t1,t2)=>t1.compareTo(t2)<0
    }
    isPass
  }


}
