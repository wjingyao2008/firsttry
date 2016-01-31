package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "CorrelatedNotificationSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CorrelatedNotificationSetTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] value;

    public CorrelatedNotificationSetTypeHolder() {
    }

    public CorrelatedNotificationSetTypeHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return CorrelatedNotificationSetTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = CorrelatedNotificationSetTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        CorrelatedNotificationSetTypeHelper.write(out, value);
    }
}
