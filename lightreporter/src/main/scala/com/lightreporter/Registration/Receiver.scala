package com.lightreporter.Registration

/**
  * Created by y28yang on 4/27/2016.
  */
trait Receiver[T] {

  //  type Receive = PartialFunction[Any, Unit]

  def receive(msg:T)

  def start()

  def stop()

}
