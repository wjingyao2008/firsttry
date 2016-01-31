package com.nsn.oss.nbi.corba.AlarmIRPSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "AlarmInformationIterator".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public class AlarmInformationIteratorPOATie
    extends AlarmInformationIteratorPOA {

    private AlarmInformationIteratorOperations _delegate;

    private POA _poa;

    public AlarmInformationIteratorPOATie(AlarmInformationIteratorOperations delegate) {
        _delegate = delegate;
    }

    public AlarmInformationIteratorPOATie(AlarmInformationIteratorOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public AlarmInformationIteratorOperations _delegate() {
        return _delegate;
    }

    public void _delegate(AlarmInformationIteratorOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }

    public boolean next_alarmInformations(short how_many, org.omg.CosNotification.EventBatchHolder alarm_informations)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        return _delegate.next_alarmInformations(how_many, alarm_informations);
    }

    public void destroy() {
        _delegate.destroy();
    }

}
