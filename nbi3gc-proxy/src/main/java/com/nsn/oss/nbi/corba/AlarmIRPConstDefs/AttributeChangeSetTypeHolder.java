package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AttributeChangeSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeChangeSetTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType[] value;

    public AttributeChangeSetTypeHolder() {
    }

    public AttributeChangeSetTypeHolder(
        final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AttributeChangeSetTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AttributeChangeSetTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AttributeChangeSetTypeHelper.write(out, value);
    }
}
