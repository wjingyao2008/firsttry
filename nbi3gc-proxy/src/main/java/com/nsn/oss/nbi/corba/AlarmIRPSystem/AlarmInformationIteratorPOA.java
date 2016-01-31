package com.nsn.oss.nbi.corba.AlarmIRPSystem;


/**
 * Generated from IDL interface "AlarmInformationIterator".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public abstract class AlarmInformationIteratorPOA
    extends org.omg.PortableServer.Servant
    implements org.omg.CORBA.portable.InvokeHandler,
               com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorOperations {

    static private final java.util.HashMap<String, Integer> m_opsHash = new java.util.HashMap<String, Integer>();

    static {
        m_opsHash.put("next_alarmInformations", Integer.valueOf(0));
        m_opsHash.put("destroy", Integer.valueOf(1));
    }

    private String[] ids = {"IDL:3gppsa5.org/AlarmIRPSystem/AlarmInformationIterator:1.0"};

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator _this() {
        org.omg.CORBA.Object __o = _this_object();
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.narrow(__o);
        if (__o != null && __o != __r) {
            ((org.omg.CORBA.portable.ObjectImpl) __o)._set_delegate(null);

        }
        return __r;
    }

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator _this(org.omg.CORBA.ORB orb) {
        org.omg.CORBA.Object __o = _this_object(orb);
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator
            __r =
            com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHelper.narrow(__o);
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
            case 0: // next_alarmInformations
            {
                try {
                    short _arg0 = _input.read_ushort();
                    org.omg.CosNotification.EventBatchHolder _arg1 = new org.omg.CosNotification.EventBatchHolder();
                    _out = handler.createReply();
                    _out.write_boolean(next_alarmInformations(_arg0, _arg1));
                    org.omg.CosNotification.EventBatchHelper.write(_out, _arg1.value);
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations _ex0) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformationsHelper.write(_out, _ex0);
                } catch (com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter _ex1) {
                    _out = handler.createExceptionReply();
                    com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameterHelper.write(_out, _ex1);
                }
                break;
            }
            case 1: // destroy
            {
                _out = handler.createReply();
                destroy();
                break;
            }
        }
        return _out;
    }

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id) {
        return ids;
    }
}
