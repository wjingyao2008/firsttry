package com.nsn.oss.nbi.corba.NotificationTransformSystem;

/**
 * Generated from IDL exception "Transform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class TransformHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform value;

    public TransformHolder() {
    }

    public TransformHolder(final com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.write(_out, value);
    }
}
