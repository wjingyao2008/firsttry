package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyChangedAlarm".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyChangedAlarmHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyChangedAlarm value;

    public NotifyChangedAlarmHolder() {
    }

    public NotifyChangedAlarmHolder(final NotifyChangedAlarm initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyChangedAlarmHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyChangedAlarmHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyChangedAlarmHelper.write(_out, value);
    }
}
