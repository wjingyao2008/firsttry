package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL struct "Comment".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CommentHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (CommentHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CommentHelper.id(), "Comment",
                                              new org.omg.CORBA.StructMember[]{
                                                  new org.omg.CORBA.StructMember("comment_time",
                                                                                 org.omg.CORBA.ORB.init()
                                                                                     .create_alias_tc(
                                                                                         com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.IRPTimeHelper
                                                                                             .id(), "IRPTime",
                                                                                         org.omg.CORBA.ORB.init()
                                                                                             .create_struct_tc(
                                                                                                 org.omg.TimeBase.UtcTHelper
                                                                                                     .id(), "UtcT",
                                                                                                 new org.omg.CORBA.StructMember[]{
                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                         "time",
                                                                                                         org.omg.CORBA.ORB
                                                                                                             .init()
                                                                                                             .create_alias_tc(
                                                                                                                 org.omg.TimeBase.TimeTHelper
                                                                                                                     .id(),
                                                                                                                 "TimeT",
                                                                                                                 org.omg.CORBA.ORB
                                                                                                                     .init()
                                                                                                                     .get_primitive_tc(
                                                                                                                         org.omg.CORBA.TCKind
                                                                                                                             .from_int(
                                                                                                                                 24))),
                                                                                                         null),
                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                         "inacclo",
                                                                                                         org.omg.CORBA.ORB
                                                                                                             .init()
                                                                                                             .get_primitive_tc(
                                                                                                                 org.omg.CORBA.TCKind
                                                                                                                     .from_int(
                                                                                                                         5)),
                                                                                                         null),
                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                         "inacchi",
                                                                                                         org.omg.CORBA.ORB
                                                                                                             .init()
                                                                                                             .get_primitive_tc(
                                                                                                                 org.omg.CORBA.TCKind
                                                                                                                     .from_int(
                                                                                                                         4)),
                                                                                                         null),
                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                         "tdf",
                                                                                                         org.omg.CORBA.ORB
                                                                                                             .init()
                                                                                                             .create_alias_tc(
                                                                                                                 org.omg.TimeBase.TdfTHelper
                                                                                                                     .id(),
                                                                                                                 "TdfT",
                                                                                                                 org.omg.CORBA.ORB
                                                                                                                     .init()
                                                                                                                     .get_primitive_tc(
                                                                                                                         org.omg.CORBA.TCKind
                                                                                                                             .from_int(
                                                                                                                                 2))),
                                                                                                         null)})),
                                                                                 null),
                                                  new org.omg.CORBA.StructMember("comment_text",
                                                                                 org.omg.CORBA.ORB.init()
                                                                                     .create_string_tc(0), null),
                                                  new org.omg.CORBA.StructMember("user_id", org.omg.CORBA.ORB.init()
                                                      .create_string_tc(0), null),
                                                  new org.omg.CORBA.StructMember("system_id", org.omg.CORBA.ORB.init()
                                                      .create_string_tc(0), null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any, final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/Comment:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment read(final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment result = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment();
        result.comment_time = org.omg.TimeBase.UtcTHelper.read(in);
        result.comment_text = in.read_string();
        result.user_id = in.read_string();
        result.system_id = in.read_string();
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment s) {
        org.omg.TimeBase.UtcTHelper.write(out, s.comment_time);
        java.lang.String tmpResult2 = s.comment_text;
        out.write_string(tmpResult2);
        java.lang.String tmpResult3 = s.user_id;
        out.write_string(tmpResult3);
        java.lang.String tmpResult4 = s.system_id;
        out.write_string(tmpResult4);
    }
}
