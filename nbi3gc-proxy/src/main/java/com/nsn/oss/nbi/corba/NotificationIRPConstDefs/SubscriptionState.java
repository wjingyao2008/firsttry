package com.nsn.oss.nbi.corba.NotificationIRPConstDefs;

/**
 * Generated from IDL enum "SubscriptionState".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:06
 */

public final class SubscriptionState
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _ACTIVE = 0;
    public static final SubscriptionState ACTIVE = new SubscriptionState(_ACTIVE);
    public static final int _SUSPENDED = 1;
    public static final SubscriptionState SUSPENDED = new SubscriptionState(_SUSPENDED);
    public static final int _INVALID = 2;
    public static final SubscriptionState INVALID = new SubscriptionState(_INVALID);

    public int value() {
        return value;
    }

    public static SubscriptionState from_int(int value) {
        switch (value) {
            case _ACTIVE:
                return ACTIVE;
            case _SUSPENDED:
                return SUSPENDED;
            case _INVALID:
                return INVALID;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _ACTIVE:
                return "ACTIVE";
            case _SUSPENDED:
                return "SUSPENDED";
            case _INVALID:
                return "INVALID";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected SubscriptionState(int i) {
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
