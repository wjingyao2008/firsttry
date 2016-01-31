package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL interface "AlarmInformationIterator".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class AlarmInformationIteratorHolder implements org.omg.CORBA.portable.Streamable {

    public AlarmInformationIterator value;

    public AlarmInformationIteratorHolder() {
    }

    public AlarmInformationIteratorHolder(final AlarmInformationIterator initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmInformationIteratorHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmInformationIteratorHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        AlarmInformationIteratorHelper.write(_out, value);
    }
}
