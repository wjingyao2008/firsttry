package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL union "FloatTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class FloatTypeOpt
    implements org.omg.CORBA.portable.IDLEntity {

    private boolean discriminator;
    private float value;

    public FloatTypeOpt() {
    }

    public boolean discriminator() {
        return discriminator;
    }

    public float value() {
        if (discriminator != true) {
            throw new org.omg.CORBA.BAD_OPERATION();
        }
        return value;
    }

    public void value(float _x) {
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
