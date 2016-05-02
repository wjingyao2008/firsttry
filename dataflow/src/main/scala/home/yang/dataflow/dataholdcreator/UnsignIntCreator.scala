package home.yang.dataflow.dataholdcreator

import home.yang.dataflow.DataHolderCreator
import home.yang.dataflow.datahold.UnsignIntData

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class UnsignIntCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new UnsignIntData(id, value)

}
