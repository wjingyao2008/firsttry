package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "AlarmInformationIdAndSev".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdAndSev
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public AlarmInformationIdAndSev() {
    }

    public java.lang.String alarm_information_reference = "";
    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ShortTypeOpt perceived_severity;

    public AlarmInformationIdAndSev(java.lang.String alarm_information_reference,
                                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ShortTypeOpt perceived_severity) {
        this.alarm_information_reference = alarm_information_reference;
        this.perceived_severity = perceived_severity;
    }
}
