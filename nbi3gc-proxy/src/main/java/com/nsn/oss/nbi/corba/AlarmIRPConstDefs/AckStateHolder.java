package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL interface "AckState".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AckStateHolder implements org.omg.CORBA.portable.Streamable {

    public AckState value;

    public AckStateHolder() {
    }

    public AckStateHolder(final AckState initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AckStateHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AckStateHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        AckStateHelper.write(_out, value);
    }
}
