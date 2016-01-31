package yang

import java.util.concurrent.{Executors, ExecutorService}

import akka.actor.{Props, ActorSystem}
import com.nsn.oss.nbi.{ProxyUtil, IteratorStarter, AlarmIRPImpl, AlarmIRPStarter}

/**
  * Created by y28yang on 1/31/2016.
  */
object Main {


  def submit(runable:Runnable): Unit ={
   println(runable)
    EXECUTOR_SERVICE.execute(runable)
  }
  //System.getProperties.put("rootPath","D:\\WorkShop\\myscalamaven\\NextGenAct\\src\\test\\resources\\")
  val EXECUTOR_SERVICE: ExecutorService = Executors.newCachedThreadPool

  def main(args: Array[String]) {
//    val iterator: IteratorStarter = new IteratorStarter
//    submit(iterator)
    val system = ActorSystem("MyActors")

    val stubActor=system.actorOf(Props(new StubActor))
    val alarmActorPros = Props(new AlarmOperationActor(stubActor,null))
    val alarmOperationActor=system.actorOf(alarmActorPros)
    val alarmirpImpl = new AlarmOperationImpl(alarmOperationActor);
    val alarmirp = new AlarmIRPStarter(alarmirpImpl);
    alarmirp.run()
  }



}
