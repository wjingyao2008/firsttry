package com.nsn.oss.nbi.corba.AlarmIRPSystem;


/**
 * Generated from IDL interface "AlarmInformationIterator".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public class _AlarmInformationIteratorStub
    extends org.omg.CORBA.portable.ObjectImpl
    implements com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private String[] ids = {"IDL:3gppsa5.org/AlarmIRPSystem/AlarmInformationIterator:1.0"};

    public String[] _ids() {
        return ids;
    }

    public final static java.lang.Class
        _opsClass =
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorOperations.class;

    public boolean next_alarmInformations(short how_many, org.omg.CosNotification.EventBatchHolder alarm_informations)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("next_alarmInformations", true);
                    _os.write_ushort(how_many);
                    _is = _invoke(_os);
                    boolean _result = _is.read_boolean();
                    alarm_informations.value = org.omg.CosNotification.EventBatchHelper.read(_is);
                    return _result;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        if (_id.equals("IDL:3gppsa5.org/AlarmIRPSystem/NextAlarmInformations:1.0")) {
                            throw com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformationsHelper
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("next_alarmInformations", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmInformationIteratorOperations _localServant = (AlarmInformationIteratorOperations) _so.servant;
                boolean _result;
                try {
                    _result = _localServant.next_alarmInformations(how_many, alarm_informations);
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return _result;
                } catch (com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations ex) {
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

    public void destroy() {
        while (true) {
            if (!this._is_local()) {
                org.omg.CORBA.portable.InputStream _is = null;
                org.omg.CORBA.portable.OutputStream _os = null;
                try {
                    _os = _request("destroy", true);
                    _is = _invoke(_os);
                    return;
                } catch (org.omg.CORBA.portable.RemarshalException _rx) {
                    continue;
                } catch (org.omg.CORBA.portable.ApplicationException _ax) {
                    String _id = _ax.getId();
                    try {
                        _ax.getInputStream().close();
                    } catch (java.io.IOException e) {
                        throw new RuntimeException("Unexpected exception " + e.toString());
                    }
                    throw new RuntimeException("Unexpected exception " + _id);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("destroy", _opsClass);
                if (_so == null) {
                    continue;
                }
                AlarmInformationIteratorOperations _localServant = (AlarmInformationIteratorOperations) _so.servant;
                try {
                    _localServant.destroy();
                    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
                        ((org.omg.CORBA.portable.ServantObjectExt) _so).normalCompletion();
                    }
                    return;
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
