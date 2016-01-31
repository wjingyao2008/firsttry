package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL interface "AttributeNameValue".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class AttributeNameValueHolder implements org.omg.CORBA.portable.Streamable {

    public AttributeNameValue value;

    public AttributeNameValueHolder() {
    }

    public AttributeNameValueHolder(final AttributeNameValue initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AttributeNameValueHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AttributeNameValueHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        AttributeNameValueHelper.write(_out, value);
    }
}
