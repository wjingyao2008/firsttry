package com.nsn.oss.nbi.corba.AlarmIRPSystem;


/**
 * Generated from IDL interface "AlarmIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public abstract class AlarmIRPPOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler, com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPOperations {

    static private final java.util.HashMap<String, Integer> m_opsHash = new java.util.HashMap<String, Integer>();

    static {
        m_opsHash.put("get_alarm_IRP_operations_profile", Integer.valueOf(0));
        m_opsHash.put("get_alarm_list", Integer.valueOf(1));
        m_opsHash.put("get_alarm_IRP_versions", Integer.valueOf(2));
        m_opsHash.put("comment_alarms", Integer.valueOf(3));
        m_opsHash.put("get_alarm_IRP_notification_profile", Integer.valueOf(4));
        m_opsHash.put("get_alarm_count", Integer.valueOf(5));
        m_opsHash.put("acknowledge_alarms", Integer.valueOf(6));
        m_opsHash.put("clear_alarms", Integer.valueOf(7));
        m_opsHash.put("unacknowledge_alarms", Integer.valueOf(8));
    }

    private String[] ids = {"IDL:3gppsa5.org/AlarmIRPSystem/AlarmIRP:1.0"};

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRP _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRP
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRP _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRP
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPHelper.narrow(__o);
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
            case 0: // get_alarm_IRP_operations_profile
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper
                        .write(_out, get_alarm_IRP_operations_profile(_arg0));
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfileHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 1: // get_alarm_list
            {
                try {
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg0 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt
                        _arg1 =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOptHelper.read(_input);
                    org.omg.CORBA.BooleanHolder _arg2 = new org.omg.CORBA.BooleanHolder();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder
                        _arg3 =
                        new com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder();
                    _out = handler.createReply();
                    org.omg.CosNotification.EventBatchHelper.write(_out, get_alarm_list(_arg0, _arg1, _arg2, _arg3));
                    _out.write_boolean(_arg2.value);
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.write(_out, _arg3.value);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmListHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex2);
                }
                break;
            }
            case 2: // get_alarm_IRP_versions
            {
                try {
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_out, get_alarm_IRP_versions());
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersionsHelper.write(_out, _ex0);
                }
                break;
            }
            case 3: // comment_alarms
            {
                try {
                    java.lang.String[]
                        _arg0 =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper.read(_input);
                    java.lang.String _arg1 = _input.read_string();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    java.lang.String _arg3 = _input.read_string();
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder
                        _arg4 =
                        new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper
                        .write(_out, comment_alarms(_arg0, _arg1, _arg2, _arg3, _arg4));
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.write(_out, _arg4.value);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarmsHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex3);
                }
                break;
            }
            case 4: // get_alarm_IRP_notification_profile
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper
                        .write(_out, get_alarm_IRP_notification_profile(_arg0));
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfileHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 5: // get_alarm_count
            {
                try {
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg0 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    org.omg.CORBA.IntHolder _arg1 = new org.omg.CORBA.IntHolder();
                    org.omg.CORBA.IntHolder _arg2 = new org.omg.CORBA.IntHolder();
                    org.omg.CORBA.IntHolder _arg3 = new org.omg.CORBA.IntHolder();
                    org.omg.CORBA.IntHolder _arg4 = new org.omg.CORBA.IntHolder();
                    org.omg.CORBA.IntHolder _arg5 = new org.omg.CORBA.IntHolder();
                    org.omg.CORBA.IntHolder _arg6 = new org.omg.CORBA.IntHolder();
                    _out = handler.createReply();
                    get_alarm_count(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    _out.write_ulong(_arg1.value);
                    _out.write_ulong(_arg2.value);
                    _out.write_ulong(_arg3.value);
                    _out.write_ulong(_arg4.value);
                    _out.write_ulong(_arg5.value);
                    _out.write_ulong(_arg6.value);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCountHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex3);
                }
                break;
            }
            case 6: // acknowledge_alarms
            {
                try {
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[]
                        _arg0 =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSevSeqHelper.read(_input);
                    java.lang.String _arg1 = _input.read_string();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder
                        _arg3 =
                        new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper
                        .write(_out, acknowledge_alarms(_arg0, _arg1, _arg2, _arg3));
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHelper.write(_out, _arg3.value);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarmsHelper.write(_out, _ex2);
                }
                break;
            }
            case 7: // clear_alarms
            {
                try {
                    java.lang.String[]
                        _arg0 =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper.read(_input);
                    java.lang.String _arg1 = _input.read_string();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder
                        _arg3 =
                        new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper
                        .write(_out, clear_alarms(_arg0, _arg1, _arg2, _arg3));
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.write(_out, _arg3.value);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarmsHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex3);
                }
                break;
            }
            case 8: // unacknowledge_alarms
            {
                try {
                    java.lang.String[]
                        _arg0 =
                        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdSeqHelper.read(_input);
                    java.lang.String _arg1 = _input.read_string();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder
                        _arg3 =
                        new com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.SignalHelper
                        .write(_out, unacknowledge_alarms(_arg0, _arg1, _arg2, _arg3));
                    com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHelper.write(_out, _arg3.value);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.write(_out, _ex3);
                }
                break;
            }
        }
        return _out;
    }

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id) {
        return ids;
    }
}
