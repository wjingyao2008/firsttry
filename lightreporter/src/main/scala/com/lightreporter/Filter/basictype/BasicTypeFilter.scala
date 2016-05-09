package com.lightreporter.Filter.basictype

import com.lightreporter.Filter.Operator
import com.lightreporter.Filter.Operator.Equator

/**
  * Created by y28yang on 5/4/2016.
  */
class BasicTypeFilter[T](val value:Comparable[T],val equator:Equator) extends BasicFilter{

   val comparator=getCompareFunc(equator)

  def this(value:Comparable[T],repl:String)=this(value,Operator.withName(repl))

  override def isPass(msg: Any): Boolean = {
     val msgTyped=msg.asInstanceOf[T]
     comparator(value,msgTyped)
  }

  def getCompareFunc(equator:Equator)={

    val isPass:(Comparable[T],T)=>Boolean= equator match {
      case Operator.== => (t1, t2)=>t1.compareTo(t2)==0
      case Operator.!= => (t1, t2)=>t1.compareTo(t2)!=0
      case Operator.>= => (t1, t2)=>t1.compareTo(t2)<=0
      case Operator.<= => (t1, t2)=>t1.compareTo(t2)>=0
      case Operator.< => (t1, t2)=>t1.compareTo(t2)>0
      case Operator.> => (t1, t2)=>t1.compareTo(t2)<0
    }
    isPass
  }


}

class StringFilter(equator:Equator,value:String) extends BasicTypeFilter[String](value,equator){

}

class IntegerFilter(equator:Equator,value:String) extends BasicTypeFilter[Integer](Integer.valueOf(value),equator){

}


class BooleanFilter(equator:Equator,value:String) extends
  BasicTypeFilter[java.lang.Boolean](java.lang.Boolean.valueOf(value),equator){

}

class LongFiler(equator:Equator,value:String) extends
  BasicTypeFilter[java.lang.Long](java.lang.Long.valueOf(value),equator){

}

class ShortFiler(equator:Equator,value:String) extends
  BasicTypeFilter[java.lang.Short](java.lang.Short.valueOf(value),equator){

}
