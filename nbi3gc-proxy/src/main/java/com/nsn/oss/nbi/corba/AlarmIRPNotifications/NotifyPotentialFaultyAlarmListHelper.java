package com.nsn.oss.nbi.corba.AlarmIRPNotifications;


/**
 * Generated from IDL interface "NotifyPotentialFaultyAlarmList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public final class NotifyPotentialFaultyAlarmListHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (NotifyPotentialFaultyAlarmListHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_interface_tc(
                            "IDL:3gppsa5.org/AlarmIRPNotifications/NotifyPotentialFaultyAlarmList:1.0",
                            "NotifyPotentialFaultyAlarmList");
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList s) {
        any.insert_Object(s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList extract(
        final org.omg.CORBA.Any any) {
        return narrow(any.extract_Object());
    }

    public static String id() {
        return "IDL:3gppsa5.org/AlarmIRPNotifications/NotifyPotentialFaultyAlarmList:1.0";
    }

    public static NotifyPotentialFaultyAlarmList read(final org.omg.CORBA.portable.InputStream in) {
        return narrow(
            in.read_Object(com.nsn.oss.nbi.corba.AlarmIRPNotifications._NotifyPotentialFaultyAlarmListStub.class));
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             final com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList s) {
        _out.write_Object(s);
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList narrow(
        final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList) {
            return (com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList) obj;
        } else if (obj._is_a("IDL:3gppsa5.org/AlarmIRPNotifications/NotifyPotentialFaultyAlarmList:1.0")) {
            com.nsn.oss.nbi.corba.AlarmIRPNotifications._NotifyPotentialFaultyAlarmListStub stub;
            stub = new com.nsn.oss.nbi.corba.AlarmIRPNotifications._NotifyPotentialFaultyAlarmListStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        } else {
            throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
        }
    }

    public static com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList unchecked_narrow(
        final org.omg.CORBA.Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList) {
            return (com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList) obj;
        } else {
            com.nsn.oss.nbi.corba.AlarmIRPNotifications._NotifyPotentialFaultyAlarmListStub stub;
            stub = new com.nsn.oss.nbi.corba.AlarmIRPNotifications._NotifyPotentialFaultyAlarmListStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
            return stub;
        }
    }
}
