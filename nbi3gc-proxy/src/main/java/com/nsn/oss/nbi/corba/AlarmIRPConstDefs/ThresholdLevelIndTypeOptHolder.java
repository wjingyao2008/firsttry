package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL union "ThresholdLevelIndTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdLevelIndTypeOptHolder
    implements org.omg.CORBA.portable.Streamable {

    public ThresholdLevelIndTypeOpt value;

    public ThresholdLevelIndTypeOptHolder() {
    }

    public ThresholdLevelIndTypeOptHolder(final ThresholdLevelIndTypeOpt initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return ThresholdLevelIndTypeOptHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = ThresholdLevelIndTypeOptHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        ThresholdLevelIndTypeOptHelper.write(out, value);
    }
}
