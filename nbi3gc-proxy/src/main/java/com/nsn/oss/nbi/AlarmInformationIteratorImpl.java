package com.nsn.oss.nbi;

import com.nsn.oss.nbi.common.Logger;
import org.omg.CosNotification.EventBatchHolder;
import org.omg.CosNotification.StructuredEvent;

import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorPOA;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.NextAlarmInformations;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;
import com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmInformationIterator;


public class AlarmInformationIteratorImpl extends AlarmInformationIteratorPOA {

    private static final Logger LOGGER = Logger.getLogger(AlarmInformationIteratorImpl.class);
    private AlarmInformationIterator reference;

    public AlarmInformationIteratorImpl(AlarmInformationIterator reference) {
        this.reference = reference;
    }

    @Override
    public boolean next_alarmInformations(short howManySource, EventBatchHolder alarmInformationsSource)
        throws NextAlarmInformations, InvalidParameter {
        LOGGER.info("Begin to getNext: " + howManySource);
        try {
            long beforeInvoke = System.currentTimeMillis();
            boolean result = reference.next_alarmInformations(howManySource, alarmInformationsSource);
            StructuredEvent[] structuredEventArraySource = alarmInformationsSource.value;
            //alarmInformationsSource.value = structuredEventArraySource;
            LOGGER.info("Complete to getNext, size: " + structuredEventArraySource.length + " result: " + result);
            long afterInvoke = System.currentTimeMillis();
            LOGGER.trace("time spent on next_alarmInformations is:" + (afterInvoke - beforeInvoke));
            return result;
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.NextAlarmInformations e) {
            LOGGER.error("Fail to get next", e);
            throw new NextAlarmInformations("Fail to get next");
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to get next", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to get next", e);
            return false;
        }
    }

    @Override
    public void destroy() {
        LOGGER.debug("destroy AlarmInformationIterator: " + reference);
        reference.destroy();
        //this._orb().shutdown(false );
    }

}
