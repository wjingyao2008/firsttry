package yang.flexmapping.datas

import java.util.Date
/**
  * Created by y28yang on 4/10/2016.
  */
trait OutValueCreator {

  def createString(str:String):AnyRef

  def createInt(int:Int):AnyRef

  def createDate(date:Date):AnyRef

  def createBoolean(boolean: Boolean):AnyRef

  def createShort(short:Short):AnyRef

}
