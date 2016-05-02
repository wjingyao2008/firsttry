package home.yang.dataflow.typesys

import home.yang.dataflow.dataholdcreator._
import home.yang.dataflow.{DataHolderCreator, FilterCreator}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
case class ValueType(val typeCode: String,
                     val dataHolderCreator: DataHolderCreator,
                     val filter: Option[FilterCreator]) {

}

object ValueType {
  val stringValueType = ValueType("string", new StringCreator, None)
  val intValueType = ValueType("int", new IntCreator, None)
  val boolValueType = ValueType("bool", new BooleanCreator, None)
  val timeValueType = ValueType("time", new DateTimeCreator, None)
  val ushortValueType = ValueType("ushort", new UnsignIntCreator, None)
  val shortValueType = ValueType("short", new ShortCreator, None)


}
