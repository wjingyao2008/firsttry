package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL union "StringTypeOpt".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class StringTypeOptHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (StringTypeOptHelper.class) {
                if (_type == null) {
                    org.omg.CORBA.UnionMember[] members = new org.omg.CORBA.UnionMember[1];
                    org.omg.CORBA.Any label_any;
                    label_any = org.omg.CORBA.ORB.init().create_any();
                    label_any.insert_boolean((true));
                    members[0] =
                        new org.omg.CORBA.UnionMember("value", label_any, org.omg.CORBA.ORB.init().create_string_tc(0),
                                                      null);
                    _type =
                        org.omg.CORBA.ORB.init().create_union_tc(id(), "StringTypeOpt", org.omg.CORBA.ORB.init()
                            .get_primitive_tc(org.omg.CORBA.TCKind.from_int(8)), members);
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/ManagedGenericIRPConstDefs/StringTypeOpt:1.0";
    }

    public static StringTypeOpt read(org.omg.CORBA.portable.InputStream in) {
        StringTypeOpt result = new StringTypeOpt();
        boolean disc = in.read_boolean();
        if (disc == true) {
            java.lang.String _var;
            _var = in.read_string();
            result.value(_var);
        } else {
            result.__default(disc);
        }
        return result;
    }

    public static void write(org.omg.CORBA.portable.OutputStream out, StringTypeOpt s) {
        out.write_boolean(s.discriminator());
        if (s.discriminator() == true) {
            java.lang.String tmpResult6 = s.value();
            out.write_string(tmpResult6);
        }
    }
}
