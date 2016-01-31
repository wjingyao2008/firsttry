package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "UnacknowledgeAlarms".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class UnacknowledgeAlarms
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public UnacknowledgeAlarms() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.id());
    }

    public java.lang.String reason = "";

    public UnacknowledgeAlarms(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public UnacknowledgeAlarms(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.id());
        this.reason = reason;
    }
}
