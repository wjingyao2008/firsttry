package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL enum "SubscriptionState".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class SubscriptionStateHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (SubscriptionStateHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_enum_tc(com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHelper.id(),
                                            "SubscriptionState", new String[]{"ACTIVE", "SUSPENDED", "INVALID"});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionState s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionState extract(
        final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/NotificationIRPConstDefs/SubscriptionState:1.0";
    }

    public static SubscriptionState read(final org.omg.CORBA.portable.InputStream in) {
        return SubscriptionState.from_int(in.read_long());
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out, final SubscriptionState s) {
        out.write_long(s.value());
    }
}
