package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "CorelatedNotification".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CorelatedNotification
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public CorelatedNotification() {
    }

    public java.lang.String source;
    public int[] notif_id_set;

    public CorelatedNotification(java.lang.String source, int[] notif_id_set) {
        this.source = source;
        this.notif_id_set = notif_id_set;
    }
}
