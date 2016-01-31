package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL struct "Comment".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class Comment
    implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public Comment() {
    }

    public org.omg.TimeBase.UtcT comment_time;
    public java.lang.String comment_text = "";
    public java.lang.String user_id = "";
    public java.lang.String system_id = "";

    public Comment(org.omg.TimeBase.UtcT comment_time, java.lang.String comment_text, java.lang.String user_id,
                   java.lang.String system_id) {
        this.comment_time = comment_time;
        this.comment_text = comment_text;
        this.user_id = user_id;
        this.system_id = system_id;
    }
}
