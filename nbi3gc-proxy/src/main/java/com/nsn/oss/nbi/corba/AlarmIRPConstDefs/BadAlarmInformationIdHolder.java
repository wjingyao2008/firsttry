package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "BadAlarmInformationId".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAlarmInformationIdHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId value;

    public BadAlarmInformationIdHolder() {
    }

    public BadAlarmInformationIdHolder(final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.write(_out, value);
    }
}
