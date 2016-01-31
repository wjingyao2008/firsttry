package com.nsn.oss.nbi;

import java.io.File;

import org.apache.commons.io.FileUtils;


public class FileServiceRegister implements IORRegister {

    @Override
    public void register(String name, org.omg.CORBA.Object servant) throws Exception {
        try {
            String filePath = InternalServiceServiceLocator.getIORFilder() + File.separator + name + ".ior";
            File file = new File(filePath);
            org.omg.CORBA.ORB orb = CorbaUtils.getOrb();
            String ior = orb.object_to_string(servant);
            FileUtils.writeStringToFile(file, ior);
        } catch (Exception e) {
            throw e;
        }

    }

}
