package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "CorrelatedNotificationSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CorrelatedNotificationSetTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any,
                              com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (CorrelatedNotificationSetTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_alias_tc(
                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorrelatedNotificationSetTypeHelper.id(),
                            "CorrelatedNotificationSetType", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                         org.omg.CORBA.ORB
                                                                                                             .init()
                                                                                                             .create_struct_tc(
                                                                                                                 com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotificationHelper
                                                                                                                     .id(),
                                                                                                                 "CorelatedNotification",
                                                                                                                 new org.omg.CORBA.StructMember[]{
                                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                                         "source",
                                                                                                                         org.omg.CORBA.ORB
                                                                                                                             .init()
                                                                                                                             .create_alias_tc(
                                                                                                                                 com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNHelper
                                                                                                                                     .id(),
                                                                                                                                 "DN",
                                                                                                                                 org.omg.CORBA.ORB
                                                                                                                                     .init()
                                                                                                                                     .create_string_tc(
                                                                                                                                         0)),
                                                                                                                         null),
                                                                                                                     new org.omg.CORBA.StructMember(
                                                                                                                         "notif_id_set",
                                                                                                                         org.omg.CORBA.ORB
                                                                                                                             .init()
                                                                                                                             .create_alias_tc(
                                                                                                                                 com.nsn.oss.nbi.corba.AlarmIRPConstDefs.NotifIdSetTypeHelper
                                                                                                                                     .id(),
                                                                                                                                 "NotifIdSetType",
                                                                                                                                 org.omg.CORBA.ORB
                                                                                                                                     .init()
                                                                                                                                     .create_sequence_tc(
                                                                                                                                         0,
                                                                                                                                         org.omg.CORBA.ORB
                                                                                                                                             .init()
                                                                                                                                             .get_primitive_tc(
                                                                                                                                                 org.omg.CORBA.TCKind
                                                                                                                                                     .from_int(
                                                                                                                                                         3)))),
                                                                                                                         null)})));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/CorrelatedNotificationSetType:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] read(
        final org.omg.CORBA.portable.InputStream _in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] _result;
        int _l_result4 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result4 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result4);
            }
        } catch (java.io.IOException e) {
        }
        _result = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[_l_result4];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotificationHelper.read(_in);
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotification[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.CorelatedNotificationHelper.write(_out, _s[i]);
        }

    }
}
