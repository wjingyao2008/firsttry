package com.nsn.oss.nbi.corba.AlarmIRPSystem;


/**
 * Generated from IDL interface "AlarmInformationIterator".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public interface AlarmInformationIteratorOperations {

    /* constants */
        /* operations  */
    boolean next_alarmInformations(short how_many, org.omg.CosNotification.EventBatchHolder alarm_informations)
        throws com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations,
               com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;

    void destroy();
}
