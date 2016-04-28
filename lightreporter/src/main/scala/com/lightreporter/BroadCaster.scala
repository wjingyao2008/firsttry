package com.lightreporter

import akka.NotUsed
import akka.actor.ActorSystem
import com.lightreporter.RegisterMsg.RegisterList
import akka.stream._
import akka.stream.scaladsl._

/**
  * Created by y28yang on 4/27/2016.
  */
class BroadCaster {
  implicit val system = ActorSystem("QuickStart")
  implicit val materializer = ActorMaterializer()


  val source: Source[Int, NotUsed] = Source(1 to 100)

  val writeAuthors = Sink.foreach[String](println(_))
  val writeHashtags = Sink.foreach[String](println(_))

  val stringSource=source.map(it=>it.toString)

  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit b =>
    import GraphDSL.Implicits._

    val bcast = b.add(Broadcast[String](2))
    stringSource ~> bcast.in
    bcast.out(0) ~> Flow[String].map("1:"+_) ~> writeAuthors
    bcast.out(1) ~> Flow[String].map("2:"+_) ~> writeHashtags
    ClosedShape
  })

  def run()=g.run()
}
