package com.nsn.oss.nbi;

import org.omg.CORBA.ShortHolder;

import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.ShortTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.VersionNumberSetHolder;


/**
 * Utility class for parse corba data type to Webservice type
 *
 * @author bihhe
 */
public final class TypeUtilsForOutterToInternal {

    /**
     * Parse corba ShortHolder type to webservice type
     */
    public static javax.xml.ws.Holder<Short> parseShortHolder(ShortHolder shortHolder) {
        return new javax.xml.ws.Holder<Short>(shortHolder.value);
    }

    public static com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.ShortTypeOpt parseShortTypeOpt(
        ShortTypeOpt source) {
        com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.ShortTypeOpt
            target =
            new com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.ShortTypeOpt();
        if (source.discriminator()) {
            target.value(source.value());
        } else {
            target.not_used("");
        }
        return target;
    }

    public static com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt parseStringTypeOpt(
        StringTypeOpt source) {
        com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
            target =
            new com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt();
        if (source.discriminator()) {
            target.value(source.value());
        } else {
            target.not_used((short) 0);
        }
        return target;
    }


    /**
     * Parse corba VersionNumberSetHolder type to webservice type
     */
    public static com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.VersionNumberSetHolder parseVersionNumberSetHolder(
        VersionNumberSetHolder versionNumberList) {
        if (null == versionNumberList) {
            return null;
        }

        com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.VersionNumberSetHolder
            holderlist =
            new com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.VersionNumberSetHolder();
        if (null != versionNumberList.value) {
            String[] versions = versionNumberList.value;
            holderlist.value = versions;
        }
        return holderlist;
    }


}
