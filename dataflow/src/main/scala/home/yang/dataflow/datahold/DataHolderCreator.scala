package home.yang.dataflow.datahold

/**
  * Created by y28yang on 4/10/2016.
  */
abstract class DataHolderCreator {

  def create(id: String, value: String): DataHolder

  def typeCode: String

  def keyToVal = typeCode -> this
}
class StringCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new StringData(id, value)

  override def typeCode: String = "string"
}

class IntCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new IntData(id, value)

  //because (c++ long)=(java int), (c++ longlong) == (java long).
//  override def typeCode: String = "long"
  override def typeCode: String = "int"
}

class BooleanCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new BooleanData(id, value)

  override def typeCode: String = "bool"
}

class DateTimeCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new DateTimeData(id, value)

  override def typeCode: String = "time"
}

class ShortCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new ShortData(id, value)

  override def typeCode: String = "short"
}

//class UnsignIntCreator extends DataHolderCreator {
//  override def create(id: String, value: String) = new UnsignIntData(id, value)
//
//  //because it is c++ 3gpp ulong,it is not java ulong.
//  override def typeCode: String = "ulong"
//}




class UnsignShortCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new UnsignIntData(id, value)

  override def typeCode: String = "ushort"
}