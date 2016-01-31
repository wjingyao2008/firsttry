package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "ThresholdIndicationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdIndicationTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public ThresholdIndicationType value;

    public ThresholdIndicationTypeHolder() {
    }

    public ThresholdIndicationTypeHolder(final ThresholdIndicationType initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return ThresholdIndicationTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = ThresholdIndicationTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        ThresholdIndicationTypeHelper.write(out, value);
    }
}
