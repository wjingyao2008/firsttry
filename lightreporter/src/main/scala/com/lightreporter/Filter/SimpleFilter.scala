package com.lightreporter.Filter

import scala.collection.mutable.ListBuffer

/**
  * Created by y28yang on 5/4/2016.
  */
class SimpleFilter[T](var andFilter:Filter[T]=new DefaultAllPassFilter[T]) extends Filter[T]{

  private val branchOfOR=new ListBuffer[Filter[T]]()


  def addOrFilter(filter:Filter[T])={
    branchOfOR+=filter
  }


  override def isPass(msg: T): Boolean = {
    currentBranchPass(msg)||branchOfORHasPass(msg)
  }

  private def currentBranchPass(msg: T):Boolean= selfPass(msg) && andFilter.isPass(msg)

  private def branchOfORHasPass(msg: T):Boolean={
     for(filter<-branchOfOR){
       if(filter.isPass(msg))
         return true
     }
     false
  }

  protected def selfPass(msg:T):Boolean=true
}

