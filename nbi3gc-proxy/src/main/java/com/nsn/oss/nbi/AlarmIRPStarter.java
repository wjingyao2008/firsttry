package com.nsn.oss.nbi;

import com.nsn.oss.nbi.common.Logger;
import org.omg.PortableServer.Servant;

public class AlarmIRPStarter extends ServantStarter {

    private final static Logger LOGGER = Logger.getLogger(AlarmIRPStarter.class);

    private Servant servant;
    private NamingServiceRegister register = new NamingServiceRegister();

    public AlarmIRPStarter(Servant servant) {
        this.servant = servant;
    }

    @Override
    public void publish(org.omg.CORBA.Object object) throws Exception {
        register.register("AlarmIRP", object);
        LOGGER.info("Alarm IRP "+object);
//        LOGGER.info("Alarm IRP is published at Naming Service");
    }

    @Override
    public Servant getServant() {
        return servant;
    }

    @Override
    protected String getPOAName() {
        return "AlarmIRPCorbaPort";
    }

    @Override
    protected String getServantName() {
        return "{http://AlarmIRPSystem.AlarmIRP}AlarmIRP";
    }

    @Override
    protected String getPort() {
        return ProxyUtil.getPortByInstanceIdandKey(ProxyUtil.getProxyInstanceId(), this.getClass().getName());
    }
}
