package home.yang.dataflow.filter

import home.yang.dataflow.Filter

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class BooleanFilter(val keyName:String, isPass:(Ordered[Boolean])=>Boolean) extends Filter[Boolean](isPass){

  override def createBoolean(boolean: Boolean): Any = isPass(boolean)

}
