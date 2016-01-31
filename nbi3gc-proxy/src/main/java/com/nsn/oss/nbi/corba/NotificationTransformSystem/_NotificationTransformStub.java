package com.nsn.oss.nbi.corba.NotificationTransformSystem;


/**
 * Generated from IDL interface "NotificationTransform".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:05
 */

public class _NotificationTransformStub
    extends org.omg.CORBA.portable.ObjectImpl
    implements com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransform {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private String[] ids = {"IDL:NotificationTransformSystem/NotificationTransform:1.0"};

    public String[] _ids() {
        return ids;
    }

    public final static java.lang.Class
        _opsClass =
        com.nsn.oss.nbi.corba.NotificationTransformSystem.NotificationTransformOperations.class;

    public void transform(org.omg.CosNotification.EventBatchHolder notifications) {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("transform", true);
                    org.omg.CosNotification.EventBatchHelper.write(_os, notifications.value);
                    _is = _invoke(_os);
                    notifications.value = org.omg.CosNotification.EventBatchHelper.read(_is);
                    return;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        _ax.getInputStream().close();
                    } catch (java.io.IOException e) {
                        throw new RuntimeException("Unexpected exception " + e.toString());
                    }
                    throw new RuntimeException("Unexpected exception " + _id);
                } finally {
                    if (_os != null) {
                        try {
                            _os.close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
                    this._releaseReply(_is);
                }
            } else {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("transform", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationTransformOperations _localServant = (NotificationTransformOperations) _so.servant;
                try {
                    _localServant.transform(notifications);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return;
                } catch (RuntimeException re) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(re);
                    }
                    throw re;
                } catch (java.lang.Error err) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(err);
                    }
                    throw err;
                } finally {
                    _servant_postinvoke(_so);
                }
            }

        }

    }

}
