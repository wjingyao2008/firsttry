package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL union "FloatTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class FloatTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public FloatTypeOpt value;

    public FloatTypeOptHolder() {
    }

    public FloatTypeOptHolder(final FloatTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return FloatTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = FloatTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        FloatTypeOptHelper.write(out, value);
    }
}
