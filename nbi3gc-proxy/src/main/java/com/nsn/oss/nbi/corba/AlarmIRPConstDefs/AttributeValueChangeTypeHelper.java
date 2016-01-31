package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "AttributeValueChangeType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeValueChangeTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (AttributeValueChangeTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_struct_tc(
                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeTypeHelper.id(),
                            "AttributeValueChangeType", new org.omg.CORBA.StructMember[]{
                                new org.omg.CORBA.StructMember("attribute_name",
                                                               org.omg.CORBA.ORB.init().create_string_tc(0), null),
                                new org.omg.CORBA.StructMember("old_value", org.omg.CORBA.ORB.init()
                                    .get_primitive_tc(org.omg.CORBA.TCKind.from_int(11)), null),
                                new org.omg.CORBA.StructMember("new_value", org.omg.CORBA.ORB.init()
                                    .get_primitive_tc(org.omg.CORBA.TCKind.from_int(11)), null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType extract(
        final org.omg.CORBA.Any any) {
        org.omg.CORBA.portable.InputStream in = any.create_input_stream();
        try {
            return read(in);
        } finally {
            try {
                in.close();
            } catch (java.io.IOException e) {
                throw new RuntimeException("Unexpected exception " + e.toString());
            }
        }
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/AttributeValueChangeType:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType();
        result.attribute_name = in.read_string();
        result.old_value = in.read_any();
        result.new_value = in.read_any();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueChangeType s) {
        java.lang.String tmpResult7 = s.attribute_name;
        out.write_string(tmpResult7);
        out.write_any(s.old_value);
        out.write_any(s.new_value);
    }
}
