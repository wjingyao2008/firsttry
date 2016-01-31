package com.nsn.oss.nbi.corba.NotificationTransformSystem;


/**
 * Generated from IDL exception "Transform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class TransformHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (TransformHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_exception_tc(com.nsn.oss.nbi.corba.NotificationTransformSystem.TransformHelper.id(),
                                                 "Transform", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("reason",
                                                                   org.omg.CORBA.ORB.init().create_string_tc(0),
                                                                   null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform extract(final org.omg.CORBA.Any any) {
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
        return "IDL:NotificationTransformSystem/Transform:1.0";
    }

    public static com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform read(
        final org.omg.CORBA.portable.InputStream in) {
        String id = in.read_string();
        if (!id.equals(id())) {
            throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
        }
        java.lang.String x0;
        x0 = in.read_string();
        final com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform
            result =
            new com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform(id, x0);
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.NotificationTransformSystem.Transform s) {
        out.write_string(id());
        java.lang.String tmpResult0 = s.reason;
        out.write_string(tmpResult0);
    }
}
