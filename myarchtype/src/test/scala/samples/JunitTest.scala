package samples

import akka.actor.{ActorSystem, Props}
import chapter3.MyActor
import org.junit._
import Assert._

@Test
class JunitTest {

    @Test
    def testOK() = assertTrue(true)

     @Test
  def testKO() = {
       val pro1=Props[MyActor]
       val system=ActorSystem("mySystem")
       val myActor=system.actorOf(pro1,"myActorInstance")
       myActor ! "test"

       myActor ! "test2"
       assertTrue(true)
     }

}


