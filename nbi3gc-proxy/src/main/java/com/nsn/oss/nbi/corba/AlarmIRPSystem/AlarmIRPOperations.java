package com.nsn.oss.nbi.corba.AlarmIRPSystem;


import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported;

import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.IntHolder;
import org.omg.CosNotification.StructuredEvent;

/**
 * Generated from IDL interface "AlarmIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public interface AlarmIRPOperations {

    /* constants */
        /* operations  */
    String[] get_alarm_IRP_versions() throws GetAlarmIRPVersions;

    Method[] get_alarm_IRP_operations_profile(
        String alarm_irp_version) throws GetAlarmIRPOperationsProfile,
                                         InvalidParameter,
                                         OperationNotSupported;

    Method[] get_alarm_IRP_notification_profile(
        String alarm_irp_version) throws GetAlarmIRPNotificationProfile,
                                         InvalidParameter,
                                         OperationNotSupported;

    Signal acknowledge_alarms(
        AlarmInformationIdAndSev[] alarm_information_id_and_sev_list,
        String ack_user_id, StringTypeOpt ack_system_id,
        BadAcknowledgeAlarmInfoSeqHolder bad_ack_alarm_info_list)
        throws ParameterNotSupported,
               InvalidParameter,
               AcknowledgeAlarms;

    Signal unacknowledge_alarms(
        String[] alarm_information_id_list, String ack_user_id,
        StringTypeOpt ack_system_id,
        BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ParameterNotSupported,
               InvalidParameter,
               OperationNotSupported,
               UnacknowledgeAlarms;

    Signal comment_alarms(String[] alarm_information_id_list,
                          String comment_user_id,
                          StringTypeOpt comment_system_id,
                          String comment_text,
                          BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ParameterNotSupported,
               CommentAlarms,
               InvalidParameter,
               OperationNotSupported;

    Signal clear_alarms(String[] alarm_information_id_list,
                        String clear_user_id,
                        StringTypeOpt clear_system_id,
                        BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ClearAlarms,
               ParameterNotSupported,
               InvalidParameter,
               OperationNotSupported;

    StructuredEvent[] get_alarm_list(
        StringTypeOpt filter,
        DNTypeOpt base_object, BooleanHolder flag,
        AlarmInformationIteratorHolder iter)
        throws GetAlarmList,
               ParameterNotSupported,
               InvalidParameter;

    void get_alarm_count(StringTypeOpt filter,
                         IntHolder critical_count, IntHolder major_count,
                         IntHolder minor_count, IntHolder warning_count,
                         IntHolder indeterminate_count, IntHolder cleared_count)
        throws ParameterNotSupported,
               GetAlarmCount,
               InvalidParameter,
               OperationNotSupported;
}
