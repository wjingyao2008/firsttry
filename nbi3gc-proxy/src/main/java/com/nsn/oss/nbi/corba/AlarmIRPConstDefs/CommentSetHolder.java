package com.nsn.oss.nbi.corba.AlarmIRPConstDefs;

/**
 * Generated from IDL alias "CommentSet".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 20-Jul-2015 11:13:35
 */

public final class CommentSetHolder
    implements org.omg.CORBA.portable.Streamable {

    public com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] value;

    public CommentSetHolder() {
    }

    public CommentSetHolder(final com.nsn.oss.nbi.corba.AlarmIRPConstDefs.Comment[] initial) {
        value = initial;
    }

    public org.omg.CORBA.TypeCode _type() {
        return CommentSetHelper.type();
    }

    public void _read(final org.omg.CORBA.portable.InputStream in) {
        value = CommentSetHelper.read(in);
    }

    public void _write(final org.omg.CORBA.portable.OutputStream out) {
        CommentSetHelper.write(out, value);
    }
}
