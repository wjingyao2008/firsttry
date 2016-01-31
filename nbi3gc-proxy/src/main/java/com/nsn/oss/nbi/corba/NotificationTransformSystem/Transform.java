package com.nsn.oss.nbi.corba.NotificationTransformSystem;

/**
 * Generated from IDL exception "Transform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class Transform
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public Transform() {
        super(com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.id());
    }

    public java.lang.String reason = "";

    public Transform(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public Transform(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.id());
        this.reason = reason;
    }
}
