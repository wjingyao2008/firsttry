package com.nsn.oss.nbi.corba.NotificationIRPSystem;


/**
 * Generated from IDL interface "NotificationIRP".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:08
 */

public abstract class NotificationIRPPOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler,
               com.nsn.oss.nbi.corba.NotificationIRPSystem.NotificationIRPOperations {

    static private final java.util.HashMap<String, Integer> m_opsHash = new java.util.HashMap<String, Integer>();

    static {
        m_opsHash.put("get_notification_IRP_notification_profile", Integer.valueOf(0));
        m_opsHash.put("get_notification_IRP_versions", Integer.valueOf(1));
        m_opsHash.put("change_subscription_filter", Integer.valueOf(2));
        m_opsHash.put("get_notification_IRP_operations_profile", Integer.valueOf(3));
        m_opsHash.put("detach", Integer.valueOf(4));
        m_opsHash.put("get_subscription_ids", Integer.valueOf(5));
        m_opsHash.put("get_subscription_status", Integer.valueOf(6));
        m_opsHash.put("attach_pull", Integer.valueOf(7));
        m_opsHash.put("get_notification_categories", Integer.valueOf(8));
        m_opsHash.put("attach_push", Integer.valueOf(9));
        m_opsHash.put("attach_push_b", Integer.valueOf(10));
    }

    private String[] ids = {"IDL:3gppsa5.org/NotificationIRPSystem/NotificationIRP:1.0"};

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
            case 0: // get_notification_IRP_notification_profile
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper
                        .write(_out, get_notification_IRP_notification_profile(_arg0));
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfile _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPNotificationProfileHelper
                        .write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 1: // get_notification_IRP_versions
            {
                try {
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_out, get_notification_IRP_versions());
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersions _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPVersionsHelper.write(_out, _ex0);
                }
                break;
            }
            case 2: // change_subscription_filter
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    java.lang.String _arg1 = _input.read_string();
                    _out = handler.createReply();
                    change_subscription_filter(_arg0, _arg1);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilter _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.ChangeSubscriptionFilterHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 3: // get_notification_IRP_operations_profile
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodListHelper
                        .write(_out, get_notification_IRP_operations_profile(_arg0));
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfile _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationIRPOperationsProfileHelper
                        .write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 4: // detach
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    java.lang.String _arg1 = _input.read_string();
                    _out = handler.createReply();
                    detach(_arg0, _arg1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachException _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.DetachExceptionHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex2);
                }
                break;
            }
            case 5: // get_subscription_ids
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionIdSetHelper
                        .write(_out, get_subscription_ids(_arg0));
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIds _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionIdsHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 6: // get_subscription_status
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder
                        _arg1 =
                        new com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHolder();
                    com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder
                        _arg2 =
                        new com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHolder();
                    org.omg.CORBA.IntHolder _arg3 = new org.omg.CORBA.IntHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_out, get_subscription_status(_arg0, _arg1, _arg2, _arg3));
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.write(_out, _arg1.value);
                    com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionStateHelper.write(_out, _arg2.value);
                    _out.write_ulong(_arg3.value);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatus _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetSubscriptionStatusHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex2);
                }
                break;
            }
            case 7: // attach_pull
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    int _arg1 = _input.read_ulong();
                    java.lang.String[]
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_input);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg3 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder
                        _arg4 =
                        new org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder();
                    _out = handler.createReply();
                    java.lang.String tmpResult20 = attach_pull(_arg0, _arg1, _arg2, _arg3, _arg4);
                    _out.write_string(tmpResult20);
                    org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHelper.write(_out, _arg4.value);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                        .write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex3);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex4) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex4);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed _ex5) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.write(_out, _ex5);
                }
                break;
            }
            case 8: // get_notification_categories
            {
                try {
                    com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder
                        _arg0 =
                        new com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHolder();
                    _out = handler.createReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper
                        .write(_out, get_notification_categories(_arg0));
                    com.nsn.oss.nbi.corba.NotificationIRPConstDefs.NotificationTypesSetHelper.write(_out, _arg0.value);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategories _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.GetNotificationCategoriesHelper.write(_out, _ex1);
                }
                break;
            }
            case 9: // attach_push
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    int _arg1 = _input.read_ulong();
                    java.lang.String[]
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_input);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg3 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    _out = handler.createReply();
                    java.lang.String tmpResult21 = attach_push(_arg0, _arg1, _arg2, _arg3);
                    _out.write_string(tmpResult21);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                        .write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex3);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed _ex4) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.write(_out, _ex4);
                }
                break;
            }
            case 10: // attach_push_b
            {
                try {
                    java.lang.String _arg0 = _input.read_string();
                    int _arg1 = _input.read_ulong();
                    java.lang.String[]
                        _arg2 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHelper.read(_input);
                    com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                        _arg3 =
                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOptHelper.read(_input);
                    org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder
                        _arg4 =
                        new org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder();
                    _out = handler.createReply();
                    java.lang.String tmpResult22 = attach_push_b(_arg0, _arg1, _arg2, _arg3, _arg4);
                    _out.write_string(tmpResult22);
                    org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHelper.write(_out, _arg4.value);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.Attach _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AttachHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupportedHelper.write(_out, _ex1);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupported _ex2) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AtLeastOneNotificationCategoryNotSupportedHelper
                        .write(_out, _ex2);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex3) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex3);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported _ex4) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupportedHelper.write(_out, _ex4);
                } catch (com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribed _ex5) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.NotificationIRPSystem.AlreadySubscribedHelper.write(_out, _ex5);
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
