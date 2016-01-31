package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;

/**
 * Generated from IDL enum "Signal".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class Signal
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    private int value = -1;
    public static final int _OK = 0;
    public static final Signal OK = new Signal(_OK);
    public static final int _FAILURE = 1;
    public static final Signal FAILURE = new Signal(_FAILURE);
    public static final int _PARTIALFAILURE = 2;
    public static final Signal PARTIALFAILURE = new Signal(_PARTIALFAILURE);

    public int value() {
        return value;
    }

    public static Signal from_int(int value) {
        switch (value) {
            case _OK:
                return OK;
            case _FAILURE:
                return FAILURE;
            case _PARTIALFAILURE:
                return PARTIALFAILURE;
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    public String toString() {
        switch (value) {
            case _OK:
                return "OK";
            case _FAILURE:
                return "FAILURE";
            case _PARTIALFAILURE:
                return "PARTIALFAILURE";
            default:
                throw new org.omg.CORBA.BAD_PARAM();
        }
    }

    protected Signal(int i) {
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
