package home.yang.dataflow
/**
  * Created by Administrator on 2016/5/2 0002.
  */
abstract class FilterCreator {
   def create(key:String,value:String,func:String):Filter[_]


}

