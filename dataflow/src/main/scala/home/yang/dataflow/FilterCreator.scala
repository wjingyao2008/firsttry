package home.yang.dataflow

/**
  * Created by Administrator on 2016/5/2 0002.
  */
trait FilterCreator {
   def create(repl:String):Filter[_]
}

