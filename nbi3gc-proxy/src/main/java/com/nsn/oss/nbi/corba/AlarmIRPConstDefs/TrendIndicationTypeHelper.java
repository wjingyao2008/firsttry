package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "TrendIndicationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class TrendIndicationTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (TrendIndicationTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_enum_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.TrendIndicationTypeHelper.id(),
                                            "TrendIndicationType",
                                            new String[]{"LessSevere", "NoChange", "MoreSevere"});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.TrendIndicationType s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.TrendIndicationType extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/TrendIndicationType:1.0";
    }

    public static TrendIndicationType read(final org.omg.CORBA.portable.InputStream in) {
        return TrendIndicationType.from_int(in.read_long());
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out, final TrendIndicationType s) {
        out.write_long(s.value());
    }
}
