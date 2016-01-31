package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "GetAlarmIRPOperationsProfile".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class GetAlarmIRPOperationsProfile
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public GetAlarmIRPOperationsProfile() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfileHelper.id());
    }

    public java.lang.String reason = "";

    public GetAlarmIRPOperationsProfile(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public GetAlarmIRPOperationsProfile(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfileHelper.id());
        this.reason = reason;
    }
}
