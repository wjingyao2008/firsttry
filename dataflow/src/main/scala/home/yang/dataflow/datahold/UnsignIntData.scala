package home.yang.dataflow.datahold

import home.yang.dataflow.{DataHolder, ValueMapper}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class UnsignIntData(id: String, value: String) extends DataHolder(id, value) {

  var unsignInt: Int = 0

  override def parse: Unit = {
    unsignInt = Integer.parseUnsignedInt(value)
  }

  override def mapTo(outValueCreator: ValueMapper): Any = {
    outValueCreator.createInt(unsignInt)
  }
}
