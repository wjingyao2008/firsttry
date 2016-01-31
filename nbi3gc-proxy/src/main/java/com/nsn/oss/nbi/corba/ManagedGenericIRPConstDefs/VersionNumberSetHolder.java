package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL alias "VersionNumberSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class VersionNumberSetHolder
    implements org.omg.CORBA.portable.Streamable {

    public java.lang.String[] value;

    public VersionNumberSetHolder() {
    }

    public VersionNumberSetHolder(final java.lang.String[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return VersionNumberSetHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = VersionNumberSetHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        VersionNumberSetHelper.write(out, value);
    }
}
