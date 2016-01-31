package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "BadAcknowledgeAlarmInfoSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAcknowledgeAlarmInfoSeqHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo[] value;

    public BadAcknowledgeAlarmInfoSeqHolder() {
    }

    public BadAcknowledgeAlarmInfoSeqHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return BadAcknowledgeAlarmInfoSeqHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = BadAcknowledgeAlarmInfoSeqHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        BadAcknowledgeAlarmInfoSeqHelper.write(out, value);
    }
}
