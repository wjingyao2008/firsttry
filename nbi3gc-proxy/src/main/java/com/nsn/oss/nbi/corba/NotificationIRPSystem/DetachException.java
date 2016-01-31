package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "DetachException".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class DetachException
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public DetachException() {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachExceptionHelper.id());
    }

    public java.lang.String reason = "";

    public DetachException(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public DetachException(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachExceptionHelper.id());
        this.reason = reason;
    }
}
