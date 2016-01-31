package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "AlarmListAlignmentRequirementType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmListAlignmentRequirementTypeHolder
    implements org.omg.CORBA.portable.Streamable {

    public AlarmListAlignmentRequirementType value;

    public AlarmListAlignmentRequirementTypeHolder() {
    }

    public AlarmListAlignmentRequirementTypeHolder(final AlarmListAlignmentRequirementType initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return AlarmListAlignmentRequirementTypeHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = AlarmListAlignmentRequirementTypeHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        AlarmListAlignmentRequirementTypeHelper.write(out, value);
    }
}
