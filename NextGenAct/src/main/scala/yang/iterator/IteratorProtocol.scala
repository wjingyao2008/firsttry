package yang.iterator

import akka.actor.ActorRef
import com.nsn.oss.nbi.fm.operation.interfaces.NsnAlarm
import org.omg.CosNotification.{StructuredEvent}

/**
  * Created by y28yang on 2/18/2016.
  */
object IteratorProtocol {
  case object request_to_poll_date
  case object request_create_iterator_ior
  case class polled_data_to_flexmapping(hasNext:Boolean,
                                        nsnAlarms:java.util.List[NsnAlarm],
                                        iteratorId:Int)

  case class appended_flexmapped_data(hasNext:Boolean, events:Array[StructuredEvent])
  case class request_next_date(howMany:Short)

  case class respond_next_date(hasNext:Boolean,structuredEvents:Array[StructuredEvent])
  case object request_destroy_iterator
  case class request_iterator_manager_to_destroy(iterator:ActorRef)

  case object schedule_to_check_unused_iterator
}
