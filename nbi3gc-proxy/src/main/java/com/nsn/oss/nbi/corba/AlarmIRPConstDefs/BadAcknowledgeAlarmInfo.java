package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "BadAcknowledgeAlarmInfo".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAcknowledgeAlarmInfo
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public BadAcknowledgeAlarmInfo() {
    }

    public java.lang.String alarm_information_reference = "";
    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategories failure_category;
    public java.lang.String reason = "";

    public BadAcknowledgeAlarmInfo(java.lang.String alarm_information_reference,
                                   com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategories failure_category,
                                   java.lang.String reason) {
        this.alarm_information_reference = alarm_information_reference;
        this.failure_category = failure_category;
        this.reason = reason;
    }
}
