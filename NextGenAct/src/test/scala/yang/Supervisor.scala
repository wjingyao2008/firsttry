package yang
import akka.actor.{Props, Actor}
/**
  * Created by y28yang on 2/14/2016.
  */
class Supervisor(props:Props) extends Actor {
  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._
  import scala.concurrent.duration._

  val child=context.actorOf(props,"child")

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 1, withinTimeRange = 1 minute) {

      case exp: Exception                => {
        println("strategy used!:"+sender().path.toString)
        sender ! akka.actor.Status.Failure(exp)
        Resume
      }
    }

  def receive = {
    case p:Object => child forward p
  }
}
