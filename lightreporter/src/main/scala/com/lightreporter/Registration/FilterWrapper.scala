package com.lightreporter.registration

import com.lightreporter.filterfunc.{DefaultAllPassFilter, Filter}

/**
  * Created by y28yang on 5/4/2016.
  */
class FilterWrapper[T](@volatile var filter: Filter[T]=new DefaultAllPassFilter[T]()) {

}



