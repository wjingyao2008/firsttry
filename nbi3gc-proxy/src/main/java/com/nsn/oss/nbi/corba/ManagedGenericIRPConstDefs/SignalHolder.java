package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL enum "Signal".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class SignalHolder
    implements org.omg.CORBA.portable.Streamable {

    public Signal value;

    public SignalHolder() {
    }

    public SignalHolder(final Signal initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return SignalHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = SignalHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        SignalHelper.write(out, value);
    }
}
