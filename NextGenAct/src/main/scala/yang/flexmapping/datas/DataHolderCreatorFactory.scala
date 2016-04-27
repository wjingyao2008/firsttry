package yang.flexmapping.datas

/**
  * Created by y28yang on 4/10/2016.
  */
object DataHolderCreatorFactory {
  private val defaultStringCreator=new StringCreator
  private val creatorMap = Map(defaultStringCreator.keyToVal,
    new IntCreator().keyToVal,
    new BooleanCreator().keyToVal,
    new DateTimeCreator().keyToVal,
    new ShortCreator().keyToVal,
    new UnsignIntCreator().keyToVal,
    new UnsignShortCreator().keyToVal)


  def getOrWithDefault(theType: String)=creatorMap.getOrElse(theType,defaultStringCreator)
}


class StringCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new StringData(id, value)

  override def typeCode: String = "string"
}

class IntCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new IntData(id, value)

  //because (c++ long)=(java int), (c++ longlong) == (java long).
  override def typeCode: String = "long"
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

class UnsignIntCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new UnsignIntData(id, value)

  //because it is c++ 3gpp ulong,it is not java ulong.
  override def typeCode: String = "ulong"
}




class UnsignShortCreator extends DataHolderCreator {
  override def create(id: String, value: String) = new UnsignShortData(id, value)

  override def typeCode: String = "ushort"
}
