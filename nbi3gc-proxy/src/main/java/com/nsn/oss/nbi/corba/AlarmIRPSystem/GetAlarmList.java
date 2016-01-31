package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "GetAlarmList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class GetAlarmList
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public GetAlarmList() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmListHelper.id());
    }

    public java.lang.String reason = "";

    public GetAlarmList(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public GetAlarmList(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmListHelper.id());
        this.reason = reason;
    }
}
