package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL alias "SubscriptionIdSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class SubscriptionIdSetHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, java.lang.String[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static java.lang.String[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (SubscriptionIdSetHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_alias_tc(
                            com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionIdSetHelper.id(),
                            "SubscriptionIdSet", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                             com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionIdHelper
                                                                                                 .type()));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/NotificationIRPConstDefs/SubscriptionIdSet:1.0";
    }

    public static java.lang.String[] read(final org.omg.CORBA.portable.InputStream _in) {
        java.lang.String[] _result;
        int _l_result2 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result2 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result2);
            }
        } catch (java.io.IOException e) {
        }
        _result = new java.lang.String[_l_result2];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = _in.read_string();
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out, java.lang.String[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            java.lang.String tmpResult2 = _s[i];
            _out.write_string(tmpResult2);
        }

    }
}
