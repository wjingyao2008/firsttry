package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AlarmInformationIdAndSevSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdAndSevSeqHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] value;

    public AlarmInformationIdAndSevSeqHolder() {
    }

    public AlarmInformationIdAndSevSeqHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmInformationIdAndSevSeqHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmInformationIdAndSevSeqHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AlarmInformationIdAndSevSeqHelper.write(out, value);
    }
}
