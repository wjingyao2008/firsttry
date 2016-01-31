package com.nsn.oss.nbi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import com.nsn.oss.nbi.common.Logger;

public class CorbaUtils {

    private static final Logger LOGGER = Logger.getLogger(CorbaUtils.class);

    private CorbaUtils() {
    }

    public static org.omg.CORBA.ORB getOrb() {
        return getOrb(new Properties());
    }

    public static org.omg.CORBA.ORB getOrb(Properties properties) {
        String instanceId = ProxyUtil.getProxyInstanceId();
        String rootPath = System.getProperty("rootPath");
        String jacOrbFilePath = rootPath + "proxy-" + instanceId + "/jacorb.properties";

        File jacOrbFile = new File(jacOrbFilePath);
        if (!jacOrbFile.isFile()) {
            String reason = "Fail to find jacorb.properties " + jacOrbFilePath;
            LOGGER.error(reason);

        }

        InputStream in = null;
        Properties p = new Properties();
        try {
            in = new FileInputStream(jacOrbFile);
            p.load(in);
        } catch (IOException e) {
            String reason = "Fail to read jacorb.properties " + jacOrbFilePath;
            LOGGER.error(reason);
        } finally {
            IOUtils.closeQuietly(in);
        }

        p.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
        p.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
        p.putAll(properties);
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[]{}, p);
        return orb;
    }


}
