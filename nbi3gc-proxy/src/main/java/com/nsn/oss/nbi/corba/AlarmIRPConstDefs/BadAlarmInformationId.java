package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "BadAlarmInformationId".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAlarmInformationId
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public BadAlarmInformationId() {
    }

    public java.lang.String alarm_information_reference = "";
    public java.lang.String reason = "";

    public BadAlarmInformationId(java.lang.String alarm_information_reference, java.lang.String reason) {
        this.alarm_information_reference = alarm_information_reference;
        this.reason = reason;
    }
}
