package com.lightreporter.filterfunc.parser

import com.lightreporter.filterfunc.{DefaultAllPassFilter, Filter}

/**
  * Created by y28yang on 5/11/2016.
  */
abstract class FilterTree[T](var left:Filter[T],var right:Filter[T]) extends Filter[T]{

}

class AndFilter[T](left:Filter[T],
                   right:Filter[T]) extends FilterTree[T](left,right){
  override def isPass(msg: T): Boolean = {
    left.isPass(msg)&&right.isPass(msg)
  }
}


class OrFilter[T](left:Filter[T],right:Filter[T]) extends FilterTree[T](left,right){
  override def isPass(msg: T): Boolean = {
    left.isPass(msg)||right.isPass(msg)
  }
}