package com.nsn.oss.nbi;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.nsn.oss.nbi.common.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongAdapter;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class IteratorStarter implements Runnable {

    private final static Logger LOGGER = Logger.getLogger(IteratorStarter.class);

    private ORB orb;
    private POA poa;
    private final static int ITERATOR_MAX_NUM_DEF = 50;
    private BlockingQueue<Servant> iterators = null;

    public IteratorStarter() throws InvalidName, AdapterInactive {
        this.orb = CorbaUtils.getOrb(getProperties());
        iterators = new LinkedBlockingQueue<Servant>(ITERATOR_MAX_NUM_DEF);
        poa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();
    }

    public synchronized void activate(Servant servant) throws WrongPolicy, WrongAdapter {
        try {
            poa.activate_object(servant);

            while (!iterators.offer(servant)) {
                Servant expiredIterator = iterators.poll();
                deactivate(expiredIterator);
            }
        } catch (ServantAlreadyActive e) {
            LOGGER.debug("Servant is active already");
        }
    }

    private void deactivate(Servant servant) throws WrongPolicy, WrongAdapter {
        try {
            servant._this_object()._release();
            poa.deactivate_object(poa.reference_to_id(servant._this_object()));
        } catch (ObjectNotActive e) {
            LOGGER.debug("Servant is inactive already");
        }
    }

    protected Properties getProperties() {
        Properties properties = new Properties();
        String oaprot = ProxyUtil.getPortByInstanceIdandKey(ProxyUtil.getProxyInstanceId(), this.getClass().getName());
        properties.put("OAPort", oaprot);
        properties.put("OASSLPort", oaprot);
        return properties;
    }

    @Override
    public void run() {
        try {
            orb.run();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
