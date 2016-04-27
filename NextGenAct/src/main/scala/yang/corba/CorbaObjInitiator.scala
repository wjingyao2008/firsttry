package yang.corba

import org.omg.PortableServer.Servant

/**
  * Created by y28yang on 2/16/2016.
  */
trait CorbaObjInitiator {
  def active(toActive: Servant): Unit

  def deActive(toDeactive: Servant): Unit
}



