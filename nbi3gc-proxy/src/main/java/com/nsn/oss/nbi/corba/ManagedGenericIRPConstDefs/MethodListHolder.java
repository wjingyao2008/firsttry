package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL alias "MethodList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class MethodListHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] value;

    public MethodListHolder() {
    }

    public MethodListHolder(final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return MethodListHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = MethodListHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        MethodListHelper.write(out, value);
    }
}
