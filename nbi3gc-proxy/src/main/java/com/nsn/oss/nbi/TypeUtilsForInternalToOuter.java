package com.nsn.oss.nbi;

import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt;

/**
 * Utility class for parse Webservice data type to corba type
 *
 * @author bihhe
 */
public final class TypeUtilsForInternalToOuter {

    /**
     * Parse webservice Method[] type to corba type
     */
    public static Method[] parseWsListToMethodArray(
        com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method[] wsMethods) {
        if (null == wsMethods) {
            return null;
        }

        Method[] corbaMethods = new Method[wsMethods.length];
        for (int i = 0; i < wsMethods.length; i++) {
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method wsmethod = wsMethods[i];
            corbaMethods[i] = new Method(wsmethod.name, wsmethod.parameter_list);
        }
        return corbaMethods;
    }


    /**
     * Parse webservice StringTypeOpt type to coaba type
     */
    public static StringTypeOpt parseStringTypeOpt(
        com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt source) {
        StringTypeOpt type = new StringTypeOpt();
        if (source.discriminator()) {
            type.value(source.value());
        }
        return type;
    }


}
