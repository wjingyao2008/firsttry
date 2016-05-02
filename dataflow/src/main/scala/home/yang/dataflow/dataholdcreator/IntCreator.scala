package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.IntData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class IntCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new IntData(id, value)
}
