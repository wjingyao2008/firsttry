package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.DateTimeData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class DateTimeCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new DateTimeData(id, value)

}
