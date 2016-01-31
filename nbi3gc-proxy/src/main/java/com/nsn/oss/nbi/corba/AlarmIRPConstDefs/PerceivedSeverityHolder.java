package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL interface "PerceivedSeverity".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class PerceivedSeverityHolder implements org.omg.CORBA.portable.Streamable {

    public PerceivedSeverity value;

    public PerceivedSeverityHolder() {
    }

    public PerceivedSeverityHolder(final PerceivedSeverity initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return PerceivedSeverityHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = PerceivedSeverityHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        PerceivedSeverityHelper.write(_out, value);
    }
}
