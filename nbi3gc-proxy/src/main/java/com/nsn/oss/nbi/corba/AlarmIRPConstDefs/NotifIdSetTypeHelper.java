package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "NotifIdSetType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class NotifIdSetTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, int[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static int[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (NotifIdSetTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_alias_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.NotifIdSetTypeHelper.id(),
                                             "NotifIdSetType", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                           org.omg.CORBA.ORB
                                                                                                               .init()
                                                                                                               .get_primitive_tc(
                                                                                                                   org.omg.CORBA.TCKind
                                                                                                                       .from_int(
                                                                                                                           3))));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/NotifIdSetType:1.0";
    }

    public static int[] read(final org.omg.CORBA.portable.InputStream _in) {
        int[] _result;
        int _l_result3 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result3 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result3);
            }
        } catch (java.io.IOException e) {
        }
        _result = new int[_l_result3];
        _in.read_long_array(_result, 0, _l_result3);
        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out, int[] _s) {

        _out.write_long(_s.length);
        _out.write_long_array(_s, 0, _s.length);
    }
}
