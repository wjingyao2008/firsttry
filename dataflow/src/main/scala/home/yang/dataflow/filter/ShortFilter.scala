package home.yang.dataflow.filter
import home.yang.dataflow.Filter
/**
  * Created by Administrator on 2016/5/2 0002.
  */
class ShortFilter(val keyName:String, isPass:(Short)=>Boolean) extends Filter[Short](isPass){
  override def createShort(short: Short): Any = {
    isPass(short)
  }
}
