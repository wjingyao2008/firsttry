package com.nsn.oss.nbi.corba.AlarmIRPNotifications;


/**
 * Generated from IDL interface "NotifyPotentialFaultyAlarmList".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public class _NotifyPotentialFaultyAlarmListStub
    extends org.omg.CORBA.portable.ObjectImpl
    implements com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmList {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private String[]
        ids =
        {"IDL:3gppsa5.org/AlarmIRPNotifications/NotifyPotentialFaultyAlarmList:1.0",
         "IDL:3gppsa5.org/NotificationIRPNotifications/Notify:1.0"};

    public String[] _ids() {
        return ids;
    }

    public final static java.lang.Class
        _opsClass =
        com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyPotentialFaultyAlarmListOperations.class;
}
