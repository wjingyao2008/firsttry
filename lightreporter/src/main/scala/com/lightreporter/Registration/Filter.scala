package com.lightreporter.Registration

/**
  * Created by y28yang on 5/4/2016.
  */
trait Filter[T] {
  def isPass(msg:T):Boolean
}


