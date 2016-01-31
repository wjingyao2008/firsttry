package com.nsn.oss.nbi.corba.NotificationIRPSystem;


/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public interface NotificationIRPOperations {

    /* constants */
        /* operations  */
    java.lang.String[] get_notification_IRP_versions()
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions;

    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_operations_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;

    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_notification_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;

    java.lang.String[] get_notification_categories(
        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder notification_type_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories;

    java.lang.String attach_push(java.lang.String manager_reference, int time_tick,
                                 java.lang.String[] notification_categories,
                                 com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed;

    java.lang.String attach_push_b(java.lang.String manager_reference, int time_tick,
                                   java.lang.String[] notification_categories,
                                   com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                   org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder system_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed;

    java.lang.String attach_pull(java.lang.String manager_reference, int time_tick,
                                 java.lang.String[] notification_categories,
                                 com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter,
                                 org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder system_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed;

    void change_subscription_filter(java.lang.String subscription_id, java.lang.String filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;

    java.lang.String[] get_subscription_status(java.lang.String subscription_id,
                                               com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder filter_in_effect,
                                               com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder subscription_state,
                                               org.omg.CORBA.IntHolder time_tick)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;

    java.lang.String[] get_subscription_ids(java.lang.String manager_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;

    void detach(java.lang.String manager_reference, java.lang.String subscription_id)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;
}
