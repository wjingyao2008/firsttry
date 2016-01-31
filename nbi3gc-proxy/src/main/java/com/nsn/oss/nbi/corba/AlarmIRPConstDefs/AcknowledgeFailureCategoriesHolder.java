package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "AcknowledgeFailureCategories".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AcknowledgeFailureCategoriesHolder
    implements org.omg.CORBA.portable.Streamable {

    public AcknowledgeFailureCategories value;

    public AcknowledgeFailureCategoriesHolder() {
    }

    public AcknowledgeFailureCategoriesHolder(final AcknowledgeFailureCategories initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AcknowledgeFailureCategoriesHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AcknowledgeFailureCategoriesHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AcknowledgeFailureCategoriesHelper.write(out, value);
    }
}
