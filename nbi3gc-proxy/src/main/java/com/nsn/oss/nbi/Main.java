package com.nsn.oss.nbi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nsn.oss.nbi.common.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    private final static ExecutorService EXECUTOR_SERVICE= Executors.newCachedThreadPool();
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new NamingServiceRegister().createNamingContext();
        LOGGER.info(ProxyUtil.getInstanceLogPrefix() + "proxy Starting");
        ProxyUtil.registerProxySwitchListener();
        ProxyUtil.setProxyDeployed(true);
        LOGGER.info(ProxyUtil.getInstanceLogPrefix() + "registerProxySwitchListener");



        IteratorStarter iterator = new IteratorStarter();
        submit(iterator);


        AlarmIRPImpl alarmirpImpl = new AlarmIRPImpl(iterator);
        AlarmIRPStarter alarmirp = new AlarmIRPStarter(alarmirpImpl);
        submit(alarmirp);
        /*

        BCMIRPImpl bcmirpImpl = new BCMIRPImpl(iterator);
        BCMIRPStarter bcmirp = new BCMIRPStarter(bcmirpImpl);
        submit(bcmirp);

        ServantStarter csirp = new CSIRPStarter();
        submit(csirp);

        ServantStarter epirp = new EPIRPStarter();
        submit(epirp);

        ServantStarter ftirp = new FTIRPStarter();
        submit(ftirp);

        ServantStarter kcmirp = new KCMIRPStarter();
        submit(kcmirp);

        ServantStarter notificationirp = new NotificationIRPStarter();
        submit(notificationirp);

        ServantStarter notificationTransformer = new NotificationTransformStarter();
        submit(notificationTransformer);*/

        LOGGER.info(ProxyUtil.getInstanceLogPrefix() + "proxy Started");
    }

    public static void submit(Runnable runnable){
        EXECUTOR_SERVICE.execute(new RunnableWaper(runnable));
    }

}
