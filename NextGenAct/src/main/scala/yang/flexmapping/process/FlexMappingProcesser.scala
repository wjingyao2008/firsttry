package yang.flexmapping.process

import com.nsn.oss.nbi.flexmapping.EventField
import yang.flexmapping.StructuredEventWarpper

/**
  * Created by y28yang on 4/8/2016.
  */
trait FlexMappingProcesser {

  def process(event: java.util.Map[EventField, String],structuredEvent:StructuredEventWarpper);



}
