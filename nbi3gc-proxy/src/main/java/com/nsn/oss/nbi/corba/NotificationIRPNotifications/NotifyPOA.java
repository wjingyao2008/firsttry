package com.nsn.oss.nbi.corba.NotificationIRPNotifications;


/**
 * Generated from IDL interface "Notify".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:03
 */

public abstract class NotifyPOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler,
               com.nsn.oss.nbi.corba.NotificationIRPNotifications.NotifyOperations {

    private String[] ids = {"IDL:3gppsa5.org/NotificationIRPNotifications/Notify:1.0"};

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

    public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input,
                                                       org.omg.CORBA.portable.ResponseHandler handler)
        throws org.omg.CORBA.SystemException {
        throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
    }

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id) {
        return ids;
    }
}
