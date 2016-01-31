package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "BadAlarmInformationIdSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAlarmInformationIdSeqHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] value;

    public BadAlarmInformationIdSeqHolder() {
    }

    public BadAlarmInformationIdSeqHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return BadAlarmInformationIdSeqHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = BadAlarmInformationIdSeqHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        BadAlarmInformationIdSeqHelper.write(out, value);
    }
}
