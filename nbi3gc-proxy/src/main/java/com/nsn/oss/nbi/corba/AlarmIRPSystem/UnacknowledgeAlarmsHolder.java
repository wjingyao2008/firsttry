package com.nsn.oss.nbi.corba.AlarmIRPSystem;

/**
 * Generated from IDL exception "UnacknowledgeAlarms".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:09
 */

public final class UnacknowledgeAlarmsHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms value;

    public UnacknowledgeAlarmsHolder() {
    }

    public UnacknowledgeAlarmsHolder(final com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream _in) {
        value = com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.read(_in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream _out) {
        com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarmsHelper.write(_out, value);
    }
}
