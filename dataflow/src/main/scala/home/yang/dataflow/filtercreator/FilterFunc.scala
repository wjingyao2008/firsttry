package home.yang.dataflow.filtercreator

/**
  * Created by Administrator on 2016/5/2 0002.
  */
object FilterFunc{

  def passFun[T<%Ordered[T]](fun:String,value:T)={
    val compare:T=>Boolean= fun match {
      case "=="=> _==value
      case ">="=> _>=value
      case "<="=> _<=value
      case ">"=> _>value
      case "<"=> _<value
    }
    compare
  }
}
