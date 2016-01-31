package com.nsn.oss.nbi.corba.NotificationIRPNotifications;

/**
 * Generated from IDL interface "Notify".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:03
 */

public final class NotifyHolder implements org.omg.CORBA.portable.Streamable {

    public Notify value;

    public NotifyHolder() {
    }

    public NotifyHolder(final Notify initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyHelper.write(_out, value);
    }
}
