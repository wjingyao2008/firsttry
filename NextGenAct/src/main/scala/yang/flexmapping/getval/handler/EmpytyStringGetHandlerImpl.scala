package yang.flexmapping.getval.handler

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.flexmapping.handler.BaseHandler
import com.nsn.oss.nbi.flexmapping.util.GetHandlerInterface

/**
  * Created by y28yang on 4/11/2016.
  */
class EmpytyStringGetHandlerImpl extends GetHandlerInterface{


  override def getHandler(key: String, event: util.Map[EventField, String]): String = {
    ""
  }

}
