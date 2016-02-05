package yang

import java.util.concurrent.{Executors, ExecutorService}

import akka.actor.{Props, ActorSystem}
import com.nsn.oss.nbi.IRPInfoServiceInstance
import com.typesafe.config.{ConfigFactory, Config}
import yang.alarm.{AlarmOperationServiceImpl, AlarmCountActor}
import yang.common.VersionProfilesInfoActor
import yang.corba.AlarmIRPStarter

/**
  * Created by y28yang on 1/31/2016.
  */
object Main {


  def submit(runable:Runnable): Unit ={
   println(runable)
    EXECUTOR_SERVICE.execute(runable)
  }

  val EXECUTOR_SERVICE: ExecutorService = Executors.newCachedThreadPool

  def main(args: Array[String]) {
//    val iterator: IteratorStarter = new IteratorStarter
//    submit(iterator)

    val system = ActorSystem("MyActors")
    println("args:"+args.mkString(","))

    println("inital akka")
    val stubActor=system.actorOf(Props(new StubActor))
    val alarmCountActor=system.actorOf(Props(new AlarmCountActor(new AlarmOperationServiceImpl)),"AlarmCount")
    val versionProfileActor=system.actorOf(Props(new VersionProfilesInfoActor(new IRPInfoServiceInstance)),"VersionProfile")
    val alarmActorPros = Props(new AlarmOperationActor(versionProfileActor,alarmCountActor))


    val alarmOperationActor=system.actorOf(alarmActorPros,"AlarmOpt")
 //   val alarmirpImpl = new AlarmOperationImpl(null);
    println("initial jacorb")
    val alarmirpImpl = new AlarmOperationImpl(alarmOperationActor);
    var port="8300"
    if(args.length>0) port=args(0)
    val alarmirp = new AlarmIRPStarter(alarmirpImpl,port);
    alarmirp.run()
  }




}
