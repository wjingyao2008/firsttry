package home.yang.dataflow.filtercreator

/**
  * Created by Administrator on 2016/5/2 0002.
  */
object FilterFunc{

  def passFun[T](fun:String,value:T)={
    val compare:Comparable[T]=>Boolean= fun match {
      case "=="=> _.compareTo(value)==0
      case ">="=> _.compareTo(value) >=0
      case "<="=> _.compareTo(value) <=0
      case ">"=> _.compareTo(value) >0
      case "<"=> _.compareTo(value) <0
    }
    compare
  }
}
