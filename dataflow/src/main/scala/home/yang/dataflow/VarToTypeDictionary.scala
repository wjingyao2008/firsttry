package home.yang.dataflow

import home.yang.dataflow.typesys.ValueType

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class VarToTypeDictionary {

   var typeMap=Map[String,ValueType]()

   def getType(varName: String): ValueType = {
      typeMap.getOrElse(varName,ValueType.stringValueType)
   }

   def addType(varName: String, valueType: ValueType): Unit = {
      typeMap+=varName->valueType
   }
}

