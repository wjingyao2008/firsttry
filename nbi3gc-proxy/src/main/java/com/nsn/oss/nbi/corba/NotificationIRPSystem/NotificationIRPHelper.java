package com.nsn.oss.nbi.corba.NotificationIRPSystem;


/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public final class NotificationIRPHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (NotificationIRPHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_interface_tc("IDL:3gppsa5.org/NotificationIRPSystem/NotificationIRP:1.0",
                                                 "NotificationIRP");
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP s) {
        any.insert_Object(s);
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP extract(final org.omg.CORBA.Any any) {
        return narrow(any.extract_Object());
    }

    public static String id() {
        return "IDL:3gppsa5.org/NotificationIRPSystem/NotificationIRP:1.0";
    }

    public static NotificationIRP read(final org.omg.CORBA.portable.InputStream in) {
        return narrow(in.read_Object(com.nsn.oss.nbi.corba.NotificationIRPSystem._NotificationIRPStub.class));
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             final com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP s) {
        _out.write_Object(s);
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP narrow(final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP) {
            return (com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP) obj;
        } else if (obj._is_a("IDL:3gppsa5.org/NotificationIRPSystem/NotificationIRP:1.0")) {
            com.nsn.oss.nbi.corba.NotificationIRPSystem._NotificationIRPStub stub;
            stub = new com.nsn.oss.nbi.corba.NotificationIRPSystem._NotificationIRPStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        } else {
            throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
        }
    }

    public static com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP unchecked_narrow(
        final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP) {
            return (com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP) obj;
        } else {
            com.nsn.oss.nbi.corba.NotificationIRPSystem._NotificationIRPStub stub;
            stub = new com.nsn.oss.nbi.corba.NotificationIRPSystem._NotificationIRPStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        }
    }
}
