package yang.alarm

import akka.actor.Actor
import akka.actor.Actor.Receive
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
import yang.Protocol.AlarmOptPtl._




/**
  * Created by y28yang on 1/31/2016.
  */
class AlarmCountActor() extends Actor{


  override def receive = {
    case request_get_alarm_count(filter) =>{

    }
  }


  def convertFilter(filter: StringTypeOpt): Unit ={

    var stringFilter=filter.value()
    if(stringFilter eq ""){
      stringFilter = null
    }

  }
}
