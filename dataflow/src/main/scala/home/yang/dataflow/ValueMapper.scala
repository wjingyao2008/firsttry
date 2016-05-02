package home.yang.dataflow

import java.util.Date
/**
  * Created by y28yang on 4/10/2016.
  */
abstract class ValueMapper {

  def createString(str:String):Any= ???

  def createInt(int:Int):Any= ???

  def createDate(date:Date):Any= ???

  def createBoolean(boolean: Boolean):Any= ???

  def createShort(short:Short):Any= ???

}
