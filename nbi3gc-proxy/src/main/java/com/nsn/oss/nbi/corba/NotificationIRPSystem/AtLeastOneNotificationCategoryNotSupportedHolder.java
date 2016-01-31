package com.nsn.oss.nbi.corba.NotificationIRPSystem;

/**
 * Generated from IDL exception "AtLeastOneNotificationCategoryNotSupported".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class AtLeastOneNotificationCategoryNotSupportedHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported value;

    public AtLeastOneNotificationCategoryNotSupportedHolder() {
    }

    public AtLeastOneNotificationCategoryNotSupportedHolder(
        final com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper.write(_out, value);
    }
}
