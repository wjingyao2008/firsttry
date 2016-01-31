package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL union "ThresholdLevelIndTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdLevelIndTypeOpt
    implements org.omg.CORBA.portable.IDLEntity {

    private boolean discriminator;
    private com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType value;

    public ThresholdLevelIndTypeOpt() {
    }

    public boolean discriminator() {
        return discriminator;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType value() {
        if (discriminator != true) {
            throw new org.omg.CORBA.BAD_OPERATION();
        }
        return value;
    }

    public void value(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType _x) {
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
