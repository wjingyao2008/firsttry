package com.nsn.oss.nbi;

import com.nsn.oss.nbi.common.Logger;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class NamingServiceRegister implements IORRegister {

    private final static Logger LOGGER = Logger.getLogger(NamingServiceRegister.class);

    private static final String NAMING_SERVICE = "NameService";
    private static final int RETRY_INTERVAL = 1000;
    private ORB orb = CorbaUtils.getOrb();

    @Override
    public void register(String irpId, org.omg.CORBA.Object servant) throws NotFound, CannotProceed, InvalidName {
//        IRPInfo irpInfo = IRPInfoService.getInstance().getIRPInfoById(irpId);
//        String bindingName = irpInfo.getIdInNamingService();
//        NamingContextExt nc = getNamingService();
//        if (ProxyUtil.DEFAULT_PROXY_INSTANCE_ID.equals(ProxyUtil.getProxyInstanceId())) {
//            nc.rebind(nc.to_name(bindingName), servant);
//            LOGGER.info("Keep old name for compatibility>>>" + irpId + " is bound to Naming Service " + bindingName);
//        }
//        bindingName = "proxy-" + ProxyUtil.getProxyInstanceId() + "/" + bindingName;
//        nc.rebind(nc.to_name(bindingName), servant);
//        LOGGER.info(irpId + " is bound to Naming Service " + bindingName);
    }

    public void createNamingContext() {
//        NamingContextExt nc = getNamingService();
//        String[] needToCreate = {
//            "filters",
//            "rel_6",
//            "rel_10",
//            "proxy-1",
//            "proxy-2",
//            "proxy-3",
//            "proxy-1/rel_6",
//            "proxy-1/rel_10",
//            "proxy-2/rel_6",
//            "proxy-2/rel_10",
//            "proxy-3/rel_6",
//            "proxy-3/rel_10"
//        };
//        for (String namingContext : needToCreate) {
//            while (true) {
//                try {
//                    nc.bind_new_context(nc.to_name(namingContext));
//                    LOGGER.info("Naming Context " + namingContext + " is created");
//                    break;
//                } catch (AlreadyBound e) {
//                    LOGGER.info("Naming Context " + namingContext + " is AlreadyBound");
//                    break;
//                } catch (Exception e) {
//                    LOGGER.error(
//                        "Naming Context " + namingContext + " create failed, will try again later:" + e.getMessage());
//                    try {
//                        int sleepTime = 1000;
//                        Thread.sleep(sleepTime);
//                    } catch (InterruptedException e1) {
//                        //fail to sheep
//                    }
//                }
//            }
//        }
    }

    protected NamingContextExt getNamingService() {

//        while (true) {
//            try {
//                NamingContextExt
//                    namingService =
//                    NamingContextExtHelper.narrow(orb.resolve_initial_references(NAMING_SERVICE));
//                if (namingService._non_existent()) {
//                    throw new NotFound();
//                }
//                return namingService;
//            } catch (Exception e) {
//                LOGGER.warn("Fail to find Naming Service. Will retry later.", e);
//                try {
//                    Thread.sleep(RETRY_INTERVAL);
//                } catch (InterruptedException e1) {
//                    LOGGER.warn("Fail to sleep");
//                }
//            }
//
//        }
        return  null;
    }
}
