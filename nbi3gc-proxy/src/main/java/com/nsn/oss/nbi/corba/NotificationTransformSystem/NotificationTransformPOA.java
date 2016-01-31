package com.nsn.oss.nbi.corba.NotificationTransformSystem;


/**
 * Generated from IDL interface "NotificationTransform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public abstract class NotificationTransformPOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler,
               com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransformOperations {

    static private final java.util.HashMap<String, Integer> m_opsHash = new java.util.HashMap<String, Integer>();

    static {
        m_opsHash.put("transform", Integer.valueOf(0));
    }

    private String[] ids = {"IDL:NotificationTransformSystem/NotificationTransform:1.0"};

    public com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransform _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransform
            __r =
            com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransformHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransform _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransform
            __r =
            com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransformHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input,
                                                       org.omg.CORBA.portable.ResponseHandler handler)
        throws org.omg.CORBA.SystemException {
        org.omg.CORBA.portable.OutputStream _out = null;
        // do something
        // quick lookup of operation
        java.lang.Integer opsIndex = (java.lang.Integer) m_opsHash.get(method);
        if (null == opsIndex) {
            throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
        }
        switch (opsIndex.intValue()) {
            case 0: // transform
            {
                org.omg.CosNotification.EventBatchHolder _arg0 = new org.omg.CosNotification.EventBatchHolder();
                _arg0._read(_input);
                _out = handler.createReply();
                transform(_arg0);
                org.omg.CosNotification.EventBatchHelper.write(_out, _arg0.value);
                break;
            }
        }
        return _out;
    }

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id) {
        return ids;
    }
}
