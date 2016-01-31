package com.nsn.oss.nbi.corba.AlarmIRPSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "AlarmIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public class AlarmIRPPOATie
    extends AlarmIRPPOA {

    private AlarmIRPOperations _delegate;

    private POA _poa;

    public AlarmIRPPOATie(AlarmIRPOperations delegate) {
        _delegate = delegate;
    }

    public AlarmIRPPOATie(AlarmIRPOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

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

    public AlarmIRPOperations _delegate() {
        return _delegate;
    }

    public void _delegate(AlarmIRPOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_alarm_IRP_operations_profile(
        java.lang.String alarm_irp_version) throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_alarm_IRP_operations_profile(alarm_irp_version);
    }

    public org.omg.CosNotification.StructuredEvent[] get_alarm_list(
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt base_object, org.omg.CORBA.BooleanHolder flag,
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder iter)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        return _delegate.get_alarm_list(filter, base_object, flag, iter);
    }

    public java.lang.String[] get_alarm_IRP_versions() throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions {
        return _delegate.get_alarm_IRP_versions();
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal comment_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String comment_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt comment_system_id, java.lang.String comment_text,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.comment_alarms(alarm_information_id_list, comment_user_id, comment_system_id, comment_text,
                                        bad_alarm_information_id_list);
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_alarm_IRP_notification_profile(
        java.lang.String alarm_irp_version) throws com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
                                                   com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_alarm_IRP_notification_profile(alarm_irp_version);
    }

    public void get_alarm_count(com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                org.omg.CORBA.IntHolder critical_count, org.omg.CORBA.IntHolder major_count,
                                org.omg.CORBA.IntHolder minor_count, org.omg.CORBA.IntHolder warning_count,
                                org.omg.CORBA.IntHolder indeterminate_count, org.omg.CORBA.IntHolder cleared_count)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        _delegate.get_alarm_count(filter, critical_count, major_count, minor_count, warning_count, indeterminate_count,
                                  cleared_count);
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal acknowledge_alarms(
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[] alarm_information_id_and_sev_list,
        java.lang.String ack_user_id, com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt ack_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder bad_ack_alarm_info_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms {
        return _delegate
            .acknowledge_alarms(alarm_information_id_and_sev_list, ack_user_id, ack_system_id, bad_ack_alarm_info_list);
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal clear_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String clear_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt clear_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate
            .clear_alarms(alarm_information_id_list, clear_user_id, clear_system_id, bad_alarm_information_id_list);
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal unacknowledge_alarms(
        java.lang.String[] alarm_information_id_list, java.lang.String ack_user_id,
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt ack_system_id,
        com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms {
        return _delegate
            .unacknowledge_alarms(alarm_information_id_list, ack_user_id, ack_system_id, bad_alarm_information_id_list);
    }

}
