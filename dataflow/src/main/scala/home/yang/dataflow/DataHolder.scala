package home.yang.dataflow

/**
  * Created by y28yang on 4/10/2016.
  */
abstract class DataHolder(val id: String, val value: String) {

  def mapTo(outValueCreator: ValueMapper): Any

  def parse


}
