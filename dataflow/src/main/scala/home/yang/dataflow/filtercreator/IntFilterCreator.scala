package home.yang.dataflow.filtercreator

import home.yang.dataflow.filter.{BooleanFilter, IntFilter}
import home.yang.dataflow.{Filter, FilterCreator}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class IntFilterCreator extends FilterCreator {
  override def create(key: String, value: String, func: String): Filter[Int] = {
    val cvtVal=value.toInt
    val isPass=FilterFunc.passFun(func,cvtVal)
    new IntFilter(key,isPass)
  }
}
