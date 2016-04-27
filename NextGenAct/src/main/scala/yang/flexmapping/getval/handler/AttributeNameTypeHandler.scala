package yang.flexmapping.getval.handler

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.flexmapping.util.GetHandlerInterface

/**
  * Created by y28yang on 4/11/2016.
  */
object AttributeNameTypeHandler {

  var handler:GetHandlerInterface=new EmpytyStringGetHandlerImpl
  def getHandler(key:String,event: util.Map[EventField, String]):String=handler.getHandler(key,event)


}
