package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "GetAlarmIRPNotificationProfile".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class GetAlarmIRPNotificationProfileHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile value;

    public GetAlarmIRPNotificationProfileHolder() {
    }

    public GetAlarmIRPNotificationProfileHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfileHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfileHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfileHelper.write(_out, value);
    }
}
