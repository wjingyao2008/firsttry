package com.lightreporter.Filter.opt

import com.lightreporter.Filter.Filter

/**
  * Created by y28yang on 5/10/2016.
  */
abstract class Operator[T](val optName:String, val value:String) extends Filter[T]{

}


