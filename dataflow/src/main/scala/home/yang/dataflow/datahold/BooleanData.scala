package home.yang.dataflow.datahold

import home.yang.dataflow.{DataHolder, ValueMapper}
import java.lang.Boolean
/**
  * Created by Administrator on 2016/5/2 0002.
  */
class BooleanData(id: String, value: String) extends DataHolder(id, value) {

  var booleanVal =false

  override def parse: Unit = {
    booleanVal =  Boolean.valueOf(value)
  }


  override def mapTo(outValueCreator: ValueMapper): Any= {
    outValueCreator.createBoolean(booleanVal)
  }
}
