package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "BadAcknowledgeAlarmInfo".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAcknowledgeAlarmInfoHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (BadAcknowledgeAlarmInfoHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_struct_tc(
                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoHelper.id(),
                            "BadAcknowledgeAlarmInfo", new org.omg.CORBA.StructMember[]{
                                new org.omg.CORBA.StructMember("alarm_information_reference",
                                                               org.omg.CORBA.ORB.init().create_string_tc(0), null),
                                new org.omg.CORBA.StructMember("failure_category", org.omg.CORBA.ORB.init()
                                    .create_enum_tc(
                                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategoriesHelper.id(),
                                        "AcknowledgeFailureCategories",
                                        new String[]{"UnknownAlarmId", "WrongPerceivedSeverity",
                                                     "AcknowledgmentFailed"}), null),
                                new org.omg.CORBA.StructMember("reason", org.omg.CORBA.ORB.init().create_string_tc(0),
                                                               null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/BadAcknowledgeAlarmInfo:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo();
        result.alarm_information_reference = in.read_string();
        result.failure_category = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategoriesHelper.read(in);
        result.reason = in.read_string();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo s) {
        java.lang.String tmpResult13 = s.alarm_information_reference;
        out.write_string(tmpResult13);
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategoriesHelper.write(out, s.failure_category);
        java.lang.String tmpResult14 = s.reason;
        out.write_string(tmpResult14);
    }
}
