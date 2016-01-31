package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL enum "AcknowledgeFailureCategories".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class AcknowledgeFailureCategories
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _UnknownAlarmId = 0;
    public static final AcknowledgeFailureCategories UnknownAlarmId = new AcknowledgeFailureCategories(_UnknownAlarmId);
    public static final int _WrongPerceivedSeverity = 1;
    public static final AcknowledgeFailureCategories
        WrongPerceivedSeverity =
        new AcknowledgeFailureCategories(_WrongPerceivedSeverity);
    public static final int _AcknowledgmentFailed = 2;
    public static final AcknowledgeFailureCategories
        AcknowledgmentFailed =
        new AcknowledgeFailureCategories(_AcknowledgmentFailed);

    public int value() {
        return value;
    }

    public static AcknowledgeFailureCategories from_int(int value) {
        switch (value) {
            case _UnknownAlarmId:
                return UnknownAlarmId;
            case _WrongPerceivedSeverity:
                return WrongPerceivedSeverity;
            case _AcknowledgmentFailed:
                return AcknowledgmentFailed;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _UnknownAlarmId:
                return "UnknownAlarmId";
            case _WrongPerceivedSeverity:
                return "WrongPerceivedSeverity";
            case _AcknowledgmentFailed:
                return "AcknowledgmentFailed";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected AcknowledgeFailureCategories(int i) {
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
