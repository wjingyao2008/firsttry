package home.yang.dataflow.filtercreator

import home.yang.dataflow.filter.DataFilter
import home.yang.dataflow.{Filter, FilterCreator}
import java.util.Date

import home.yang.dataflow.datahold.DateTimeData
/**
  * Created by Administrator on 2016/5/2 0002.
  */
class DateFilterCreator extends FilterCreator {
  override def create(key: String, value: String, func: String): Filter[Date] = {
    val dateVal=DateTimeData.fastParseTime(value)
    val isPass=FilterFunc.passFun[Date](func,dateVal)
    new DataFilter(key,isPass)
  }
}
