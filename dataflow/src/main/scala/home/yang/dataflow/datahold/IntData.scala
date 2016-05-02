package home.yang.dataflow.datahold

import home.yang.dataflow.{DataHolder, ValueMapper}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class IntData(id: String, value: String) extends DataHolder(id, value) {

  var int = 0

  override def parse: Unit = {
    int = Integer.parseInt(value)
  }

  override def mapTo(outValueCreator: ValueMapper): Any = outValueCreator.createInt(int)
}
