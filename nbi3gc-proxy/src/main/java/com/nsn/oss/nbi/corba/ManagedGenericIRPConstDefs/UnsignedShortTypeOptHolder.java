package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "UnsignedShortTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class UnsignedShortTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public UnsignedShortTypeOpt value;

    public UnsignedShortTypeOptHolder() {
    }

    public UnsignedShortTypeOptHolder(final UnsignedShortTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return UnsignedShortTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = UnsignedShortTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        UnsignedShortTypeOptHelper.write(out, value);
    }
}
