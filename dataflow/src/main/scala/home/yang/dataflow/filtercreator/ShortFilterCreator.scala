package home.yang.dataflow.filtercreator

import home.yang.dataflow.filter.{IntFilter, ShortFilter}
import home.yang.dataflow.{Filter, FilterCreator}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class ShortFilterCreator extends FilterCreator {
  override def create(key: String, value: String, func: String): Filter[Short] = {
    val cvtVal=value.toShort
    val isPass=FilterFunc.passFun(func,cvtVal)
    new ShortFilter(key,isPass)
  }
}
