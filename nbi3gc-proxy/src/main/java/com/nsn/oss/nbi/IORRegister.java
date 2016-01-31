package com.nsn.oss.nbi;

public interface IORRegister {

    void register(String name, org.omg.CORBA.Object servant) throws Exception;
}
