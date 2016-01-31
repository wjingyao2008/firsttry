package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "ClearAlarms".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class ClearAlarms
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ClearAlarms() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarmsHelper.id());
    }

    public java.lang.String reason = "";

    public ClearAlarms(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public ClearAlarms(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarmsHelper.id());
        this.reason = reason;
    }
}
