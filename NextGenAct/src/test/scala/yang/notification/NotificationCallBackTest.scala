package yang.notification

import org.scalatest.FunSuite
import yang.notification.was.NotificationCallBack

/**
  * Created by y28yang on 3/30/2016.
  */
class NotificationCallBackTest extends FunSuite {


  test("testProcessNotifications") {
    val callBack = new NotificationCallBack("123", null)
    callBack.start()

    //val endpoint = NotificationWSCallbackPublisher.getInstance().publish(callbackImpl, "123");
    //     val wsdlURL: URL =(classOf[NotificationCallBackTest]).getClassLoader.getResource("ND_CallBack.wsdl")
    //     val SERVICE_NAME: QName = new QName("http://www.nokiasiemens.com/nd-callback", "NotificationWSCallbackInterfaceService")
    //    val ss = new NotificationWSCallbackInterfaceService(
    //      wsdlURL, SERVICE_NAME);
    //    val port = ss.getNdCallback();
    //    val provider:BindingProvider = port.asInstanceOf[BindingProvider];
    //    provider.getRequestContext().put(
    //      BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
    //      "http://localhost:8312/nd-callback/");

  }

}
