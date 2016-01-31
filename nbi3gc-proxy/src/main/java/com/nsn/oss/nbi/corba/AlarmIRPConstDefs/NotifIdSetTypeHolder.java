package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "NotifIdSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class NotifIdSetTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public int[] value;

    public NotifIdSetTypeHolder() {
    }

    public NotifIdSetTypeHolder(final int[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotifIdSetTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotifIdSetTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        NotifIdSetTypeHelper.write(out, value);
    }
}
