package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "BackedUpStatusType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class BackedUpStatusTypeHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, boolean s) {
        any.insert_boolean(s);
    }

    public static boolean extract(final org.omg.CORBA.Any any) {
        return any.extract_boolean();
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (BackedUpStatusTypeHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_alias_tc(com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BackedUpStatusTypeHelper.id(),
                                             "BackedUpStatusType", org.omg.CORBA.ORB.init()
                                                 .get_primitive_tc(org.omg.CORBA.TCKind.from_int(8)));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/BackedUpStatusType:1.0";
    }

    public static boolean read(final org.omg.CORBA.portable.InputStream _in) {
        boolean _result;
        _result = _in.read_boolean();
        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out, boolean _s) {
        _out.write_boolean(_s);
    }
}
