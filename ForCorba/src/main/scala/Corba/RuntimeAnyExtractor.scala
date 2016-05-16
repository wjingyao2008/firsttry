package Corba

import com.lightreporter.filterfunc.ValueExtractor
import org.omg.CosNotification.StructuredEvent

/**
  * Created by y28yang on 5/16/2016.
  */
class RuntimeAnyExtractor(name: String) extends ValueExtractor[StructuredEvent] {
  override def getKey(): String = name

  override def getVal(msg: StructuredEvent): Any = {
    if (msg.filterable_data != null) {
      for (property <- msg.filterable_data) {
        if (property.name == name) {
          return property.value.toString
        }
      }
    }
    "null"
  }

}