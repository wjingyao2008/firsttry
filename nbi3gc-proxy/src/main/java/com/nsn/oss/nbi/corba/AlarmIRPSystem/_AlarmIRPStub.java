package com.nsn.oss.nbi.corba.AlarmIRPSystem;


/**
 * Generated from IDL interface "AlarmIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public class _AlarmIRPStub
    extends org.omg.CORBA.portable.ObjectImpl
    implements com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRP {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private String[] ids = {"IDL:3gppsa5.org/AlarmIRPSystem/AlarmIRP:1.0"};

    public String[] _ids() {
        return ids;
    }

    public final static java.lang.Class _opsClass = com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPOperations.class;

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_alarm_IRP_operations_profile(
        java.lang.String alarm_irp_version) throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_alarm_IRP_operations_profile", true);
                    java.lang.String tmpResult10 = alarm_irp_version;
                    _os.write_string(tmpResult10);
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
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/GetAlarmIRPOperationsProfile:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfileHelper
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
                    _servant_preinvoke("get_alarm_IRP_operations_profile", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] _result;
                try {
                    _result = _localServant.get_alarm_IRP_operations_profile(alarm_irp_version);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile ex) {
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

    public org.omg.CosNotification.StructuredEvent[] get_alarm_list(
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt base_object, org.omg.CORBA.BooleanHolder flag,
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder iter)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_alarm_list", true);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, filter);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOptHelper.write(_os, base_object);
                    _is = _invoke(_os);
                    org.omg.CosNotification.StructuredEvent[]
                        _result =
                        org.omg.CosNotification.EventBatchHelper.read(_is);
                    flag.value = _is.read_boolean();
                    iter.value = com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/GetAlarmList:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmListHelper.read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_alarm_list", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                org.omg.CosNotification.StructuredEvent[] _result;
                try {
                    _result = _localServant.get_alarm_list(filter, base_object, flag, iter);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
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

    public java.lang.String[] get_alarm_IRP_versions() throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_alarm_IRP_versions", true);
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
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/GetAlarmIRPVersions:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersionsHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_alarm_IRP_versions", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                java.lang.String[] _result;
                try {
                    _result = _localServant.get_alarm_IRP_versions();
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions ex) {
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal comment_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String comment_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt comment_system_id, java.lang.String comment_text,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("comment_alarms", true);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper
                        .write(_os, alarm_information_id_list);
                    java.lang.String tmpResult11 = comment_user_id;
                    _os.write_string(tmpResult11);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, comment_system_id);
                    java.lang.String tmpResult12 = comment_text;
                    _os.write_string(tmpResult12);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper.read(_is);
                    bad_alarm_information_id_list.value =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/CommentAlarms:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarmsHelper.read(_ax.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("comment_alarms", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal _result;
                try {
                    _result =
                        _localServant
                            .comment_alarms(alarm_information_id_list, comment_user_id, comment_system_id, comment_text,
                                            bad_alarm_information_id_list);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms ex) {
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_alarm_IRP_notification_profile(
        java.lang.String alarm_irp_version) throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_alarm_IRP_notification_profile", true);
                    java.lang.String tmpResult13 = alarm_irp_version;
                    _os.write_string(tmpResult13);
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
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/GetAlarmIRPNotificationProfile:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfileHelper
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
                    _servant_preinvoke("get_alarm_IRP_notification_profile", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] _result;
                try {
                    _result = _localServant.get_alarm_IRP_notification_profile(alarm_irp_version);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile ex) {
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

    public void get_alarm_count(com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                org.omg.CORBA.IntHolder critical_count, org.omg.CORBA.IntHolder major_count,
                                org.omg.CORBA.IntHolder minor_count, org.omg.CORBA.IntHolder warning_count,
                                org.omg.CORBA.IntHolder indeterminate_count, org.omg.CORBA.IntHolder cleared_count)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("get_alarm_count", true);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, filter);
                    _is = _invoke(_os);
                    critical_count.value = _is.read_ulong();
                    major_count.value = _is.read_ulong();
                    minor_count.value = _is.read_ulong();
                    warning_count.value = _is.read_ulong();
                    indeterminate_count.value = _is.read_ulong();
                    cleared_count.value = _is.read_ulong();
                    return;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/GetAlarmCount:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCountHelper.read(_ax.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_alarm_count", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                try {
                    _localServant.get_alarm_count(filter, critical_count, major_count, minor_count, warning_count,
                                                  indeterminate_count, cleared_count);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount ex) {
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal acknowledge_alarms(
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] alarm_information_id_and_sev_list,
        java.lang.String ack_user_id, com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt ack_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder bad_ack_alarm_info_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("acknowledge_alarms", true);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevSeqHelper
                        .write(_os, alarm_information_id_and_sev_list);
                    java.lang.String tmpResult14 = ack_user_id;
                    _os.write_string(tmpResult14);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, ack_system_id);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper.read(_is);
                    bad_ack_alarm_info_list.value =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/AcknowledgeAlarms:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarmsHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acknowledge_alarms", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal _result;
                try {
                    _result =
                        _localServant.acknowledge_alarms(alarm_information_id_and_sev_list, ack_user_id, ack_system_id,
                                                         bad_ack_alarm_info_list);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms ex) {
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal clear_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String clear_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt clear_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("clear_alarms", true);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper
                        .write(_os, alarm_information_id_list);
                    java.lang.String tmpResult15 = clear_user_id;
                    _os.write_string(tmpResult15);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, clear_system_id);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper.read(_is);
                    bad_alarm_information_id_list.value =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/ClearAlarms:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarmsHelper.read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("clear_alarms", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal _result;
                try {
                    _result =
                        _localServant.clear_alarms(alarm_information_id_list, clear_user_id, clear_system_id,
                                                   bad_alarm_information_id_list);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms ex) {
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).exceptionalCompletion(ex);
                    }
                    throw ex;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
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

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal unacknowledge_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String ack_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt ack_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("unacknowledge_alarms", true);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper
                        .write(_os, alarm_information_id_list);
                    java.lang.String tmpResult16 = ack_user_id;
                    _os.write_string(tmpResult16);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_os, ack_system_id);
                    _is = _invoke(_os);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal
                        _result =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper.read(_is);
                    bad_alarm_information_id_list.value =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/ParameterNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/InvalidParameter:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/ManagedGenericIRPSystem/OperationNotSupported:1.0")) {
                            throw com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper
                                .read(_ax.getInputStream());
                        } else if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/UnacknowledgeAlarms:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("unacknowledge_alarms", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmIRPOperations _localServant = (AlarmIRPOperations) _so.servant;
                com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal _result;
                try {
                    _result =
                        _localServant.unacknowledge_alarms(alarm_information_id_list, ack_user_id, ack_system_id,
                                                           bad_alarm_information_id_list);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported ex) {
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
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms ex) {
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
