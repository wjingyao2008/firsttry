package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL struct "Method".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class Method
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public Method() {
    }

    public java.lang.String name;
    public java.lang.String[] parameter_list;

    public Method(java.lang.String name, java.lang.String[] parameter_list) {
        this.name = name;
        this.parameter_list = parameter_list;
    }
}
