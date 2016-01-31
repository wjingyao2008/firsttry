package com.nsn.oss.nbi.corba.NotificationIRPSystem;


/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public class _NotificationIRPStub
    extends org.omg.CORBA.portable.ObjectImpl
    implements com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private String[] ids = {"IDL:3gppsa5.org/NotificationIRPSystem/NotificationIRP:1.0"};

    public String[] _ids() {
        return ids;
    }

    public final static java.lang.Class
        _opsClass =
        com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPOperations.class;

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_notification_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_notification_IRP_notification_profile", true);
                    java.lang.String tmpResult9 = notification_irp_version;
                    _os.write_string(tmpResult9);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[]
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals(
                            "IDL:3gppsa5.org/NotificationIRPSystem/GetNotificationIRPNotificationProfile:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfileHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject
                    _so =
                    _servant_preinvoke("get_notification_IRP_notification_profile", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] _result;
                try {
                    _result = _localServant.get_notification_IRP_notification_profile(notification_irp_version);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String[] get_notification_IRP_versions()
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_notification_IRP_versions", true);
                    _is = _invoke(_os);
                    java.lang.String[]
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/GetNotificationIRPVersions:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersionsHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject
                    _so =
                    _servant_preinvoke("get_notification_IRP_versions", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String[] _result;
                try {
                    _result = _localServant.get_notification_IRP_versions();
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public void change_subscription_filter(java.lang.String subscription_id, java.lang.String filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("change_subscription_filter", true);
                    java.lang.String tmpResult10 = subscription_id;
                    _os.write_string(tmpResult10);
                    java.lang.String tmpResult11 = filter;
                    _os.write_string(tmpResult11);
                    _is = _invoke(_os);
                    return;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/ChangeSubscriptionFilter:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("change_subscription_filter", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                try {
                    _localServant.change_subscription_filter(subscription_id, filter);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_operations_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_notification_IRP_operations_profile", true);
                    java.lang.String tmpResult12 = notification_irp_version;
                    _os.write_string(tmpResult12);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[]
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id
                            .equals("IDL:3gppsa5.org/NotificationIRPSystem/GetNotificationIRPOperationsProfile:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfileHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject
                    _so =
                    _servant_preinvoke("get_notification_IRP_operations_profile", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] _result;
                try {
                    _result = _localServant.get_notification_IRP_operations_profile(notification_irp_version);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public void detach(java.lang.String manager_reference, java.lang.String subscription_id)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("detach", true);
                    java.lang.String tmpResult13 = manager_reference;
                    _os.write_string(tmpResult13);
                    java.lang.String tmpResult14 = subscription_id;
                    _os.write_string(tmpResult14);
                    _is = _invoke(_os);
                    return;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/DetachException:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachExceptionHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("detach", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                try {
                    _localServant.detach(manager_reference, subscription_id);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String[] get_subscription_ids(java.lang.String manager_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_subscription_ids", true);
                    java.lang.String tmpResult15 = manager_reference;
                    _os.write_string(tmpResult15);
                    _is = _invoke(_os);
                    java.lang.String[]
                        _result =
                        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionIdSetHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/GetSubscriptionIds:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIdsHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_subscription_ids", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String[] _result;
                try {
                    _result = _localServant.get_subscription_ids(manager_reference);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String[] get_subscription_status(java.lang.String subscription_id,
                                                      com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder filter_in_effect,
                                                      com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder subscription_state,
                                                      org.omg.CORBA.IntHolder time_tick)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_subscription_status", true);
                    java.lang.String tmpResult16 = subscription_id;
                    _os.write_string(tmpResult16);
                    _is = _invoke(_os);
                    java.lang.String[]
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_is);
                    filter_in_effect.value =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_is);
                    subscription_state.value =
                        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHelper.read(_is);
                    time_tick.value = _is.read_ulong();
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/GetSubscriptionStatus:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatusHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_subscription_status", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String[] _result;
                try {
                    _result =
                        _localServant
                            .get_subscription_status(subscription_id, filter_in_effect, subscription_state, time_tick);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String attach_pull(java.lang.String manager_reference, int time_tick,
                                        java.lang.String[] notification_categories,
                                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                        org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder system_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("attach_pull", true);
                    java.lang.String tmpResult17 = manager_reference;
                    _os.write_string(tmpResult17);
                    _os.write_ulong(time_tick);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_os, notification_categories);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, filter);
                    _is = _invoke(_os);
                    java.lang.String _result = _is.read_string();
                    system_reference.value = org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/Attach:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals(
                            "IDL:3gppsa5.org/NotificationIRPSystem/AtLeastOneNotificationCategoryNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/AlreadySubscribed:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("attach_pull", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String _result;
                try {
                    _result =
                        _localServant.attach_pull(manager_reference, time_tick, notification_categories, filter,
                                                  system_reference);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String[] get_notification_categories(
        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder notification_type_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_notification_categories", true);
                    _is = _invoke(_os);
                    java.lang.String[]
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_is);
                    notification_type_list.value =
                        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/GetNotificationCategories:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategoriesHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_notification_categories", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String[] _result;
                try {
                    _result = _localServant.get_notification_categories(notification_type_list);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String attach_push(java.lang.String manager_reference, int time_tick,
                                        java.lang.String[] notification_categories,
                                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("attach_push", true);
                    java.lang.String tmpResult18 = manager_reference;
                    _os.write_string(tmpResult18);
                    _os.write_ulong(time_tick);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_os, notification_categories);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, filter);
                    _is = _invoke(_os);
                    java.lang.String _result = _is.read_string();
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/Attach:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals(
                            "IDL:3gppsa5.org/NotificationIRPSystem/AtLeastOneNotificationCategoryNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/AlreadySubscribed:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("attach_push", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String _result;
                try {
                    _result = _localServant.attach_push(manager_reference, time_tick, notification_categories, filter);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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

    public java.lang.String attach_push_b(java.lang.String manager_reference, int time_tick,
                                          java.lang.String[] notification_categories,
                                          com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                          org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder system_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("attach_push_b", true);
                    java.lang.String tmpResult19 = manager_reference;
                    _os.write_string(tmpResult19);
                    _os.write_ulong(time_tick);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_os, notification_categories);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, filter);
                    _is = _invoke(_os);
                    java.lang.String _result = _is.read_string();
                    system_reference.value = org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/Attach:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals(
                            "IDL:3gppsa5.org/NotificationIRPSystem/AtLeastOneNotificationCategoryNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/NotificationIRPSystem/AlreadySubscribed:1.0")) {
                            throw com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper
                                .read(_ax.getInputStream());
                        } else {
                            throw new RuntimeException("Unexpected exception " + _id);
                        }
                    } finally {
                        try {
                            _ax.getInputStream().close();
                        } catch (java.io.IOException e) {
                            throw new RuntimeException("Unexpected exception " + e.toString());
                        }
                    }
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("attach_push_b", _opsClass);
                if (_so == null) {
                    continue;
                }
                NotificationIRPOperations _localServant = (NotificationIRPOperations) _so.servant;
                java.lang.String _result;
                try {
                    _result =
                        _localServant.attach_push_b(manager_reference, time_tick, notification_categories, filter,
                                                    system_reference);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
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
