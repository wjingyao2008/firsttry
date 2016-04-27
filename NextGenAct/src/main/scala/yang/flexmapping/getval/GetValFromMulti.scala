package yang.flexmapping.getval

import java.util

import com.nsn.oss.nbi.flexmapping.EventField

/**
  * Created by y28yang on 4/9/2016.
  */
class GetValFromMulti(val seqGetVals:Iterable[GetValue]) extends GetValue{


  override def getValue(event: util.Map[EventField, String]): String = {
    var sb=new StringBuilder
    seqGetVals.foreach(getVal=>{
      sb.append(getVal.getValue(event))
    })
    sb.toString()
  }
}
