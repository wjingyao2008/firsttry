package yang.flexmapping

import java.util

import com.nsn.oss.nbi.flexmapping.EventField
import com.nsn.oss.nbi.interfaces.AlarmNotificationFlow

import scala.xml.Elem

/**
  * Created by y28yang on 4/11/2016.
  */
object FlexProtocol {

  case class FileHasChanged(path:String)

  case class XmlContentHasChanged(xmlContent:Elem)

   case class ToFlexMapAlarmFlow(flow:List[util.HashMap[EventField, String]],theType:String)

  case class OutFlexMapPayLoad(structs:List[StructuredEventWarpper])

}
