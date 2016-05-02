package home.yang.dataflow.filter
import home.yang.dataflow.Filter
/**
  * Created by Administrator on 2016/5/2 0002.
  */
class IntFilter(val keyName:String, isPass:(Ordered[Int])=>Boolean) extends Filter[Int](isPass){

  override def createInt(actual: Int): Any ={
     isPass(actual)
  }
}
