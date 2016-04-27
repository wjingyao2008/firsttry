package yang.iterator

import akka.actor.ActorRef
import com.nsn.oss.nbi.fm.operation.interfaces.NsnAlarm

/**
  * Created by y28yang on 2/18/2016.
  */
object IteratorProtocol {

  case class RequestCreateIteratorIor(iteratorId: Int)

  case class polled_data_to_flexmapping(hasNext: Boolean,
                                        nsnAlarms: java.util.List[NsnAlarm],
                                        iteratorId: Int)

  case class appended_flexmapped_data[T](hasNext: Boolean, events: Iterable[T])

  case class request_next_date(howMany: Short)

  case class RespondNextDate[T](hasNext: Boolean, structuredEvents: Iterable[T])

  case class request_iterator_manager_to_destroy(iterator: ActorRef)

  case object RequestToPollDate

  case object RequestDestroyIterator

  case object schedule_to_check_unused_iterator

}
