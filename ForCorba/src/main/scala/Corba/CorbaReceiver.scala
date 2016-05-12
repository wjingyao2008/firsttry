package Corba

import com.lightreporter.registration.Receiver
import org.omg.CosNotification.StructuredEvent
import org.omg.CosNotifyComm.SequencePushConsumer

/**
  * Created by y28yang on 5/12/2016.
  */
class CorbaReceiver(spc: SequencePushConsumer) extends Receiver[StructuredEvent] {


  override def receive(msg: StructuredEvent): Unit = {
    spc.push_structured_events(Array(msg))
  }

  override def stop(): Unit = {
    println("end")
  }

  override def start(): Unit = {
    println("start")
  }


}
