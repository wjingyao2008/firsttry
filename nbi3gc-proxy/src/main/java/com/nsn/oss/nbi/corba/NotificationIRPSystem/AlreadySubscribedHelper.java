package com.nsn.oss.nbi.corba.NotificationIRPSystem;


/**
 * Generated from IDL exception "AlreadySubscribed".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class AlreadySubscribedHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (AlreadySubscribedHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_exception_tc(
                            com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.id(),
                            "AlreadySubscribed", new org.omg.CORBA.StructMember[0]);
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed extract(final org.omg.CORBA.Any any) {
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
        return "IDL:3gppsa5.org/NotificationIRPSystem/AlreadySubscribed:1.0";
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed read(
        final org.omg.CORBA.portable.InputStream in) {
        String id = in.read_string();
        if (!id.equals(id())) {
            throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
        }
        final com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed
            result =
            new com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed(id);
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed s) {
        out.write_string(id());
    }
}
