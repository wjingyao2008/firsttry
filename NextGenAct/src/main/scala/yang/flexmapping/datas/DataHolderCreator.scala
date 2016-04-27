package yang.flexmapping.datas

/**
  * Created by y28yang on 4/10/2016.
  */
abstract class DataHolderCreator {

  def create(id: String, value: String): DataHolder

  def typeCode: String

  def keyToVal = typeCode -> this
}
