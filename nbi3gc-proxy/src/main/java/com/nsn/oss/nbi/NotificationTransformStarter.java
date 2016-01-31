package com.nsn.oss.nbi;

import com.nsn.oss.nbi.common.Logger;
import org.omg.PortableServer.Servant;

public class NotificationTransformStarter extends ServantStarter {

    private final static Logger LOGGER = Logger.getLogger(NotificationTransformStarter.class);
    private NotificationTransformImpl servant = new NotificationTransformImpl();
    private FileServiceRegister register = new FileServiceRegister();


    @Override
    protected void publish(org.omg.CORBA.Object object) throws Exception {
        register.register("NotificationTransform", object);
        LOGGER.info("NotificationTransform is published at Naming Service");
    }

    @Override
    protected Servant getServant() {
        return servant;
    }

    @Override
    protected String getPOAName() {
        return "NotificationTransformCorbaPort";
    }

    @Override
    protected String getServantName() {
        return "{http://NBI3GC}NotificationTransform";
    }

    @Override
    protected String getPort() {
        return ProxyUtil.getPortByInstanceIdandKey(ProxyUtil.getProxyInstanceId(), this.getClass().getName());
    }
}
