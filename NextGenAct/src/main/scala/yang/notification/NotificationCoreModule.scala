package yang.notification

import akka.actor.{ActorRef, ActorRefFactory, Props}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._

/**
  * Created by y28yang on 3/31/2016.
  */
@Configuration
class NotificationCoreModule {


  @Autowired
  var actorFactory: ActorRefFactory = null

  @Autowired
  var enrichActor: ActorRef = null

  @Autowired
  var userChangedNotifiable: UserChangedNotifiable = null

  @Autowired
  var userActorCreator: UserActorCreator = _

  @Autowired
  var alarmNotificationConvert:AlarmNotificationConvert=_

  @Bean
  def userManagerActor: ActorRef = {
    actorFactory.actorOf(Props(new UserManager(userActorCreator,userChangedNotifiable)), "UserManager")
  }

  @Bean
  def sourceActor: ActorRef = {
    userChangedNotifiable.startScheduleCheck()
    actorFactory.actorOf(Props(new NotificationSourceActor(alarmNotificationConvert,enrichActor)), "NotificationSource")
  }


}
