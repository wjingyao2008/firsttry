package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;


/**
 * Generated from IDL interface "AlarmType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public abstract class AlarmTypePOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler, com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmTypeOperations {

    private String[] ids = {"IDL:3gppsa5.org/AlarmIRPConstDefs/AlarmType:1.0"};

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

    public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input,
                                                       org.omg.CORBA.portable.ResponseHandler handler)
        throws org.omg.CORBA.SystemException {
        throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
    }

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id) {
        return ids;
    }
}
