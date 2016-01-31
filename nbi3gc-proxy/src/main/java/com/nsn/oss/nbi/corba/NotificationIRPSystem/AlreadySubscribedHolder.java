package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "AlreadySubscribed".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class AlreadySubscribedHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed value;

    public AlreadySubscribedHolder() {
    }

    public AlreadySubscribedHolder(final com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.write(_out, value);
    }
}
