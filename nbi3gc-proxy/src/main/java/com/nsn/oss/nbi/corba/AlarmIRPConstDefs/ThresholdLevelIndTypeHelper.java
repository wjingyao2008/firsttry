package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "ThresholdLevelIndType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdLevelIndTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (ThresholdLevelIndTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeHelper.id(),
                                              "ThresholdLevelIndType", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("indication", org.omg.CORBA.ORB.init()
                                        .create_enum_tc(
                                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdIndicationTypeHelper.id(),
                                            "ThresholdIndicationType", new String[]{"UP", "DOWN"}), null),
                                    new org.omg.CORBA.StructMember("low",
                                                                   com.nsn.oss.nbi.corba.AlarmIRPConstDefs.FloatTypeOptHelper
                                                                       .type(), null),
                                    new org.omg.CORBA.StructMember("high", org.omg.CORBA.ORB.init()
                                        .get_primitive_tc(org.omg.CORBA.TCKind.from_int(6)), null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/ThresholdLevelIndType:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType();
        result.indication = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdIndicationTypeHelper.read(in);
        result.low = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.FloatTypeOptHelper.read(in);
        result.high = in.read_float();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType s) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdIndicationTypeHelper.write(out, s.indication);
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.FloatTypeOptHelper.write(out, s.low);
        out.write_float(s.high);
    }
}
