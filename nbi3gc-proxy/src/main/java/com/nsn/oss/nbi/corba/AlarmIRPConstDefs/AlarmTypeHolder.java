package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL interface "AlarmType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmTypeHolder implements org.omg.CORBA.portable.Streamable {

    public AlarmType value;

    public AlarmTypeHolder() {
    }

    public AlarmTypeHolder(final AlarmType initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        AlarmTypeHelper.write(_out, value);
    }
}
