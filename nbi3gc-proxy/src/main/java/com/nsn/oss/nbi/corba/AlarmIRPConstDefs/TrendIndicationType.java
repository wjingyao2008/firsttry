package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "TrendIndicationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class TrendIndicationType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _LessSevere = 0;
    public static final TrendIndicationType LessSevere = new TrendIndicationType(_LessSevere);
    public static final int _NoChange = 1;
    public static final TrendIndicationType NoChange = new TrendIndicationType(_NoChange);
    public static final int _MoreSevere = 2;
    public static final TrendIndicationType MoreSevere = new TrendIndicationType(_MoreSevere);

    public int value() {
        return value;
    }

    public static TrendIndicationType from_int(int value) {
        switch (value) {
            case _LessSevere:
                return LessSevere;
            case _NoChange:
                return NoChange;
            case _MoreSevere:
                return MoreSevere;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _LessSevere:
                return "LessSevere";
            case _NoChange:
                return "NoChange";
            case _MoreSevere:
                return "MoreSevere";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected TrendIndicationType(int i) {
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
