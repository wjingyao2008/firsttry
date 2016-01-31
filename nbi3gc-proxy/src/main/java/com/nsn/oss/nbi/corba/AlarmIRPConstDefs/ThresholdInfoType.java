package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "ThresholdInfoType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdInfoType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ThresholdInfoType() {
    }

    public java.lang.String attributeID = "";
    public float observedValue;
    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOpt thresholdLevel;
    public java.lang.String armTime = "";

    public ThresholdInfoType(java.lang.String attributeID, float observedValue,
                             com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOpt thresholdLevel,
                             java.lang.String armTime) {
        this.attributeID = attributeID;
        this.observedValue = observedValue;
        this.thresholdLevel = thresholdLevel;
        this.armTime = armTime;
    }
}
