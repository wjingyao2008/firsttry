package home.yang.dataflow.filter

import home.yang.dataflow.Filter





class StringFilter(val keyName:String,isPass:(String)=>Boolean) extends Filter[String](isPass){

  override def createString(str: String): Any =isPass(str)

}






