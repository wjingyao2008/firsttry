package com.nsn.oss.nbi;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;

import com.nsn.oss.nbi.common.Logger;
import com.nsn.oss.nbi.common.utils.DynConfiguration.DynConfigurationListener;
import com.nsn.oss.nbi.common.utils.DynConfiguration.DynConfigurationManager;

public class ProxyUtil {

    public static final String REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED = "Entry point is unreachable";
    private static boolean isInvoked = false;
    private static String proxyInstanceId = null;
    private static HashMap<String, HashMap<String, String>>
        portMapping =
        new HashMap<String, HashMap<String, String>>();
    private static boolean isProxyDeployed = false;
    public static final String DEFAULT_PROXY_INSTANCE_ID = "1";

    static {
        initPortMapping();
    }

    public static boolean isProxyDeployed() {
        return isProxyDeployed;
    }

    public static void setProxyDeployed(boolean isProxyDeployed) {
        ProxyUtil.isProxyDeployed = isProxyDeployed;
    }

    public static String getProxyInstanceId() {
        if (isInvoked) {
            return proxyInstanceId;
        }
        proxyInstanceId = System.getProperty("proxyInstanceId");

        if (proxyInstanceId == null || proxyInstanceId.trim().isEmpty()) {
            proxyInstanceId = DEFAULT_PROXY_INSTANCE_ID;
        }
        isInvoked = true;
        return proxyInstanceId;

    }

    public static String getInstanceLogPrefix() {
        return "proxy-" + getProxyInstanceId() + ">>>";
    }

    public static String getPortByInstanceIdandKey(String instanceId, String key) {
        return portMapping.get(instanceId).get(key);
    }

    public static void registerProxySwitchListener() {

//        DynConfigurationListener proxyListener = new ProxySwitchListener();
//        DynConfigurationManager.register(proxyListener,
//                                         System.getProperty("rootPath") + "proxy-" + ProxyUtil.getProxyInstanceId()
//                                         + "/nbi3gc-proxy.properties");
    }

    public static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                // ignore IOException
            }
        }
    }

    private static void initPortMapping() {
        HashMap<String, String> instance1Ports = new HashMap<String, String>();
//        instance1Ports.put(FTIRPStarter.class.getName(), "8289");
//        instance1Ports.put(BCMIRPStarter.class.getName(), "8290");
        instance1Ports.put(AlarmIRPStarter.class.getName(), "8291");
        instance1Ports.put(NotificationIRPStarter.class.getName(), "8292");
//        instance1Ports.put(EPIRPStarter.class.getName(), "8293");
//        instance1Ports.put(CSIRPStarter.class.getName(), "8294");
//        instance1Ports.put(KCMIRPStarter.class.getName(), "8295");
        instance1Ports.put(NotificationTransformStarter.class.getName(), "8297");
        instance1Ports.put(IteratorStarter.class.getName(), "8299");

//        HashMap<String, String> instance2Ports = new HashMap<String, String>();
////        instance2Ports.put(FTIRPStarter.class.getName(), "8269");
////        instance2Ports.put(BCMIRPStarter.class.getName(), "8270");
//        instance2Ports.put(AlarmIRPStarter.class.getName(), "8271");
//        instance2Ports.put(NotificationIRPStarter.class.getName(), "8272");
//        instance2Ports.put(EPIRPStarter.class.getName(), "8273");
//        instance2Ports.put(CSIRPStarter.class.getName(), "8274");
//        instance2Ports.put(KCMIRPStarter.class.getName(), "8275");
//        instance2Ports.put(NotificationTransformStarter.class.getName(), "8277");
//        instance2Ports.put(IteratorStarter.class.getName(), "8279");
//
//        HashMap<String, String> instance3Ports = new HashMap<String, String>();
//        instance3Ports.put(FTIRPStarter.class.getName(), "8249");
//        instance3Ports.put(BCMIRPStarter.class.getName(), "8250");
//        instance3Ports.put(AlarmIRPStarter.class.getName(), "8251");
//        instance3Ports.put(NotificationIRPStarter.class.getName(), "8252");
//        instance3Ports.put(EPIRPStarter.class.getName(), "8253");
//        instance3Ports.put(CSIRPStarter.class.getName(), "8254");
//        instance3Ports.put(KCMIRPStarter.class.getName(), "8255");
//        instance3Ports.put(NotificationTransformStarter.class.getName(), "8257");
//        instance3Ports.put(IteratorStarter.class.getName(), "8259");

        portMapping.put("1", instance1Ports);
//        portMapping.put("2", instance2Ports);
//        portMapping.put("3", instance3Ports);
    }

}
