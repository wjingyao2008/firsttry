package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class NotificationIRPHolder implements org.omg.CORBA.portable.Streamable {

    public NotificationIRP value;

    public NotificationIRPHolder() {
    }

    public NotificationIRPHolder(final NotificationIRP initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotificationIRPHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotificationIRPHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotificationIRPHelper.write(_out, value);
    }
}
