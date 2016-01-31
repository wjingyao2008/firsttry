package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL alias "VersionNumber".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class VersionNumberHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, java.lang.String s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static java.lang.String extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (VersionNumberHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_alias_tc(com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberHelper.id(),
                                             "VersionNumber", org.omg.CORBA.ORB.init().create_string_tc(0));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/ManagedGenericIRPConstDefs/VersionNumber:1.0";
    }

    public static java.lang.String read(final org.omg.CORBA.portable.InputStream _in) {
        java.lang.String _result;
        _result = _in.read_string();
        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out, java.lang.String _s) {
        java.lang.String tmpResult0 = _s;
        _out.write_string(tmpResult0);
    }
}
