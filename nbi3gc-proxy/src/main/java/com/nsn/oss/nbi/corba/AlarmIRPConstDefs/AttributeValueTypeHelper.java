package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "AttributeValueType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AttributeValueTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (AttributeValueTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueTypeHelper.id(),
                                              "AttributeValueType", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("attribute_name",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0), null),
                                    new org.omg.CORBA.StructMember("value", org.omg.CORBA.ORB.init()
                                        .get_primitive_tc(org.omg.CORBA.TCKind.from_int(11)), null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/AttributeValueType:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType();
        result.attribute_name = in.read_string();
        result.value = in.read_any();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AttributeValueType s) {
        java.lang.String tmpResult8 = s.attribute_name;
        out.write_string(tmpResult8);
        out.write_any(s.value);
    }
}
