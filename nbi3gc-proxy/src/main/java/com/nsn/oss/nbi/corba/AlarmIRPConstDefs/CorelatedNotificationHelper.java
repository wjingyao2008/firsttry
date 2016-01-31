package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "CorelatedNotification".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CorelatedNotificationHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (CorelatedNotificationHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotificationHelper.id(),
                                              "CorelatedNotification", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("source", org.omg.CORBA.ORB.init()
                                        .create_alias_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNHelper.id(), "DN",
                                                         org.omg.CORBA.ORB.init().create_string_tc(0)), null),
                                    new org.omg.CORBA.StructMember("notif_id_set", org.omg.CORBA.ORB.init()
                                        .create_alias_tc(
                                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.NotifIdSetTypeHelper.id(),
                                            "NotifIdSetType", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                          org.omg.CORBA.ORB
                                                                                                              .init()
                                                                                                              .get_primitive_tc(
                                                                                                                  org.omg.CORBA.TCKind
                                                                                                                      .from_int(
                                                                                                                          3)))),
                                                                   null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/CorelatedNotification:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification
            result =
            new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification();
        result.source = in.read_string();
        result.notif_id_set = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.NotifIdSetTypeHelper.read(in);
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification s) {
        java.lang.String tmpResult9 = s.source;
        out.write_string(tmpResult9);
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.NotifIdSetTypeHelper.write(out, s.notif_id_set);
    }
}
