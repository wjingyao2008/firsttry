package com.lightreporter.Filter.basictype

/**
  * Created by y28yang on 5/9/2016.
  */
trait BasicFilter{
  def isPass(msg:Any):Boolean
}