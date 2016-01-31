package com.nsn.oss.nbi;

import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt;

public class AlarmIRPTypeUtils {

    static com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.DNTypeOpt parseDNTypeOptToInternal(DNTypeOpt source) {
        com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.DNTypeOpt
            target =
            new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.DNTypeOpt();
        if (source.discriminator()) {
            target.value(source.value());
        } else {
            target.not_used((short) 0);
        }
        return target;
    }
}
