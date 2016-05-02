package home.yang.dataflow.datahold
import java.util.Date

/**
  * Created by Administrator on 2016/5/2 0002.
  */
abstract class Filter[T](val isPass:(T)=>Boolean) extends ValueGen{
   def keyName:String

}

class IntFilter(val keyName:String,isPass:(Int)=>Boolean) extends Filter[Int](isPass){

  override def createInt(actual: Int): Any ={
     isPass(actual)
  }
}

class StringFilter(val keyName:String,isPass:(String)=>Boolean) extends Filter[String](isPass){

  override def createString(str: String): Any =isPass(str)

}

class BooleanFilter(val keyName:String,isPass:(Boolean)=>Boolean) extends Filter[Boolean](isPass){

  override def createBoolean(boolean: Boolean): Any = isPass(boolean)

}

class ShortFilter(val keyName:String,isPass:(Short)=>Boolean) extends Filter[Short](isPass){
  override def createShort(short: Short): Any = {
    isPass(short)
  }
}

class DataFilter(val keyName:String,isPass:(Date)=>Boolean) extends Filter[Date](isPass){
  override def createDate(date: Date): Any = isPass(date)
}
