package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL alias "NotificationTypesSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class NotificationTypesSetHolder
    implements org.omg.CORBA.portable.Streamable {

    public java.lang.String[][] value;

    public NotificationTypesSetHolder() {
    }

    public NotificationTypesSetHolder(final java.lang.String[][] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotificationTypesSetHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotificationTypesSetHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        NotificationTypesSetHelper.write(out, value);
    }
}
