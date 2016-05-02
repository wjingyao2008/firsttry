package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.StringData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class StringCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new StringData(id, value)

}
