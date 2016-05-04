package com.lightreporter.Filter

import scala.collection.mutable.ListBuffer

/**
  * Created by y28yang on 5/4/2016.
  */
abstract class SimpleFilter[T](var branchOfNext:Filter[T]=new DefaultFilter[T]) extends Filter[T]{

  val branchOfOR=new ListBuffer[SimpleFilter[T]]()


  def addToBranch(filter:SimpleFilter[T])={
    branchOfOR+=filter
  }

  override def isPass(msg: T): Boolean = {
    currentBranchPass(msg)||branchOfORHasPass(msg)
  }

  def currentBranchPass(msg: T):Boolean= selfPass(msg) && branchOfNext.isPass(msg)

  def branchOfORHasPass(msg: T):Boolean={
     for(filter<-branchOfOR){
       if(filter.isPass(msg))
         return true
     }
     false
  }

  def selfPass(msg:T):Boolean
}

