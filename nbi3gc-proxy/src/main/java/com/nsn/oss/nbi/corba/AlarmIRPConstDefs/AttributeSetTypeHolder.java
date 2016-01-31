package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AttributeSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeSetTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType[] value;

    public AttributeSetTypeHolder() {
    }

    public AttributeSetTypeHolder(final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AttributeSetTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AttributeSetTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AttributeSetTypeHelper.write(out, value);
    }
}
