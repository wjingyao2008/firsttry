package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL enum "SubscriptionState".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class SubscriptionStateHolder
    implements org.omg.CORBA.portable.Streamable {

    public SubscriptionState value;

    public SubscriptionStateHolder() {
    }

    public SubscriptionStateHolder(final SubscriptionState initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return SubscriptionStateHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = SubscriptionStateHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        SubscriptionStateHelper.write(out, value);
    }
}
