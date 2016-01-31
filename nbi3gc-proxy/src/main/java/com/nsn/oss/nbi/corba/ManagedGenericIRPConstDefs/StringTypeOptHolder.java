package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "StringTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class StringTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public StringTypeOpt value;

    public StringTypeOptHolder() {
    }

    public StringTypeOptHolder(final StringTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return StringTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = StringTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        StringTypeOptHelper.write(out, value);
    }
}
