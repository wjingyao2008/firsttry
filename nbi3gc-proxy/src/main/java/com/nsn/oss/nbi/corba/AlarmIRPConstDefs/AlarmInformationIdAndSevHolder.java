package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "AlarmInformationIdAndSev".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdAndSevHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev value;

    public AlarmInformationIdAndSevHolder() {
    }

    public AlarmInformationIdAndSevHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper.write(_out, value);
    }
}
