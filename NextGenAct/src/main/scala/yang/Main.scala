package yang

import java.util
import java.util.Properties
import java.util.concurrent.{ExecutorService, Executors}

import akka.actor.{ActorRef, ActorSystem, Props}
import com.nsn.oss.nbi.common.Logger
import com.nsn.oss.nbi.fm.operation.interfaces._
import com.nsn.oss.nbi.iterator.IteratorManager
import com.nsn.oss.nbi.{IRPInfoServiceInstance, IteratorStarter}
import yang.alarm._
import yang.common._
import yang.corba.AlarmIRPStarter

/**
  * Created by y28yang on 1/31/2016.
  */
object Main {


  val EXECUTOR_SERVICE: ExecutorService = Executors.newCachedThreadPool
  val LOGGER = Logger.getLogger("Main")

  def main(args: Array[String]): Unit = {

    val iteratorStarter: IteratorStarter = new IteratorStarter {
      override def getProperties: Properties = {
        val properties: Properties = new Properties
        properties.put("OAPort", "8999")
        properties.put("OASSLPort", "8998")
        properties
      }
    }
    submit(iteratorStarter)
    val system = ActorSystem("MyActors")
    LOGGER.info("args:" + args.mkString(","))

    LOGGER.info("inital akka")

    val alarmCountActor = system.actorOf(Props(new AlarmCountActor(new AlarmFmServiceImpl)), "AlarmCount")
    val versionProfileActor = system.actorOf(Props(new VersionProfilesInfoActor(new IRPInfoServiceInstance)), "VersionProfile")



    val alarmGetListActor = getAlarmListActor(system, iteratorStarter)

    val alarmActorPros = Props(new AlarmOperationActor(versionProfileActor, alarmCountActor, alarmGetListActor))


    val alarmOperationActor = system.actorOf(alarmActorPros, "AlarmOpt")
    println("initial jacorb")
    val alarmirpImpl = new AlarmOperationImpl(alarmOperationActor)
    var port = "8300"
    if (args.length > 0) port = args(0)
    val alarmirp = new AlarmIRPStarter(alarmirpImpl, port)
    alarmirp.run()


    //    val notificationIRPImpl=new NotificationIRPImpl
  }

  def submit(runable: Runnable): Unit = {
    println(runable)
    EXECUTOR_SERVICE.execute(runable)
  }

  def getAlarmListActor(system: ActorSystem, iterator: IteratorStarter): ActorRef = {


    //     val inputProcesser=new GetAlarmListGetInputParameterProcessor(new ProxyFilterManagerImpl,
    //      new DnNameMapperImpl,iteratorFlexMappingActor)
    val iteratorIorService = system.actorOf(Props.create(classOf[IteratorManager], null, iterator))

    val getAlarmListFromFmActor = system.actorOf(Props.create(classOf[GetAlarmListFromFmActor], new AlarmFmServiceImpl, iteratorIorService, iteratorIorService))
    val iteratorFlexMappingActor = system.actorOf(Props.create(classOf[IteratorFlexMappingActor], getAlarmListFromFmActor))
    val inputProcesserActor = system.actorOf(Props.create(classOf[GetAlarmListGetInputParameterProcessor],
      new ProxyFilterManagerImpl,
      new DnNameMapperImpl,
      iteratorFlexMappingActor))
    inputProcesserActor
  }

  class mockFmService extends AlarmFmServiceInterface {
    override def getAllAlarmCounts(filters: util.List[Filter], userInfo: UserInfo): AlarmCounts = ???

    override def getAllAlarm(filters: util.List[Filter], userInfo: UserInfo): Int = {
      45
    }

    @throws(classOf[IterationFault])
    override def getNext(iteratorId: Int, howMany: Int): util.List[NsnAlarm] = ???
  }

}
