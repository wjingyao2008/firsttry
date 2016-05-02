package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.ShortData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class ShortCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new ShortData(id, value)

}
