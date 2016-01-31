package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL enum "Signal".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class SignalHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (SignalHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_enum_tc(com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper.id(),
                                            "Signal", new String[]{"OK", "FAILURE", "PARTIALFAILURE"});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/ManagedGenericIRPConstDefs/Signal:1.0";
    }

    public static Signal read(final org.omg.CORBA.portable.InputStream in) {
        return Signal.from_int(in.read_long());
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out, final Signal s) {
        out.write_long(s.value());
    }
}
