package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL union "ThresholdLevelIndTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdLevelIndTypeOptHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (ThresholdLevelIndTypeOptHelper.class) {
                if (_type == null) {
                    org.omg.CORBA.UnionMember[] members = new org.omg.CORBA.UnionMember[1];
                    org.omg.CORBA.Any label_any;
                    label_any = org.omg.CORBA.ORB.init().create_any();
                    label_any.insert_boolean((true));
                    members[0] =
                        new org.omg.CORBA.UnionMember("value", label_any,
                                                      com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeHelper
                                                          .type(), null);
                    _type =
                        org.omg.CORBA.ORB.init().create_union_tc(id(), "ThresholdLevelIndTypeOpt",
                                                                 org.omg.CORBA.ORB.init().get_primitive_tc(
                                                                     org.omg.CORBA.TCKind.from_int(8)), members);
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOpt s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeOpt extract(
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/ThresholdLevelIndTypeOpt:1.0";
    }

    public static ThresholdLevelIndTypeOpt read(org.omg.CORBA.portable.InputStream in) {
        ThresholdLevelIndTypeOpt result = new ThresholdLevelIndTypeOpt();
        boolean disc = in.read_boolean();
        if (disc == true) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndType _var;
            _var = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeHelper.read(in);
            result.value(_var);
        } else {
            result.__default(disc);
        }
        return result;
    }

    public static void write(org.omg.CORBA.portable.OutputStream out, ThresholdLevelIndTypeOpt s) {
        out.write_boolean(s.discriminator());
        if (s.discriminator() == true) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.ThresholdLevelIndTypeHelper.write(out, s.value());
        }
    }
}
