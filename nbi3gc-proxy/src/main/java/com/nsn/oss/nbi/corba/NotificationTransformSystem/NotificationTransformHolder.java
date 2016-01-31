package com.nsn.oss.nbi.corba.NotificationTransformSystem;

/**
 * Generated from IDL interface "NotificationTransform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotificationTransformHolder implements org.omg.CORBA.portable.Streamable {

    public NotificationTransform value;

    public NotificationTransformHolder() {
    }

    public NotificationTransformHolder(final NotificationTransform initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return NotificationTransformHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = NotificationTransformHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        NotificationTransformHelper.write(_out, value);
    }
}
