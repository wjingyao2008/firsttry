package com.nsn.oss.nbi;

import java.net.MalformedURLException;

import org.omg.CORBA.IntHolder;
import org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder;
import org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder;

import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported;
import com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder;
import com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus;
import com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPPOA;
import com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.NotificationIRP;

public class NotificationIRPImpl extends NotificationIRPPOA {

    @Override
    public String[] get_notification_IRP_versions() throws GetNotificationIRPVersions {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetNotificationIRPVersions(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyIRP = InternalServiceServiceLocator.getNotificationIRP();

            String[] versions = notyIRP.get_notification_IRP_versions();

            return versions;
        } catch (MalformedURLException e) {
            throw new GetNotificationIRPVersions(
                "Failed to get notification IRP versions, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetNotificationIRPVersions e) {
            throw new GetNotificationIRPVersions(e.reason);
        } catch (Exception e) {
            throw new GetNotificationIRPVersions(e.getMessage());
        }
    }

    @Override
    public Method[] get_notification_IRP_operations_profile(String notification_irp_version)
        throws GetNotificationIRPOperationsProfile, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetNotificationIRPOperationsProfile(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method[]
                wsmethods =
                notyirp.get_notification_IRP_operations_profile(notification_irp_version);

            return TypeUtilsForInternalToOuter.parseWsListToMethodArray(wsmethods);
        } catch (MalformedURLException e) {
            throw new GetNotificationIRPOperationsProfile(
                "Failed to get notification IRP operations profile, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile e) {
            throw new GetNotificationIRPOperationsProfile(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported(e.getMessage());
        } catch (Exception e) {
            throw new GetNotificationIRPOperationsProfile(e.getMessage());
        }
    }

    @Override
    public Method[] get_notification_IRP_notification_profile(String notification_irp_version)
        throws GetNotificationIRPNotificationProfile, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetNotificationIRPNotificationProfile(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method[]
                wsmethods =
                notyirp.get_notification_IRP_notification_profile(notification_irp_version);

            return TypeUtilsForInternalToOuter.parseWsListToMethodArray(wsmethods);
        } catch (MalformedURLException e) {
            throw new GetNotificationIRPNotificationProfile(
                "Failed to get notification IRP notification profile, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile e) {
            throw new GetNotificationIRPNotificationProfile(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported(e.getMessage());
        } catch (Exception e) {
            throw new GetNotificationIRPNotificationProfile(e.getMessage());
        }
    }

    @Override
    public String[] get_notification_categories(NotificationTypesSetHolder notification_type_list)
        throws OperationNotSupported, GetNotificationCategories {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetNotificationCategories(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyIRP = InternalServiceServiceLocator.getNotificationIRP();

            com.nsn.oss.nbi.internal.corba.NotificationIRPConstDefs.NotificationTypesSetHolder
                wsnotificationTypeList =
                new com.nsn.oss.nbi.internal.corba.NotificationIRPConstDefs.NotificationTypesSetHolder();

            String[] result = notyIRP.get_notification_categories(wsnotificationTypeList);

            // out:
            notification_type_list.value = wsnotificationTypeList.value;

            return result;
        } catch (MalformedURLException e) {
            throw new GetNotificationCategories(
                "Failed to get notification categories, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetNotificationCategories e) {
            throw new GetNotificationCategories(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported(e.getMessage());
        } catch (Exception e) {
            throw new GetNotificationCategories(e.getMessage());
        }
    }

    @Override
    public String attach_push(String manager_reference, int time_tick, String[] notification_categories,
                              StringTypeOpt filter) throws Attach, ParameterNotSupported,
                                                           AtLeastOneNotificationCategoryNotSupported, InvalidParameter,
                                                           AlreadySubscribed {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new Attach(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            String proxyInstanceId = ProxyUtil.getProxyInstanceId();
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            String
                result =
                notyirp.attach_push(manager_reference, time_tick, notification_categories,
                                    TypeUtilsForOutterToInternal.parseStringTypeOpt(filter), proxyInstanceId);
            return result;
        } catch (MalformedURLException e) {
            throw new Attach("Failed to attach push, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.Attach e) {
            throw new Attach(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported e) {
            throw new AtLeastOneNotificationCategoryNotSupported(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.AlreadySubscribed e) {
            throw new AlreadySubscribed(e.getMessage());
        } catch (Exception e) {
            throw new Attach(e.getMessage());
        }
    }

    @Override
    public String attach_push_b(String manager_reference, int time_tick, String[] notification_categories,
                                StringTypeOpt filter, SequenceProxyPushSupplierHolder system_reference) throws Attach,
                                                                                                               ParameterNotSupported,
                                                                                                               AtLeastOneNotificationCategoryNotSupported,
                                                                                                               InvalidParameter,
                                                                                                               OperationNotSupported,
                                                                                                               AlreadySubscribed {
        throw new OperationNotSupported("Method attach_push_b not be supported now.");
    }

    @Override
    public String attach_pull(String manager_reference, int time_tick, String[] notification_categories,
                              StringTypeOpt filter, SequenceProxyPullSupplierHolder system_reference) throws Attach,
                                                                                                             ParameterNotSupported,
                                                                                                             AtLeastOneNotificationCategoryNotSupported,
                                                                                                             InvalidParameter,
                                                                                                             OperationNotSupported,
                                                                                                             AlreadySubscribed {
        throw new OperationNotSupported("Method attach_pull not be supported now.");
    }

    @Override
    public void change_subscription_filter(String subscription_id, String filter)
        throws ChangeSubscriptionFilter, InvalidParameter, OperationNotSupported {
        try {
            String proxyInstanceId = ProxyUtil.getProxyInstanceId();
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            notyirp.change_subscription_filter(subscription_id, filter, proxyInstanceId);
        } catch (MalformedURLException e) {
            throw new ChangeSubscriptionFilter(
                "Failed to change subscription filter, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.ChangeSubscriptionFilter e) {
            throw new ChangeSubscriptionFilter(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported();
        } catch (Exception e) {
            throw new ChangeSubscriptionFilter(e.getMessage());
        }
    }

    @Override
    public String[] get_subscription_status(String subscriptionId, StringTypeOptHolder filter_in_effect,
                                            SubscriptionStateHolder subscription_state, IntHolder time_tick)
        throws GetSubscriptionStatus,
               InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetSubscriptionStatus(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();

            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder
                wsfilterInEffect =
                new com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder();

            com.nsn.oss.nbi.internal.corba.NotificationIRPConstDefs.SubscriptionStateHolder
                wssubscriptionState =
                new com.nsn.oss.nbi.internal.corba.NotificationIRPConstDefs.SubscriptionStateHolder();
            IntHolder wstimeTick1 = new IntHolder();

            String[]
                status =
                notyirp.get_subscription_status(subscriptionId, wsfilterInEffect, wssubscriptionState, wstimeTick1);

            // out:
            filter_in_effect.value = TypeUtilsForInternalToOuter.parseStringTypeOpt(wsfilterInEffect.value);
            subscription_state.value =
                NotificationIRPTypeUtils.parseSubscriptionStateToOuter(wssubscriptionState.value);
            time_tick.value = wstimeTick1.value;

            return status;
        } catch (MalformedURLException e) {
            throw new GetSubscriptionStatus(
                "Failed to get subscription status, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetSubscriptionStatus e) {
            throw new GetSubscriptionStatus(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported(e.getMessage());
        } catch (Exception e) {
            throw new GetSubscriptionStatus(e.getMessage());
        }
    }

    @Override
    public String[] get_subscription_ids(String manager_reference)
        throws GetSubscriptionIds, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetSubscriptionIds(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            String[] ids = notyirp.get_subscription_ids(manager_reference);
            return ids;
        } catch (MalformedURLException e) {
            throw new GetSubscriptionIds("Failed to get subscription ids, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.GetSubscriptionIds e) {
            throw new GetSubscriptionIds(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            throw new OperationNotSupported();
        } catch (Exception e) {
            throw new GetSubscriptionIds(e.getMessage());
        }
    }

    @Override
    public void detach(String manager_reference, String subscription_id)
        throws ParameterNotSupported, DetachException, InvalidParameter {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new DetachException(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            NotificationIRP notyirp = InternalServiceServiceLocator.getNotificationIRP();
            notyirp.detach(manager_reference, subscription_id);
        } catch (MalformedURLException e) {
            throw new DetachException("Failed to detach, MalformedURLException: " + e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            throw new InvalidParameter(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.DetachException e) {
            throw new DetachException(e.reason);
        } catch (Exception e) {
            throw new DetachException(e.getMessage());
        }
    }

}
