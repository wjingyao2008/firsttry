package home.yang.dataflow.datahold

/**
  * Created by y28yang on 4/10/2016.
  */
object DataHolderCreatorFactory {
  private val defaultStringCreator=new StringCreator
  private var creatorMap = Map(defaultStringCreator.keyToVal,
    new IntCreator().keyToVal,
    new BooleanCreator().keyToVal,
    new DateTimeCreator().keyToVal,
    new ShortCreator().keyToVal,
//    new UnsignIntCreator().keyToVal,
    new UnsignShortCreator().keyToVal)

  def replace(key:String,value:DataHolderCreator)={
    creatorMap+=key->value
  }

  def getOrWithDefault(theType: String)=creatorMap.getOrElse(theType,defaultStringCreator)
}



