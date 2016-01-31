package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "ThresholdIndicationType".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class ThresholdIndicationType
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _UP = 0;
    public static final ThresholdIndicationType UP = new ThresholdIndicationType(_UP);
    public static final int _DOWN = 1;
    public static final ThresholdIndicationType DOWN = new ThresholdIndicationType(_DOWN);

    public int value() {
        return value;
    }

    public static ThresholdIndicationType from_int(int value) {
        switch (value) {
            case _UP:
                return UP;
            case _DOWN:
                return DOWN;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _UP:
                return "UP";
            case _DOWN:
                return "DOWN";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected ThresholdIndicationType(int i) {
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
