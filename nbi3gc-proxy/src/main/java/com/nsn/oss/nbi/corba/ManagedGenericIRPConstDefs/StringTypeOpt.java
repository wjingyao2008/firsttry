package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "StringTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class StringTypeOpt
    implements org.omg.CORBA.portable.IDLEntity {

    private boolean discriminator;
    private java.lang.String value;

    public StringTypeOpt() {
    }

    public boolean discriminator() {
        return discriminator;
    }

    public java.lang.String value() {
        if (discriminator != true) {
            throw new org.omg.CORBA.BAD_OPERATION();
        }
        return value;
    }

    public void value(java.lang.String _x) {
        discriminator = true;
        value = _x;
    }

    public void __default() {
        discriminator = false;
    }

    public void __default(boolean _discriminator) {
        if (_discriminator == true) {
            throw new org.omg.CORBA.BAD_PARAM("Illegal value is used in __default method", 34,
                                              org.omg.CORBA.CompletionStatus.COMPLETED_NO);
        }

        discriminator = _discriminator;
    }
}
