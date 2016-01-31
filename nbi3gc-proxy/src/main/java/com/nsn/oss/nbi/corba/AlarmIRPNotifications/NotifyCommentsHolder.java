package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyComments".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyCommentsHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyComments value;

    public NotifyCommentsHolder() {
    }

    public NotifyCommentsHolder(final NotifyComments initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyCommentsHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyCommentsHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyCommentsHelper.write(_out, value);
    }
}
