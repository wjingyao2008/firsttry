package yang.notification.was

import akka.actor.ActorRef
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import yang.notification.UserChangedNotifiable

/**
  * Created by y28yang on 4/5/2016.
  */
@Configuration
class WasSpringModule {

  @Autowired
  var configuration: org.apache.commons.configuration2.Configuration = null

  @Autowired
  var sourceActor: ActorRef = null

  @Bean
  def registerInterface: UserChangedNotifiable = {
    new NotificationRegister(callBackHostName)
  }

  @Bean
  def notificationCallback: NotificationCallBack = {
    val callBack = new NotificationCallBack(callBackHostName, sourceActor)
    callBack.start()
    callBack
  }

  @Bean
  def callBackHostName: String = {
    val hostName = configuration.getString("com.oss.nsn.nbi.was.ndcallback.hostname")
    s"http://$hostName:8296/nd-callback/"
  }


}
