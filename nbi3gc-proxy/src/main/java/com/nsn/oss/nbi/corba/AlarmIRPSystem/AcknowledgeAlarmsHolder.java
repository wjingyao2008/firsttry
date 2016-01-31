package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "AcknowledgeAlarms".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class AcknowledgeAlarmsHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms value;

    public AcknowledgeAlarmsHolder() {
    }

    public AcknowledgeAlarmsHolder(final com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarmsHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarmsHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarmsHelper.write(_out, value);
    }
}
