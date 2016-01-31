package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AlarmInformationIdSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdSeqHelper {

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
            synchronized (AlarmInformationIdSeqHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_alias_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper.id(),
                                             "AlarmInformationIdSeq", org.omg.CORBA.ORB.init()
                                                 .create_sequence_tc(0, org.omg.CORBA.ORB.init().create_string_tc(0)));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/AlarmInformationIdSeq:1.0";
    }

    public static java.lang.String[] read(final org.omg.CORBA.portable.InputStream _in) {
        java.lang.String[] _result;
        int _l_result8 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result8 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result8);
            }
        } catch (java.io.IOException e) {
        }
        _result = new java.lang.String[_l_result8];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = _in.read_string();
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out, java.lang.String[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            java.lang.String tmpResult15 = _s[i];
            _out.write_string(tmpResult15);
        }

    }
}
