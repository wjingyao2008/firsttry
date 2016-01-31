package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyClearedAlarm".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyClearedAlarmHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyClearedAlarm value;

    public NotifyClearedAlarmHolder() {
    }

    public NotifyClearedAlarmHolder(final NotifyClearedAlarm initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyClearedAlarmHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyClearedAlarmHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyClearedAlarmHelper.write(_out, value);
    }
}
