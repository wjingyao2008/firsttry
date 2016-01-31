package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "ThresholdInfoType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdInfoTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (ThresholdInfoTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoTypeHelper.id(),
                                              "ThresholdInfoType", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("attributeID",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0), null),
                                    new org.omg.CORBA.StructMember("observedValue", org.omg.CORBA.ORB.init()
                                        .get_primitive_tc(org.omg.CORBA.TCKind.from_int(6)), null),
                                    new org.omg.CORBA.StructMember("thresholdLevel",
                                                                   com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOptHelper
                                                                       .type(), null),
                                    new org.omg.CORBA.StructMember("armTime",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0),
                                                                   null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/ThresholdInfoType:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType();
        result.attributeID = in.read_string();
        result.observedValue = in.read_float();
        result.thresholdLevel = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOptHelper.read(in);
        result.armTime = in.read_string();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdInfoType s) {
        java.lang.String tmpResult5 = s.attributeID;
        out.write_string(tmpResult5);
        out.write_float(s.observedValue);
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOptHelper.write(out, s.thresholdLevel);
        java.lang.String tmpResult6 = s.armTime;
        out.write_string(tmpResult6);
    }
}
