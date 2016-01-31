package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "CommentAlarms".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class CommentAlarms
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public CommentAlarms() {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarmsHelper.id());
    }

    public java.lang.String reason = "";

    public CommentAlarms(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public CommentAlarms(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarmsHelper.id());
        this.reason = reason;
    }
}
