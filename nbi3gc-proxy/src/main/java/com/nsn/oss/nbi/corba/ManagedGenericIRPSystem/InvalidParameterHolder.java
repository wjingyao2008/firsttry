package com.nsn.oss.nbi.corba.ManagedGenericIRPSystem;

/**
 * Generated from IDL exception "InvalidParameter".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class InvalidParameterHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter value;

    public InvalidParameterHolder() {
    }

    public InvalidParameterHolder(final com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, value);
    }
}
