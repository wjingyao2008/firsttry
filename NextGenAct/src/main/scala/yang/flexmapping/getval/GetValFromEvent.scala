package yang.flexmapping.getval

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import yang.flexmapping.getval.handler.AttributeNameTypeHandler

/**
  * Created by y28yang on 4/9/2016.
  */
class GetValFromEvent(val attributeName: String) extends GetValue {
  override def getValue(event: util.Map[EventField, String]): String = {
      AttributeNameTypeHandler.getHandler(attributeName,event)
  }
}
