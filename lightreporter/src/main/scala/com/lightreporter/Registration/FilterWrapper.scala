package com.lightreporter.Registration

import com.lightreporter.Filter.{DefaultFilter, Filter}

/**
  * Created by y28yang on 5/4/2016.
  */
class FilterWrapper[T](@volatile var filter: Filter[T]=new DefaultFilter[T]()) {

}



