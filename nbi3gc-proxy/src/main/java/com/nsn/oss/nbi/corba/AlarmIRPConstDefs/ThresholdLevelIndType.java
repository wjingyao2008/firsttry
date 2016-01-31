package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "ThresholdLevelIndType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdLevelIndType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ThresholdLevelIndType() {
    }

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdIndicationType indication;
    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.FloatTypeOpt low;
    public float high;

    public ThresholdLevelIndType(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdIndicationType indication,
                                 com.nsn.oss.nbi.corba.AlarmIRPConstDefs.FloatTypeOpt low, float high) {
        this.indication = indication;
        this.low = low;
        this.high = high;
    }
}
