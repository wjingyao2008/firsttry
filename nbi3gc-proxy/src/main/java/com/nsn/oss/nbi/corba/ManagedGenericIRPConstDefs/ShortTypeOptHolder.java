package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "ShortTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class ShortTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public ShortTypeOpt value;

    public ShortTypeOptHolder() {
    }

    public ShortTypeOptHolder(final ShortTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return ShortTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = ShortTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        ShortTypeOptHelper.write(out, value);
    }
}
