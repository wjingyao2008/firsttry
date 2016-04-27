package yang.corba.notification

import org.springframework.context.annotation.{Bean, Configuration}
import yang.notification.UserActorCreator

/**
  * Created by y28yang on 4/5/2016.
  */
@Configuration
class NotificationCorbaModule {


  @Bean
  def userActorCreator: UserActorCreator = {
    new NotificationSenderCreator
  }
}
