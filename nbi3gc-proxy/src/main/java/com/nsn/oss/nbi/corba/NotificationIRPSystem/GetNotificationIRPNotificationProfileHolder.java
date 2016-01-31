package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "GetNotificationIRPNotificationProfile".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class GetNotificationIRPNotificationProfileHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile value;

    public GetNotificationIRPNotificationProfileHolder() {
    }

    public GetNotificationIRPNotificationProfileHolder(
        final com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfileHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfileHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfileHelper.write(_out, value);
    }
}
