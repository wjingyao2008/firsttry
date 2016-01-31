package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

/**
 * Generated from IDL interface "NotifyPotentialFaultyAlarmList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyPotentialFaultyAlarmListHolder implements org.omg.CORBA.portable.Streamable {

    public NotifyPotentialFaultyAlarmList value;

    public NotifyPotentialFaultyAlarmListHolder() {
    }

    public NotifyPotentialFaultyAlarmListHolder(final NotifyPotentialFaultyAlarmList initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifyPotentialFaultyAlarmListHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifyPotentialFaultyAlarmListHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotifyPotentialFaultyAlarmListHelper.write(_out, value);
    }
}
