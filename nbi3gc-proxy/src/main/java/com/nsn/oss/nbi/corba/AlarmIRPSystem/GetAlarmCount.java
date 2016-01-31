package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "GetAlarmCount".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class GetAlarmCount
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public GetAlarmCount() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCountHelper.id());
    }

    public java.lang.String reason = "";

    public GetAlarmCount(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public GetAlarmCount(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCountHelper.id());
        this.reason = reason;
    }
}
