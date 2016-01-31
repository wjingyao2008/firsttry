package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "ChangeSubscriptionFilter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class ChangeSubscriptionFilter
    extends org.omg.CORBA.UserException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ChangeSubscriptionFilter() {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.id());
    }

    public java.lang.String reason = "";

    public ChangeSubscriptionFilter(java.lang.String _reason, java.lang.String reason) {
        super(_reason);
        this.reason = reason;
    }

    public ChangeSubscriptionFilter(java.lang.String reason) {
        super(com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.id());
        this.reason = reason;
    }
}
