package com.nsn.oss.nbi.corba.NotificationIRPSystem;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public class NotificationIRPPOATie
    extends NotificationIRPPOA {

    private NotificationIRPOperations _delegate;

    private POA _poa;

    public NotificationIRPPOATie(NotificationIRPOperations delegate) {
        _delegate = delegate;
    }

    public NotificationIRPPOATie(NotificationIRPOperations delegate, POA poa) {
        _delegate = delegate;
        _poa = poa;
    }

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP
            __r =
            com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRP
            __r =
            com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public NotificationIRPOperations _delegate() {
        return _delegate;
    }

    public void _delegate(NotificationIRPOperations delegate) {
        _delegate = delegate;
    }

    public POA _default_POA() {
        if (_poa != null) {
            return _poa;
        }
        return super._default_POA();
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_notification_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_notification_IRP_notification_profile(notification_irp_version);
    }

    public java.lang.String[] get_notification_IRP_versions()
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions {
        return _delegate.get_notification_IRP_versions();
    }

    public void change_subscription_filter(java.lang.String subscription_id, java.lang.String filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        _delegate.change_subscription_filter(subscription_id, filter);
    }

    public com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method[] get_notification_IRP_operations_profile(
        java.lang.String notification_irp_version)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_notification_IRP_operations_profile(notification_irp_version);
    }

    public void detach(java.lang.String manager_reference, java.lang.String subscription_id)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        _delegate.detach(manager_reference, subscription_id);
    }

    public java.lang.String[] get_subscription_ids(java.lang.String manager_reference)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_subscription_ids(manager_reference);
    }

    public java.lang.String[] get_subscription_status(java.lang.String subscription_id,
                                                      com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder filter_in_effect,
                                                      com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder subscription_state,
                                                      org.omg.CORBA.IntHolder time_tick)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported {
        return _delegate.get_subscription_status(subscription_id, filter_in_effect, subscription_state, time_tick);
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
        return _delegate.attach_pull(manager_reference, time_tick, notification_categories, filter, system_reference);
    }

    public java.lang.String[] get_notification_categories(
        com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder notification_type_list)
        throws com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories {
        return _delegate.get_notification_categories(notification_type_list);
    }

    public java.lang.String attach_push(java.lang.String manager_reference, int time_tick,
                                        java.lang.String[] notification_categories,
                                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt filter)
        throws com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed {
        return _delegate.attach_push(manager_reference, time_tick, notification_categories, filter);
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
        return _delegate.attach_push_b(manager_reference, time_tick, notification_categories, filter, system_reference);
    }

}
