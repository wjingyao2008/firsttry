package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "ParameterNotSupported".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class ParameterNotSupportedHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported value;

    public ParameterNotSupportedHolder() {
    }

    public ParameterNotSupportedHolder(
        final com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, value);
    }
}
