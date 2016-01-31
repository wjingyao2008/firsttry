package com.nsn.oss.nbi;

import com.nsn.oss.nbi.corba.NotificationIRPConstDefs.SubscriptionState;

/**
 * Type parse utils class for NotificationIRP
 *
 * @author bihhe
 */
public class NotificationIRPTypeUtils {

    /**
     * Parse coaba ResultContents type to webservice type
     */
    public static SubscriptionState parseSubscriptionStateToOuter(
        com.nsn.oss.nbi.internal.corba.NotificationIRPConstDefs.SubscriptionState wsstate) throws Exception {
        return SubscriptionState.from_int(wsstate.value());
    }
}
