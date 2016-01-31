package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyNewAlarm".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyNewAlarmHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyNewAlarm value;

    public NotifyNewAlarmHolder() {
    }

    public NotifyNewAlarmHolder(final NotifyNewAlarm initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyNewAlarmHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyNewAlarmHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyNewAlarmHelper.write(_out, value);
    }
}
