package home.yang.dataflow

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 2016/5/2 0002.
  */
trait DataContainer{
  def get(key:String):DataHolder
}
class SimpleData(var filterable: Map[String,DataHolder]) extends DataContainer{
  override def get(key: String): DataHolder = {
    filterable.getOrElse(key,null)
  }
}
