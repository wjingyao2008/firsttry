package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "BadAlarmInformationIdSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BadAlarmInformationIdSeqHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any,
                              com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (BadAlarmInformationIdSeqHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_alias_tc(
                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.id(),
                            "BadAlarmInformationIdSeq", org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB
                                .init().create_struct_tc(
                                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.id(),
                                    "BadAlarmInformationId", new org.omg.CORBA.StructMember[]{
                                        new org.omg.CORBA.StructMember("alarm_information_reference",
                                                                       org.omg.CORBA.ORB.init().create_string_tc(0),
                                                                       null), new org.omg.CORBA.StructMember("reason",
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
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/BadAlarmInformationIdSeq:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] read(
        final org.omg.CORBA.portable.InputStream _in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] _result;
        int _l_result6 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result6 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result6);
            }
        } catch (java.io.IOException e) {
        }
        _result = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[_l_result6];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.read(_in);
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdHelper.write(_out, _s[i]);
        }

    }
}
