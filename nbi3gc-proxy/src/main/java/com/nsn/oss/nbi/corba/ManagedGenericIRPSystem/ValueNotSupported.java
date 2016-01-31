package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "ValueNotSupported".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class ValueNotSupported
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ValueNotSupported() {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ValueNotSupportedHelper.id());
    }

    public java.lang.String parameter = "";

    public ValueNotSupported(java.lang.String _reason, java.lang.String parameter) {
        super(_reason);
        this.parameter = parameter;
    }

    public ValueNotSupported(java.lang.String parameter) {
        super(com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ValueNotSupportedHelper.id());
        this.parameter = parameter;
    }
}
