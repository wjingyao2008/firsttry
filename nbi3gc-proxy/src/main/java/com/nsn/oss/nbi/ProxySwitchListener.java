package com.nsn.oss.nbi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nsn.oss.nbi.common.Logger;

import com.nsn.oss.nbi.common.utils.DynConfiguration.DynConfigurationListener;

public class ProxySwitchListener implements DynConfigurationListener {

    private static final Logger LOGGER = Logger.getLogger(ProxySwitchListener.class);
    private final static String IS_DEPLOYED = "com.nsn.oss.nbi.proxy.isDeployed";

    @Override
    public void onChange(String configurationName, File file) {

        InputStream in = null;
        try {
            Properties prop = new Properties();
            in = new FileInputStream(file);
            prop.load(in);
            boolean isDeployed = prop.get(IS_DEPLOYED) == null ? false : "true"
                .equalsIgnoreCase(prop.get(IS_DEPLOYED).toString().trim());
            ProxyUtil.setProxyDeployed(isDeployed);
        } catch (FileNotFoundException e) {
            ProxyUtil.setProxyDeployed(false);
            LOGGER.error("FileNotFoundException " + e.getMessage());
        } catch (IOException e) {
            ProxyUtil.setProxyDeployed(false);
            LOGGER.error("IOException " + e.getMessage());
        } finally {
            if (!ProxyUtil.isProxyDeployed()) {
                LOGGER.info(
                    ProxyUtil.getInstanceLogPrefix() + "proxy has been undeployed,all interfaces are not available");
            }
            ProxyUtil.close(in);
        }

    }

    @Override
    public void onChange(String configurationName, File[] filelist) {

    }

}
