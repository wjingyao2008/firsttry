package com.nsn.oss.nbi.corba.NotificationTransformConstDefs;

/**
 * Generated from IDL alias "NotificationSeq".
 *
 * @author JacORB IDL compiler V 3.1, 19-Aug-2012
 * @version generated at 14-Jul-2015 14:42:10
 */

public final class NotificationSeqHelper {

    private volatile static org.omg.CORBA.TypeCode _type;

    public static void insert(org.omg.CORBA.Any any, org.omg.CosNotification.StructuredEvent[] s) {
        any.type(type());
        write(any.create_output_stream(), s);
    }

    public static org.omg.CosNotification.StructuredEvent[] extract(final org.omg.CORBA.Any any) {
        if (any.type().kind() == org.omg.CORBA.TCKind.tk_null) {
            throw new org.omg.CORBA.BAD_OPERATION("Can't extract from Any with null type.");
        }
        return read(any.create_input_stream());
    }

    public static org.omg.CORBA.TypeCode type() {
        if (_type == null) {
            synchronized (NotificationSeqHelper.class) {
                if (_type == null) {
                    _type =
                        org.omg.CORBA.ORB.init().create_alias_tc(
                            com.nsn.oss.nbi.corba.NotificationTransformConstDefs.NotificationSeqHelper.id(),
                            "NotificationSeq", org.omg.CORBA.ORB.init()
                                .create_alias_tc(org.omg.CosNotification.EventBatchHelper.id(), "EventBatch",
                                                 org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init()
                                                     .create_struct_tc(
                                                         org.omg.CosNotification.StructuredEventHelper.id(),
                                                         "StructuredEvent", new org.omg.CORBA.StructMember[]{
                                                             new org.omg.CORBA.StructMember("header",
                                                                                            org.omg.CORBA.ORB.init()
                                                                                                .create_struct_tc(
                                                                                                    org.omg.CosNotification.EventHeaderHelper
                                                                                                        .id(),
                                                                                                    "EventHeader",
                                                                                                    new org.omg.CORBA.StructMember[]{
                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                            "fixed_header",
                                                                                                            org.omg.CORBA.ORB
                                                                                                                .init()
                                                                                                                .create_struct_tc(
                                                                                                                    org.omg.CosNotification.FixedEventHeaderHelper
                                                                                                                        .id(),
                                                                                                                    "FixedEventHeader",
                                                                                                                    new org.omg.CORBA.StructMember[]{
                                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                                            "event_type",
                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                .init()
                                                                                                                                .create_struct_tc(
                                                                                                                                    org.omg.CosNotification.EventTypeHelper
                                                                                                                                        .id(),
                                                                                                                                    "EventType",
                                                                                                                                    new org.omg.CORBA.StructMember[]{
                                                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                                                            "domain_name",
                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                .init()
                                                                                                                                                .create_string_tc(
                                                                                                                                                    0),
                                                                                                                                            null),
                                                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                                                            "type_name",
                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                .init()
                                                                                                                                                .create_string_tc(
                                                                                                                                                    0),
                                                                                                                                            null)}),
                                                                                                                            null),
                                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                                            "event_name",
                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                .init()
                                                                                                                                .create_string_tc(
                                                                                                                                    0),
                                                                                                                            null)}),
                                                                                                            null),
                                                                                                        new org.omg.CORBA.StructMember(
                                                                                                            "variable_header",
                                                                                                            org.omg.CORBA.ORB
                                                                                                                .init()
                                                                                                                .create_alias_tc(
                                                                                                                    org.omg.CosNotification.OptionalHeaderFieldsHelper
                                                                                                                        .id(),
                                                                                                                    "OptionalHeaderFields",
                                                                                                                    org.omg.CORBA.ORB
                                                                                                                        .init()
                                                                                                                        .create_alias_tc(
                                                                                                                            org.omg.CosNotification.PropertySeqHelper
                                                                                                                                .id(),
                                                                                                                            "PropertySeq",
                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                .init()
                                                                                                                                .create_sequence_tc(
                                                                                                                                    0,
                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                        .init()
                                                                                                                                        .create_struct_tc(
                                                                                                                                            org.omg.CosNotification.PropertyHelper
                                                                                                                                                .id(),
                                                                                                                                            "Property",
                                                                                                                                            new org.omg.CORBA.StructMember[]{
                                                                                                                                                new org.omg.CORBA.StructMember(
                                                                                                                                                    "name",
                                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                                        .init()
                                                                                                                                                        .create_alias_tc(
                                                                                                                                                            org.omg.CosNotification.PropertyNameHelper
                                                                                                                                                                .id(),
                                                                                                                                                            "PropertyName",
                                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                                .init()
                                                                                                                                                                .create_alias_tc(
                                                                                                                                                                    org.omg.CosNotification.IstringHelper
                                                                                                                                                                        .id(),
                                                                                                                                                                    "Istring",
                                                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                                                        .init()
                                                                                                                                                                        .create_string_tc(
                                                                                                                                                                            0))),
                                                                                                                                                    null),
                                                                                                                                                new org.omg.CORBA.StructMember(
                                                                                                                                                    "value",
                                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                                        .init()
                                                                                                                                                        .create_alias_tc(
                                                                                                                                                            org.omg.CosNotification.PropertyValueHelper
                                                                                                                                                                .id(),
                                                                                                                                                            "PropertyValue",
                                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                                .init()
                                                                                                                                                                .get_primitive_tc(
                                                                                                                                                                    org.omg.CORBA.TCKind
                                                                                                                                                                        .from_int(
                                                                                                                                                                            11))),
                                                                                                                                                    null)})))),
                                                                                                            null)}),
                                                                                            null),
                                                             new org.omg.CORBA.StructMember("filterable_data",
                                                                                            org.omg.CORBA.ORB.init()
                                                                                                .create_alias_tc(
                                                                                                    org.omg.CosNotification.FilterableEventBodyHelper
                                                                                                        .id(),
                                                                                                    "FilterableEventBody",
                                                                                                    org.omg.CORBA.ORB
                                                                                                        .init()
                                                                                                        .create_alias_tc(
                                                                                                            org.omg.CosNotification.PropertySeqHelper
                                                                                                                .id(),
                                                                                                            "PropertySeq",
                                                                                                            org.omg.CORBA.ORB
                                                                                                                .init()
                                                                                                                .create_sequence_tc(
                                                                                                                    0,
                                                                                                                    org.omg.CORBA.ORB
                                                                                                                        .init()
                                                                                                                        .create_struct_tc(
                                                                                                                            org.omg.CosNotification.PropertyHelper
                                                                                                                                .id(),
                                                                                                                            "Property",
                                                                                                                            new org.omg.CORBA.StructMember[]{
                                                                                                                                new org.omg.CORBA.StructMember(
                                                                                                                                    "name",
                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                        .init()
                                                                                                                                        .create_alias_tc(
                                                                                                                                            org.omg.CosNotification.PropertyNameHelper
                                                                                                                                                .id(),
                                                                                                                                            "PropertyName",
                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                .init()
                                                                                                                                                .create_alias_tc(
                                                                                                                                                    org.omg.CosNotification.IstringHelper
                                                                                                                                                        .id(),
                                                                                                                                                    "Istring",
                                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                                        .init()
                                                                                                                                                        .create_string_tc(
                                                                                                                                                            0))),
                                                                                                                                    null),
                                                                                                                                new org.omg.CORBA.StructMember(
                                                                                                                                    "value",
                                                                                                                                    org.omg.CORBA.ORB
                                                                                                                                        .init()
                                                                                                                                        .create_alias_tc(
                                                                                                                                            org.omg.CosNotification.PropertyValueHelper
                                                                                                                                                .id(),
                                                                                                                                            "PropertyValue",
                                                                                                                                            org.omg.CORBA.ORB
                                                                                                                                                .init()
                                                                                                                                                .get_primitive_tc(
                                                                                                                                                    org.omg.CORBA.TCKind
                                                                                                                                                        .from_int(
                                                                                                                                                            11))),
                                                                                                                                    null)})))),
                                                                                            null),
                                                             new org.omg.CORBA.StructMember("remainder_of_body",
                                                                                            org.omg.CORBA.ORB.init()
                                                                                                .get_primitive_tc(
                                                                                                    org.omg.CORBA.TCKind
                                                                                                        .from_int(11)),
                                                                                            null)}))));
                }
            }
        }
        return _type;
    }

    public static String id() {
        return "IDL:NotificationTransformConstDefs/NotificationSeq:1.0";
    }

    public static org.omg.CosNotification.StructuredEvent[] read(final org.omg.CORBA.portable.InputStream _in) {
        org.omg.CosNotification.StructuredEvent[] _result;
        _result = org.omg.CosNotification.EventBatchHelper.read(_in);
        return _result;
    }

    public static void write(final org.omg.CORBA.portable.OutputStream _out,
                             org.omg.CosNotification.StructuredEvent[] _s) {
        org.omg.CosNotification.EventBatchHelper.write(_out, _s);
    }
}
