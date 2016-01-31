package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "ParameterNotSupported".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class ParameterNotSupported
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ParameterNotSupported() {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.id());
    }

    public java.lang.String parameter = "";

    public ParameterNotSupported(java.lang.String _reason, java.lang.String parameter) {
        super(_reason);
        this.parameter = parameter;
    }

    public ParameterNotSupported(java.lang.String parameter) {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.id());
        this.parameter = parameter;
    }
}
