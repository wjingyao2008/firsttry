package com.nsn.oss.nbi.corba.NotificationIRPNotifications;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Notify".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:03
 */

public class NotifyPOATie
    extends NotifyPOA {

    private NotifyOperations _delegate;

    private POA _poa;

    public NotifyPOATie(NotifyOperations delegate) {
        _delegate = delegate;
    }

    public NotifyPOATie(NotifyOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.NotificationIRPNotifications.Notify _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.NotificationIRPNotifications.Notify
            __r =
            com.nsn.oss.nbi.corba.NotificationIRPNotifications.NotifyHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.NotificationIRPNotifications.Notify _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.NotificationIRPNotifications.Notify
            __r =
            com.nsn.oss.nbi.corba.NotificationIRPNotifications.NotifyHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public NotifyOperations _delegate() {
        return _delegate;
    }

    public void _delegate(NotifyOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }
}
