package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AlarmInformationIdSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdSeqHolder
    implements org.omg.CORBA.portable.Streamable {

    public java.lang.String[] value;

    public AlarmInformationIdSeqHolder() {
    }

    public AlarmInformationIdSeqHolder(final java.lang.String[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmInformationIdSeqHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmInformationIdSeqHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AlarmInformationIdSeqHelper.write(out, value);
    }
}
