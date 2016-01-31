package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "TrendIndicationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class TrendIndicationTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public TrendIndicationType value;

    public TrendIndicationTypeHolder() {
    }

    public TrendIndicationTypeHolder(final TrendIndicationType initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return TrendIndicationTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = TrendIndicationTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        TrendIndicationTypeHelper.write(out, value);
    }
}
