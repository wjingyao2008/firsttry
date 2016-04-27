package yang.flexmapping.getval

import java.util

import com.nsn.oss.nbi.flexmapping.EventField

/**
  * Created by y28yang on 4/9/2016.
  */
class GetValFixedVal(val fixedVal:String) extends GetValue{
  override def getValue(event: util.Map[EventField, String]): String = fixedVal
}
