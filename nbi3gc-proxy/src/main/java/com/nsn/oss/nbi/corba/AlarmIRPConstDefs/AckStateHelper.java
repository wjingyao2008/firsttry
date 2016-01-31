package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL interface "AckState".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AckStateHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (AckStateHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_interface_tc("IDL:3gppsa5.org/AlarmIRPConstDefs/AckState:1.0", "AckState");
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any, final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState s) {
        any.insert_Object(s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState extract(final org.omg.CORBA.Any any) {
        return narrow(any.extract_Object());
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPConstDefs/AckState:1.0";
    }

    public static AckState read(final org.omg.CORBA.portable.InputStream in) {
        return narrow(in.read_Object(com.nsn.oss.nbi.corba.AlarmIRPConstDefs._AckStateStub.class));
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState s) {
        _out.write_Object(s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState narrow(final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState) {
            return (com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState) obj;
        } else if (obj._is_a("IDL:3gppsa5.org/AlarmIRPConstDefs/AckState:1.0")) {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs._AckStateStub stub;
            stub = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs._AckStateStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        } else {
            throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
        }
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState unchecked_narrow(final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState) {
            return (com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AckState) obj;
        } else {
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs._AckStateStub stub;
            stub = new com.nsn.oss.nbi.corba.AlarmIRPConstDefs._AckStateStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        }
    }
}
