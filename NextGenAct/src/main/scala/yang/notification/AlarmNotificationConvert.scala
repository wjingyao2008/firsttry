package yang.notification

import com.nsn.oss.nbi.fm.notification.EnrichedNotificationDTO
import com.nsn.oss.nbi.interfaces.AlarmNotificationFlow

/**
  * Created by y28yang on 4/7/2016.
  */
trait AlarmNotificationConvert {

  def convert(dto:EnrichedNotificationDTO): AlarmNotificationFlow
}
