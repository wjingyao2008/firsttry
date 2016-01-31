package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyAckStateChanged".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyAckStateChangedHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyAckStateChanged value;

    public NotifyAckStateChangedHolder() {
    }

    public NotifyAckStateChangedHolder(final NotifyAckStateChanged initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyAckStateChangedHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyAckStateChangedHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyAckStateChangedHelper.write(_out, value);
    }
}
