package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "UnsignedLongTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class UnsignedLongTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public UnsignedLongTypeOpt value;

    public UnsignedLongTypeOptHolder() {
    }

    public UnsignedLongTypeOptHolder(final UnsignedLongTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return UnsignedLongTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = UnsignedLongTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        UnsignedLongTypeOptHelper.write(out, value);
    }
}
