package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "ChangeSubscriptionFilter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class ChangeSubscriptionFilterHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter value;

    public ChangeSubscriptionFilterHolder() {
    }

    public ChangeSubscriptionFilterHolder(
        final com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.write(_out, value);
    }
}
