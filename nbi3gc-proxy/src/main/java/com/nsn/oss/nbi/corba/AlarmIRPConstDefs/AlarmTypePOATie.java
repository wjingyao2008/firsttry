package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "AlarmType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public class AlarmTypePOATie
    extends AlarmTypePOA {

    private AlarmTypeOperations _delegate;

    private POA _poa;

    public AlarmTypePOATie(AlarmTypeOperations delegate) {
        _delegate = delegate;
    }

    public AlarmTypePOATie(AlarmTypeOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmType _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmType
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmTypeHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmType _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmType
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmTypeHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public AlarmTypeOperations _delegate() {
        return _delegate;
    }

    public void _delegate(AlarmTypeOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }
}
