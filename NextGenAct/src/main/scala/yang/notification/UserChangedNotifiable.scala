package yang.notification

/**
  * Created by y28yang on 4/5/2016.
  */
trait UserChangedNotifiable {

  def userChanged(users: Iterable[String])

  def startScheduleCheck(): Unit


}
