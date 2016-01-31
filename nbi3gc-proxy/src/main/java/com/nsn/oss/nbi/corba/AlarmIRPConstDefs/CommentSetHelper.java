package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "CommentSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CommentSetHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (CommentSetHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_alias_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CommentSetHelper.id(),
                                             "CommentSet", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                       org.omg.CORBA.ORB
                                                                                                           .init()
                                                                                                           .create_struct_tc(
                                                                                                               com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CommentHelper
                                                                                                                   .id(),
                                                                                                               "Comment",
                                                                                                               new org.omg.CORBA.StructMember[]{
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "comment_time",
                                                                                                                       org.omg.CORBA.ORB
                                                                                                                           .init()
                                                                                                                           .create_alias_tc(
                                                                                                                               com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.IRPTimeHelper
                                                                                                                                   .id(),
                                                                                                                               "IRPTime",
                                                                                                                               org.omg.CORBA.ORB
                                                                                                                                   .init()
                                                                                                                                   .create_struct_tc(
                                                                                                                                       org.omg.TimeBase.UtcTHelper
                                                                                                                                           .id(),
                                                                                                                                       "UtcT",
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
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "comment_text",
                                                                                                                       org.omg.CORBA.ORB
                                                                                                                           .init()
                                                                                                                           .create_string_tc(
                                                                                                                               0),
                                                                                                                       null),
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "user_id",
                                                                                                                       org.omg.CORBA.ORB
                                                                                                                           .init()
                                                                                                                           .create_string_tc(
                                                                                                                               0),
                                                                                                                       null),
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "system_id",
                                                                                                                       org.omg.CORBA.ORB
                                                                                                                           .init()
                                                                                                                           .create_string_tc(
                                                                                                                               0),
                                                                                                                       null)})));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/CommentSet:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] read(final org.omg.CORBA.portable.InputStream _in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] _result;
        int _l_result0 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result0 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result0);
            }
        } catch (java.io.IOException e) {
        }
        _result = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[_l_result0];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CommentHelper.read(_in);
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CommentHelper.write(_out, _s[i]);
        }

    }
}
