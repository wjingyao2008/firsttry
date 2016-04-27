package yang.corba.notification

import java.util.Date

import com.nsn.obs.mw.mf.core.config.Config
import com.nsn.oss.nbi.common.Logger
import org.omg.CORBA.{Any, ORB}
import org.omg.TimeBase.UtcT
import yang.flexmapping.datas.OutValueCreator

/**
  * Created by y28yang on 4/10/2016.
  */
class CorbaAnyValCreator(val orb: ORB) extends OutValueCreator {

  val LOGGER = Logger.getLogger(classOf[CorbaAnyValCreator])

  override def createString(str: String): AnyRef = {
    val any = orb.create_any()
    any.insert_string(str)
    any
  }

  override def createBoolean(boolean: Boolean): AnyRef = {
    val any = orb.create_any()
    any.insert_boolean(boolean)
    any
  }

  override def createInt(int: Int): AnyRef = {
    val any = orb.create_any()
    any.insert_long(int)
    any
  }

  override def createShort(short: Short): AnyRef = {
    val any = orb.create_any()
    any.insert_short(short)
    any
  }


  override def createDate(longtime: Date): AnyRef = {
    val time: UtcT = org.jacorb.util.Time.corbaTime(longtime)
    //PR NA05420333: Alarms have the wrong format in NBIF, defaullt use TimeBase
    val any: Any = orb.create_any
    val dateType: String = Config.get("com.nsn.oss.nbi.event.dateType", "TimeBase")
    //    if ("TimeBase" == dateType) {
    LOGGER.trace("com.nsn.oss.nbi.event.dateType: " + dateType + ", use: org.omg.TimeBase.UtcTHelper")
    org.omg.TimeBase.UtcTHelper.insert(any, time)
    //    }
    //TODO
    //    else {
    //      LOGGER.trace("com.nsn.oss.nbi.event.dateType: " + dateType + ", use:  org.omg.Security.UtcTHelper")
    //      org.omg.Security.UtcTHelper.insert(any, time)
    //    }
    any
  }


}
