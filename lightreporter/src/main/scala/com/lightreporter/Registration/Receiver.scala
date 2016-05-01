package com.lightreporter.Registration

/**
  * Created by y28yang on 4/27/2016.
  */
trait Receiver[T <: AnyRef] {

  //  type Receive = PartialFunction[Any, Unit]

  def receive(msg: Iterable[T])

  def start()

  def stop()
}
