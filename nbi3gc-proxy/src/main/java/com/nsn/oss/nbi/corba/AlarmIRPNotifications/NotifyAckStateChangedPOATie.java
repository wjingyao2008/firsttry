package com.nsn.oss.nbi.corba.AlarmIRPNotifications;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "NotifyAckStateChanged".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public class NotifyAckStateChangedPOATie
    extends NotifyAckStateChangedPOA {

    private NotifyAckStateChangedOperations _delegate;

    private POA _poa;

    public NotifyAckStateChangedPOATie(NotifyAckStateChangedOperations delegate) {
        _delegate = delegate;
    }

    public NotifyAckStateChangedPOATie(NotifyAckStateChangedOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChanged _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChanged
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChangedHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChanged _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChanged
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPNotifications.NotifyAckStateChangedHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public NotifyAckStateChangedOperations _delegate() {
        return _delegate;
    }

    public void _delegate(NotifyAckStateChangedOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }
}
