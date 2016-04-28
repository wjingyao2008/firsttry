package com.lightreporter

/**
  * Created by y28yang on 4/27/2016.
  */
trait Receiver{

  type Receive = PartialFunction[Any, Unit]

   def receive: Receive

   def start()

   def stop()
}
