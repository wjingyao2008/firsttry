package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "Attach".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class Attach
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public Attach() {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.id());
    }

    public java.lang.String reason = "";

    public Attach(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public Attach(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.id());
        this.reason = reason;
    }
}
