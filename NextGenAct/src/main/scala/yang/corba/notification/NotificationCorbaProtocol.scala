package yang.corba.notification

/**
  * Created by y28yang on 3/30/2016.
  */
object NotificationCorbaProtocol {

  case class AttachInfo(manager_reference: String, time_tick: Int, filter: String, proxyId: String)

}
