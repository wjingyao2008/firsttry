package home.yang.dataflow.filtercreator

import home.yang.dataflow.{Filter, FilterCreator}
import home.yang.dataflow.filter.{BooleanFilter, StringFilter}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class BooleanFilterCreator extends FilterCreator {
  override def create(key: String, value: String, func: String): Filter[Boolean] = {
    val boolVal=value.toBoolean

    val isPass=FilterFunc.passFun[Boolean](func,boolVal)
    new BooleanFilter(key,isPass)
  }
}
