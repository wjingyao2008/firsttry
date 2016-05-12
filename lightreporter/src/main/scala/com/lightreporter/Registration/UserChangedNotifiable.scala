package com.lightreporter.registration

/**
  * Created by y28yang on 4/5/2016.
  */
trait UserChangedNotifiable {

  def userChanged(users: Iterable[String])

}
