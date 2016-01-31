package com.nsn.oss.nbi;

import com.nsn.oss.nbi.common.Logger;
import org.omg.PortableServer.Servant;

public class NotificationIRPStarter extends ServantStarter {

    private final static Logger LOGGER = Logger.getLogger(NotificationIRPStarter.class);

    private NotificationIRPImpl servant = new NotificationIRPImpl();
    private NamingServiceRegister register = new NamingServiceRegister();

    @Override
    public void publish(org.omg.CORBA.Object object) throws Exception {
        register.register("NotificationIRP", object);
        LOGGER.info("Notification IRP is published at Naming Service");
    }

    @Override
    public Servant getServant() {
        return servant;
    }

    @Override
    protected String getPOAName() {
        return "NotificationIRPCorbaPort";
    }

    @Override
    protected String getServantName() {
        return "{http://NotificationIRPSystem.NotificationIRP}NotificationIRP";
    }

    @Override
    protected String getPort() {
        return ProxyUtil.getPortByInstanceIdandKey(ProxyUtil.getProxyInstanceId(), this.getClass().getName());
    }
}
