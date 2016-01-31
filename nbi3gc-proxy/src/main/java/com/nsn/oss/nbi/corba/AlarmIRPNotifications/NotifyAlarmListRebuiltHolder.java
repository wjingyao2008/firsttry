package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyAlarmListRebuilt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyAlarmListRebuiltHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyAlarmListRebuilt value;

    public NotifyAlarmListRebuiltHolder() {
    }

    public NotifyAlarmListRebuiltHolder(final NotifyAlarmListRebuilt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyAlarmListRebuiltHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyAlarmListRebuiltHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyAlarmListRebuiltHelper.write(_out, value);
    }
}
