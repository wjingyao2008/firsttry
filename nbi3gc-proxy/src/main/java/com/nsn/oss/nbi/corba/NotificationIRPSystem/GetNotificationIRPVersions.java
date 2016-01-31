package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "GetNotificationIRPVersions".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class GetNotificationIRPVersions
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public GetNotificationIRPVersions() {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersionsHelper.id());
    }

    public java.lang.String reason = "";

    public GetNotificationIRPVersions(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public GetNotificationIRPVersions(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersionsHelper.id());
        this.reason = reason;
    }
}
