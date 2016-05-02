package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.BooleanData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class BooleanCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new BooleanData(id, value)

}
