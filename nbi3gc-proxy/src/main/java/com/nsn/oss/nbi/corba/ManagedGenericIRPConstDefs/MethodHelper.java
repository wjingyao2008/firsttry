package com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs;


/**
 * Generated from IDL struct "Method".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:07
 */

public final class MethodHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (MethodHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init()
                            .create_struct_tc(com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodHelper.id(),
                                              "Method", new org.omg.CORBA.StructMember[]{
                                    new org.omg.CORBA.StructMember("name", org.omg.CORBA.ORB.init().create_alias_tc(
                                        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.MethodNameHelper.id(),
                                        "MethodName", org.omg.CORBA.ORB.init().create_string_tc(0)), null),
                                    new org.omg.CORBA.StructMember("parameter_list", org.omg.CORBA.ORB.init()
                                        .create_alias_tc(
                                            com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ParameterListHelper.id(),
                                            "ParameterList", org.omg.CORBA.ORB.init().create_sequence_tc(0,
                                                                                                         com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ParameterNameHelper
                                                                                                             .type())),
                                                                   null)});
                }
            }
        }
        return _type;
    }

    public static void insert(final org.omg.CORBA.Any any,
                              final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method extract(final org.omg.CORBA.Any any) {
        org.omg.CORBA.portable.InputStream in = any.create_input_stream();
        try {
            return read(in);
        } finally {
            try {
                in.close();
            } catch (java.io.IOException e) {
                throw new RuntimeException("Unexpected exception " + e.toString());
            }
        }
    }

    public static String id() {
        return "IDL:3gppsa5.org/ManagedGenericIRPConstDefs/Method:1.0";
    }

    public static com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method read(
        final org.omg.CORBA.portable.InputStream in) {
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method
            result =
            new com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method();
        result.name = in.read_string();
        result.parameter_list = com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ParameterListHelper.read(in);
        return result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream out,
                             final com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method s) {
        java.lang.String tmpResult5 = s.name;
        out.write_string(tmpResult5);
        com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ParameterListHelper.write(out, s.parameter_list);
    }
}
