package com.lightreporter.filterfunc.opt.another

import com.lightreporter.filterfunc.opt.{Operator, OperatorEnum}

import scala.collection.mutable

/**
  * Created by y28yang on 5/12/2016.
  */
object OperatorComparetor{
   val longOpt=new OperatorComparable[Long]
   val intOpt=new OperatorComparable[Int]
   val shortOpt=new OperatorComparable[Short]
   val floatOpt=new OperatorComparable[Float]
   val boolOpt=new OperatorComparable[Boolean]

}

class OperatorComparable[T]{
  val map=new java.util.HashMap[OperatorEnum.Value,(Comparable[T],T)=>Boolean]()
  map.put(OperatorEnum.==,(t1, t2)=>t1.compareTo(t2)==0)
  map.put(OperatorEnum.!=,(t1, t2)=>t1.compareTo(t2)!=0)
  map.put(OperatorEnum.>=,(t1, t2)=>t1.compareTo(t2)<=0)
  map.put(OperatorEnum.<=,(t1, t2)=>t1.compareTo(t2)>=0)
  map.put(OperatorEnum.<,(t1, t2)=>t1.compareTo(t2)>0)
  map.put(OperatorEnum.>,(t1, t2)=>t1.compareTo(t2)<0)

  def get(key:OperatorEnum.Value)={
    map.get(key)
  }
}