package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "BadAlarmInformationId".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAlarmInformationIdHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (BadAlarmInformationIdHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.id(),
                                              "BadAlarmInformationId", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("alarm_information_reference",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0), null),
                                    new org.omg.CORBA.StructMember("reason",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0),
                                                                   null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/BadAlarmInformationId:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId();
        result.alarm_information_reference = in.read_string();
        result.reason = in.read_string();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId s) {
        java.lang.String tmpResult11 = s.alarm_information_reference;
        out.write_string(tmpResult11);
        java.lang.String tmpResult12 = s.reason;
        out.write_string(tmpResult12);
    }
}
