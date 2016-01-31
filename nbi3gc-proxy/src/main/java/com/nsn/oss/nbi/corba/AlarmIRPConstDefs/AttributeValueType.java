package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "AttributeValueType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeValueType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public AttributeValueType() {
    }

    public java.lang.String attribute_name = "";
    public org.omg.CORBA.Any value;

    public AttributeValueType(java.lang.String attribute_name, org.omg.CORBA.Any value) {
        this.attribute_name = attribute_name;
        this.value = value;
    }
}
