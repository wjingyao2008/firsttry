package yang.notification

import com.nsn.oss.nbi.common.Logger
import com.nsn.oss.nbi.common.lib.ndregister.{RegistrationInfo, RegistrationState, RegistrationStateChangeCallback}

/**
  * Created by y28yang on 3/31/2016.
  */
class RegistrationStateChangeCallBackImpl extends RegistrationStateChangeCallback {
  private val LOGGER = Logger.getLogger(classOf[RegistrationStateChangeCallBackImpl])

  override def reportRegistrationStatusChange(newState: RegistrationState, oldState: RegistrationState, registrationInfo: RegistrationInfo) {
    LOGGER.info("stata had changed,need alarm rebuild")
  }
}
