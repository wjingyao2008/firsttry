package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "NotifyChangedAlarm".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public class NotifyChangedAlarmPOATie
    extends NotifyChangedAlarmPOA {

    private NotifyChangedAlarmOperations _delegate;

    private POA _poa;

    public NotifyChangedAlarmPOATie(NotifyChangedAlarmOperations delegate) {
        _delegate = delegate;
    }

    public NotifyChangedAlarmPOATie(NotifyChangedAlarmOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarm _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarm
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarmHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarm _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarm
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyChangedAlarmHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public NotifyChangedAlarmOperations _delegate() {
        return _delegate;
    }

    public void _delegate(NotifyChangedAlarmOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }
}
