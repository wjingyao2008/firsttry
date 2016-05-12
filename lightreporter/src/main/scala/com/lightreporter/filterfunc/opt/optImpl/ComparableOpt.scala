package com.lightreporter.filterfunc.opt.optImpl

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.opt.Operator

/**
  * Created by y28yang on 5/10/2016.
  */
abstract class ComparableOpt[T,U](optName:String,value:String)  extends Operator[T](optName,value){

  val comparator=getCompareFunc(optName)

  def getCompareFunc(equator:String)={

    val isPass:(Comparable[U],U)=>Boolean= equator match {
      case "=="=> (t1, t2)=>t1.compareTo(t2)==0
      case "!="=> (t1, t2)=>t1.compareTo(t2)!=0
      case ">=" => (t1, t2)=>t1.compareTo(t2)<=0
      case "<=" => (t1, t2)=>t1.compareTo(t2)>=0
      case "<" => (t1, t2)=>t1.compareTo(t2)>0
      case ">" => (t1, t2)=>t1.compareTo(t2)<0
    }
    isPass
  }
}

