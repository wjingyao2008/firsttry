package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "InvalidParameter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class InvalidParameter
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public InvalidParameter() {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.id());
    }

    public java.lang.String parameter = "";

    public InvalidParameter(java.lang.String _reason, java.lang.String parameter) {
        super(_reason);
        this.parameter = parameter;
    }

    public InvalidParameter(java.lang.String parameter) {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.id());
        this.parameter = parameter;
    }
}
