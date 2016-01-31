package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL interface "ProbableCause".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ProbableCauseHolder implements org.omg.CORBA.portable.Streamable {

    public ProbableCause value;

    public ProbableCauseHolder() {
    }

    public ProbableCauseHolder(final ProbableCause initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return ProbableCauseHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = ProbableCauseHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        ProbableCauseHelper.write(_out, value);
    }
}
