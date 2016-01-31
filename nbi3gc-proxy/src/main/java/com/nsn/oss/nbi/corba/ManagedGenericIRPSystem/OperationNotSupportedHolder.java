package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "OperationNotSupported".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class OperationNotSupportedHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported value;

    public OperationNotSupportedHolder() {
    }

    public OperationNotSupportedHolder(
        final com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, value);
    }
}
