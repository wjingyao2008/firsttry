package Corba

import com.lightreporter.filterfunc.ValueExtractor
import com.lightreporter.filterfunc.operatorfactory.IfGetNoneExtractorHandler
import org.omg.CosNotification.StructuredEvent

/**
  * Created by y28yang on 5/16/2016.
  */
class NoneExtractorHandler extends IfGetNoneExtractorHandler[StructuredEvent]{
  override def getNone(name: String): ValueExtractor[StructuredEvent] = {
    new RuntimeAnyExtractor(name)
  }
}
