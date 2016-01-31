package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "AttributeValueChangeType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeValueChangeType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public AttributeValueChangeType() {
    }

    public java.lang.String attribute_name = "";
    public org.omg.CORBA.Any old_value;
    public org.omg.CORBA.Any new_value;

    public AttributeValueChangeType(java.lang.String attribute_name, org.omg.CORBA.Any old_value,
                                    org.omg.CORBA.Any new_value) {
        this.attribute_name = attribute_name;
        this.old_value = old_value;
        this.new_value = new_value;
    }
}
