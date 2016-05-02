package home.yang.dataflow.datahold

import home.yang.dataflow.{DataHolder, ValueMapper}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class StringData(id: String, value: String) extends DataHolder(id, value) {

  var typeValue = ""

  override def mapTo(outValueCreator: ValueMapper): Any = {
    outValueCreator.createString(typeValue)
  }

  override def parse: Unit = {
    typeValue = value
  }
}
