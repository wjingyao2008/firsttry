package home.yang.dataflow

/**
  * Created by y28yang on 4/10/2016.
  */
trait  DataHolderCreator {
  def create(id: String, value: String): DataHolder
}










//class UnsignIntCreator extends DataHolderCreator {
//  override def create(id: String, value: String) = new UnsignIntData(id, value)
//
//  //because it is c++ 3gpp ulong,it is not java ulong.
//  override def typeCode: String = "ulong"
//}