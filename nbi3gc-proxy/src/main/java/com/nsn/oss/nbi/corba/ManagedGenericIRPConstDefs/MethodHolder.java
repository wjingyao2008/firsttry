package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL struct "Method".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class MethodHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method value;

    public MethodHolder() {
    }

    public MethodHolder(final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodHelper.write(_out, value);
    }
}
