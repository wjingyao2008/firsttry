package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "AlarmInformationIdAndSevSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmInformationIdAndSevSeqHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any,
                              com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] extract(
        final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (AlarmInformationIdAndSevSeqHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_alias_tc(
                            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevSeqHelper.id(),
                            "AlarmInformationIdAndSevSeq", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                       org.omg.CORBA.ORB
                                                                                                           .init()
                                                                                                           .create_struct_tc(
                                                                                                               com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper
                                                                                                                   .id(),
                                                                                                               "AlarmInformationIdAndSev",
                                                                                                               new org.omg.CORBA.StructMember[]{
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "alarm_information_reference",
                                                                                                                       org.omg.CORBA.ORB
                                                                                                                           .init()
                                                                                                                           .create_string_tc(
                                                                                                                               0),
                                                                                                                       null),
                                                                                                                   new org.omg.CORBA.StructMember(
                                                                                                                       "perceived_severity",
                                                                                                                       com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ShortTypeOptHelper
                                                                                                                           .type(),
                                                                                                                       null)})));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/AlarmInformationIdAndSevSeq:1.0";
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] read(
        final org.omg.CORBA.portable.InputStream _in) {
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] _result;
        int _l_result5 = _in.read_long();
        try {
            int x = _in.available();
            if (x > 0 && _l_result5 > x) {
                throw new org.omg.CORBA.MARSHAL(
                    "Sequence length too large. Only " + x + " available and trying to assign " + _l_result5);
            }
        } catch (java.io.IOException e) {
        }
        _result = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[_l_result5];
        for (int i = 0; i < _result.length; i++) {
            _result[i] = com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper.read(_in);
        }

        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] _s) {

        _out.write_long(_s.length);
        for (int i = 0; i < _s.length; i++) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevHelper.write(_out, _s[i]);
        }

    }
}
