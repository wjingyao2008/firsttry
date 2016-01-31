package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "AlarmListAlignmentRequirementType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AlarmListAlignmentRequirementType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _REQUIRED = 0;
    public static final AlarmListAlignmentRequirementType REQUIRED = new AlarmListAlignmentRequirementType(_REQUIRED);
    public static final int _NOTREQUIRED = 1;
    public static final AlarmListAlignmentRequirementType
        NOTREQUIRED =
        new AlarmListAlignmentRequirementType(_NOTREQUIRED);

    public int value() {
        return value;
    }

    public static AlarmListAlignmentRequirementType from_int(int value) {
        switch (value) {
            case _REQUIRED:
                return REQUIRED;
            case _NOTREQUIRED:
                return NOTREQUIRED;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _REQUIRED:
                return "REQUIRED";
            case _NOTREQUIRED:
                return "NOTREQUIRED";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected AlarmListAlignmentRequirementType(int i) {
        value = i;
    }

    /**
     * Designate replacement object when deserialized from stream. See http://www.omg.org/docs/ptc/02-01-03.htm#Issue4271
     */
    java.lang.Object readResolve()
        throws java.io.ObjectStreamException {
        return from_int(value());
    }
}
