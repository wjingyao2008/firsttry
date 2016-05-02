package home.yang.dataflow

/**
  * Created by Administrator on 2016/5/2 0002.
  */
abstract class Filter[T](isPass:(T)=>Boolean) extends ValueMapper{
   def keyName:String

}
