package home.yang.dataflow.filter

import java.util.Date

import home.yang.dataflow.Filter

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class DataFilter(val keyName:String, isPass:(Ordered[Date])=>Boolean) extends Filter[Date](isPass){
  override def createDate(date: Date): Any = isPass(date)
}
