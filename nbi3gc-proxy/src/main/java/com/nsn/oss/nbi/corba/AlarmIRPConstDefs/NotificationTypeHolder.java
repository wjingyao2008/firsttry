package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL interface "NotificationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class NotificationTypeHolder implements org.omg.CORBA.portable.Streamable {

    public NotificationType value;

    public NotificationTypeHolder() {
    }

    public NotificationTypeHolder(final NotificationType initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotificationTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotificationTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotificationTypeHelper.write(_out, value);
    }
}
