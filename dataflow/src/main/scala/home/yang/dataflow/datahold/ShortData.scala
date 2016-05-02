package home.yang.dataflow.datahold

import home.yang.dataflow.{DataHolder, ValueMapper}
import java.lang.Short
/**
  * Created by Administrator on 2016/5/2 0002.
  */
class ShortData(id: String, value: String) extends DataHolder(id, value) {

  var short: Short = 0.toShort


  override def parse: Unit = {
    short = Short.parseShort(value)
  }


  override def mapTo(outValueCreator: ValueMapper): Any = {
    outValueCreator.createShort(short)
  }
}
