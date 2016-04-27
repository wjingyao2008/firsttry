package yang.notification.was

import com.nsn.oss.nbi.common.lib.ndregister.{RegistrationInfo, RegistrationManager, RegistrationStateChangeCallback}
import yang.notification.{RegistrationStateChangeCallBackImpl, UserChangedNotifiable}

/**
  * Created by y28yang on 3/31/2016.
  */
class NotificationRegister(appId: String, callback: String, filterId: String,
                           correlationFilterResult: String, stateChangeCallback: RegistrationStateChangeCallback)
  extends UserChangedNotifiable {

  private val registrationInfo = new RegistrationInfo(appId, callback, filterId, correlationFilterResult)
  private val registrationManager = new RegistrationManager(registrationInfo, stateChangeCallback)

  // val hostName: String = Config.get("com.nsn.oss.nbi.notification.callback.address", defaultHostName)
  def this(callBackHostName: String) = this("3GPP NBI",
    s"$callBackHostName/NotificationWSCallbackInterfaceService",
    "com.nsn.oss.nbi.fm.filterId", "com.nsn.oss.nbi.fm.correlationFilterResult",
    new RegistrationStateChangeCallBackImpl
  )

  def startScheduleCheck() {
    registrationManager.start()
  }


  override def userChanged(users: Iterable[String]): Unit = {
    if(users.isEmpty)
      registrationManager.unregister()
    else registrationManager.register()
  }


}
