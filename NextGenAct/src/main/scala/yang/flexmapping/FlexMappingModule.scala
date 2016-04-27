package yang.flexmapping

import akka.actor.{ActorRef, ActorRefFactory, Props}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import yang.flexmapping.enrich.{Enrich, EnrichActor, EnrichSimpleImpl}
import yang.flexmapping.process.FlemxMappingProcesserCreator

/**
  * Created by y28yang on 4/12/2016.
  */
@Configuration
class FlexMappingModule {
  @Autowired
  var actorFactory: ActorRefFactory = null

  @Bean
  def flexMappingProcessor: FlemxMappingProcesserCreator = new FlemxMappingProcesserCreator

  @Autowired
  var userManagerActor: ActorRef = null

  @Bean
  def flexMappingActor: ActorRef = {
    actorFactory.actorOf(Props(new FlexMappingActor(flexMappingProcessor,userManagerActor)))
  }

  @Bean
  def enrich:Enrich=new EnrichSimpleImpl

  @Bean
  def enrichActor:ActorRef={
    actorFactory.actorOf(Props(new EnrichActor(enrich,flexMappingActor)))

  }

}
