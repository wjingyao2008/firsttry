package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL alias "SubscriptionIdSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class SubscriptionIdSetHolder
    implements org.omg.CORBA.portable.Streamable {

    public java.lang.String[] value;

    public SubscriptionIdSetHolder() {
    }

    public SubscriptionIdSetHolder(final java.lang.String[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return SubscriptionIdSetHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = SubscriptionIdSetHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        SubscriptionIdSetHelper.write(out, value);
    }
}
