package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL interface "AlarmIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class AlarmIRPHolder implements org.omg.CORBA.portable.Streamable {

    public AlarmIRP value;

    public AlarmIRPHolder() {
    }

    public AlarmIRPHolder(final AlarmIRP initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmIRPHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmIRPHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        AlarmIRPHelper.write(_out, value);
    }
}
