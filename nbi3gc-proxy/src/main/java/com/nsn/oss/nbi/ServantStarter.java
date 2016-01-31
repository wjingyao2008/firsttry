package com.nsn.oss.nbi;

import java.util.Properties;

import com.nsn.oss.nbi.common.Logger;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.IdAssignmentPolicyValue;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;


public abstract class ServantStarter implements Runnable {

    private final static Logger LOGGER = Logger.getLogger(ServantStarter.class);

    abstract protected Servant getServant();

    abstract protected String getPort();

    abstract protected String getPOAName();

    abstract protected String getServantName();

    public org.omg.CORBA.Object activate(ORB orb) throws Exception {
        LOGGER.info("Enter activate");
        if (getServant() != null) {
            POA rootPoa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            org.omg.CORBA.Policy[] policies = new org.omg.CORBA.Policy[2];
            policies[0] = rootPoa.create_lifespan_policy(LifespanPolicyValue.PERSISTENT);
            policies[1] = rootPoa.create_id_assignment_policy(IdAssignmentPolicyValue.USER_ID);

            POA persistentPOA = rootPoa.create_POA(getPOAName(), rootPoa.the_POAManager(), policies);
            persistentPOA.the_POAManager().activate();
            byte[] objectId = getServantName().getBytes();
            persistentPOA.activate_object_with_id(objectId, getServant());
            return persistentPOA.servant_to_reference(getServant());
        }
        return null;
    }

    protected void publish(org.omg.CORBA.Object object) throws Exception {
    }

    protected Properties getProperties() {
        Properties properties = new Properties();
        String port = getPort();
        properties.put("OAPort", port);
        properties.put("OASSLPort", port);
        properties.put("jacorb.implname", getServantName());
        return properties;
    }

    @Override
    public void run() {
        try {
            ORB orb = CorbaUtils.getOrb(getProperties());
            org.omg.CORBA.Object object = activate(orb);
            publish(object);
            orb.run();
        } catch (Exception e) {
            LOGGER.error("Failed to startup the Servant", e);
        }
    }

}
