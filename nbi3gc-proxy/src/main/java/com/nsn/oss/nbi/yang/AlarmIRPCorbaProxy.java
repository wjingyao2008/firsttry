package com.nsn.oss.nbi.yang;

import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPOperations;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPPOA;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms;
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
 * Created by y28yang on 1/30/2016.
 */
public class AlarmIRPCorbaProxy extends AlarmIRPPOA {


    private final AlarmIRPOperations operationHandler;

    public AlarmIRPCorbaProxy(AlarmIRPOperations operationHandler){

        this.operationHandler = operationHandler;
    }

    @Override
    public String[] get_alarm_IRP_versions() throws GetAlarmIRPVersions {
        return operationHandler.get_alarm_IRP_versions();
    }

    @Override
    public Method[] get_alarm_IRP_operations_profile(String alarm_irp_version)
        throws GetAlarmIRPOperationsProfile, InvalidParameter, OperationNotSupported {
        return operationHandler.get_alarm_IRP_operations_profile(alarm_irp_version);
    }

    @Override
    public Method[] get_alarm_IRP_notification_profile(String alarm_irp_version)
        throws GetAlarmIRPNotificationProfile, InvalidParameter, OperationNotSupported {
        return operationHandler.get_alarm_IRP_notification_profile(alarm_irp_version);
    }

    @Override
    public Signal acknowledge_alarms(AlarmInformationIdAndSev[] alarm_information_id_and_sev_list, String ack_user_id,
                                     StringTypeOpt ack_system_id,
                                     BadAcknowledgeAlarmInfoSeqHolder bad_ack_alarm_info_list)
        throws ParameterNotSupported, InvalidParameter, AcknowledgeAlarms {
        return operationHandler.acknowledge_alarms(alarm_information_id_and_sev_list,ack_user_id,ack_system_id,bad_ack_alarm_info_list);
    }

    @Override
    public Signal unacknowledge_alarms(String[] alarm_information_id_list, String ack_user_id,
                                       StringTypeOpt ack_system_id,
                                       BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ParameterNotSupported, InvalidParameter, OperationNotSupported, UnacknowledgeAlarms {
        return operationHandler.unacknowledge_alarms(alarm_information_id_list,ack_user_id,ack_system_id,bad_alarm_information_id_list);
    }

    @Override
    public Signal comment_alarms(String[] alarm_information_id_list, String comment_user_id,
                                 StringTypeOpt comment_system_id, String comment_text,
                                 BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ParameterNotSupported, CommentAlarms, InvalidParameter, OperationNotSupported {
        return operationHandler.comment_alarms(alarm_information_id_list,comment_user_id,
                                               comment_system_id,comment_text,bad_alarm_information_id_list);
    }

    @Override
    public Signal clear_alarms(String[] alarm_information_id_list, String clear_user_id, StringTypeOpt clear_system_id,
                               BadAlarmInformationIdSeqHolder bad_alarm_information_id_list)
        throws ClearAlarms, ParameterNotSupported, InvalidParameter, OperationNotSupported {
        return operationHandler.clear_alarms(alarm_information_id_list,clear_user_id,clear_system_id,bad_alarm_information_id_list);
    }

    @Override
    public StructuredEvent[] get_alarm_list(StringTypeOpt filter, DNTypeOpt base_object, BooleanHolder flag,
                                            AlarmInformationIteratorHolder iter)
        throws GetAlarmList, ParameterNotSupported, InvalidParameter {
        return operationHandler.get_alarm_list(filter,base_object,flag,iter);
    }

    @Override
    public void get_alarm_count(StringTypeOpt filter, IntHolder critical_count, IntHolder major_count,
                                IntHolder minor_count, IntHolder warning_count, IntHolder indeterminate_count,
                                IntHolder cleared_count)
        throws ParameterNotSupported, GetAlarmCount, InvalidParameter, OperationNotSupported {
        operationHandler.get_alarm_count(filter,critical_count,major_count,minor_count,warning_count,indeterminate_count,cleared_count);
    }
}
