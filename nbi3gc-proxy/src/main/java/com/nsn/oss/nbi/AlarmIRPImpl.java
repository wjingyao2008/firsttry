package com.nsn.oss.nbi;

import java.net.MalformedURLException;

import com.nsn.oss.nbi.common.Logger;
import org.omg.CORBA.BAD_INV_ORDER;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNotification.StructuredEvent;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongAdapter;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AcknowledgeFailureCategories;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationId;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder;
import com.nsn.oss.nbi.corba.AlarmIRPConstDefs.DNTypeOpt;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AcknowledgeAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmIRPPOA;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIterator;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.AlarmInformationIteratorHolder;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.ClearAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.CommentAlarms;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmCount;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmIRPVersions;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.GetAlarmList;
import com.nsn.oss.nbi.corba.AlarmIRPSystem.UnacknowledgeAlarms;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Method;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.Signal;
import com.nsn.oss.nbi.corba.ManagedGenericIRPConstDefs.StringTypeOpt;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.InvalidParameter;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.OperationNotSupported;
import com.nsn.oss.nbi.corba.ManagedGenericIRPSystem.ParameterNotSupported;
import com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmIRP;

public class AlarmIRPImpl extends AlarmIRPPOA {

    private final static Logger LOGGER = Logger.getLogger(AlarmIRPImpl.class);
    private IteratorStarter servantStarter;


    public AlarmIRPImpl(IteratorStarter servantStarter) {
        this.servantStarter = servantStarter;
    }

    @Override
    public String[] get_alarm_IRP_versions() throws GetAlarmIRPVersions {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetAlarmIRPVersions(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();
            String[] versions = alarmIRP.get_alarm_IRP_versions();
            return versions;
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.GetAlarmIRPVersions e) {
            LOGGER.error("Fail to get alarm irp versions", e);
            throw new GetAlarmIRPVersions(e.reason);
        } catch (Exception e) {
            LOGGER.error("Fail to get alarm irp versions", e);
            throw new GetAlarmIRPVersions(e.getMessage());
        }
    }

    @Override
    public Method[] get_alarm_IRP_operations_profile(String alarmIrpVersionSource)
        throws GetAlarmIRPOperationsProfile, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetAlarmIRPOperationsProfile(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method[]
                methods =
                alarmIRP.get_alarm_IRP_operations_profile(alarmIrpVersionSource);
            Method[] result = new Method[methods.length];
            for (int i = 0; i < methods.length; i++) {
                com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method method = methods[i];
                result[i] = new Method(method.name, method.parameter_list);
            }
            return result;
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            LOGGER.error("Fail to get alarm irp operations profiles", e);
            throw new OperationNotSupported();
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.GetAlarmIRPOperationsProfile e) {
            LOGGER.error("Fail to get alarm irp operations profiles", e);
            throw new GetAlarmIRPOperationsProfile(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to get alarm irp operations profiles", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to get alarm irp operations profiles", e);
            throw new GetAlarmIRPOperationsProfile(e.getMessage());
        }
    }

    @Override
    public Method[] get_alarm_IRP_notification_profile(String alarmIrpVersionSource)
        throws GetAlarmIRPNotificationProfile, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetAlarmIRPNotificationProfile(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method[]
                methods =
                alarmIRP.get_alarm_IRP_notification_profile(alarmIrpVersionSource);
            Method[] result = new Method[methods.length];
            for (int i = 0; i < methods.length; i++) {
                com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Method method = methods[i];
                result[i] = new Method(method.name, method.parameter_list);
            }
            return result;
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            LOGGER.error("Fail to get alarm irp notification profile", e);
            throw new OperationNotSupported(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.GetAlarmIRPNotificationProfile e) {
            LOGGER.error("Fail to get alarm irp notification profile", e);
            throw new GetAlarmIRPNotificationProfile(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to get alarm irp notification profile", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to get alarm irp notification profile", e);
            throw new GetAlarmIRPNotificationProfile(e.getMessage());
        }
    }

    @Override
    public Signal acknowledge_alarms(AlarmInformationIdAndSev[] alarmInformationIdAndSevListSource,
                                     String ackUserIdSource, StringTypeOpt ackSystemIdSource,
                                     BadAcknowledgeAlarmInfoSeqHolder badAckAlarmInfoListSource)
        throws ParameterNotSupported, InvalidParameter, AcknowledgeAlarms {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new AcknowledgeAlarms(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();

            com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[]
                alarmInformationIdAndSevListTarget =
                new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev[alarmInformationIdAndSevListSource.length];
            for (int i = 0; i < alarmInformationIdAndSevListTarget.length; i++) {
                AlarmInformationIdAndSev alarmInformationIdAndSevSource = alarmInformationIdAndSevListSource[i];
                com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev
                    AlarmInformationIdAndSevTarget =
                    new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.AlarmInformationIdAndSev();
                AlarmInformationIdAndSevTarget.alarm_information_reference =
                    alarmInformationIdAndSevSource.alarm_information_reference;
                AlarmInformationIdAndSevTarget.perceived_severity =
                    TypeUtilsForOutterToInternal.parseShortTypeOpt(alarmInformationIdAndSevSource.perceived_severity);
                alarmInformationIdAndSevListTarget[i] = AlarmInformationIdAndSevTarget;
            }
            String ackUserIdTarget = ackUserIdSource;
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                ackSystemIdTarget =
                TypeUtilsForOutterToInternal.parseStringTypeOpt(ackSystemIdSource);
            com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder
                badAckAlarmInfoListTarget =
                new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfoSeqHolder();
            String proxyInstanceId = ProxyUtil.getProxyInstanceId();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Signal
                signalTarget =
                alarmIRP.acknowledge_alarms(alarmInformationIdAndSevListTarget, ackUserIdTarget, proxyInstanceId,
                                            ackSystemIdTarget,
                                            badAckAlarmInfoListTarget);
            if (badAckAlarmInfoListTarget.value != null) {
                BadAcknowledgeAlarmInfo[]
                    badAcknowledgeAlarmInfoArraySource =
                    new BadAcknowledgeAlarmInfo[badAckAlarmInfoListTarget.value.length];
                for (int i = 0; i < badAckAlarmInfoListTarget.value.length; i++) {
                    com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAcknowledgeAlarmInfo
                        badAcknowledgeAlarmInfoTarget =
                        badAckAlarmInfoListTarget.value[i];
                    BadAcknowledgeAlarmInfo
                        badAcknowledgeAlarmInfoSource =
                        new BadAcknowledgeAlarmInfo(badAcknowledgeAlarmInfoTarget.alarm_information_reference,
                                                    AcknowledgeFailureCategories.from_int(
                                                        badAcknowledgeAlarmInfoTarget.failure_category.value()),
                                                    badAcknowledgeAlarmInfoTarget.reason);
                    badAcknowledgeAlarmInfoArraySource[i] = badAcknowledgeAlarmInfoSource;
                }
                badAckAlarmInfoListSource.value = badAcknowledgeAlarmInfoArraySource;
            }
            return Signal.from_int(signalTarget.value());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            LOGGER.error("Fail to ack alarms", e);
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AcknowledgeAlarms e) {
            LOGGER.error("Fail to ack alarms", e);
            throw new AcknowledgeAlarms(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to ack alarms", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to ack alarms", e);
            throw new AcknowledgeAlarms(e.getMessage());
        }
    }

    @Override
    public Signal unacknowledge_alarms(String[] alarmInformationIdListSource, String ackUserIdSource,
                                       StringTypeOpt ackSystemIdSource,
                                       BadAlarmInformationIdSeqHolder badAlarmInformationIdListSource)
        throws ParameterNotSupported, InvalidParameter, OperationNotSupported, UnacknowledgeAlarms {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new UnacknowledgeAlarms(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();

            String[] alarmInformationIdListTarget = alarmInformationIdListSource;
            String ackUserIdTarget = ackUserIdSource;
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                ackSystemIdTarget =
                TypeUtilsForOutterToInternal.parseStringTypeOpt(ackSystemIdSource);
            com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder
                badAlarmInformationIdListTarget =
                new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();

            String proxyInstanceId = ProxyUtil.getProxyInstanceId();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Signal
                signalTarget =
                alarmIRP.unacknowledge_alarms(alarmInformationIdListTarget, ackUserIdTarget, proxyInstanceId,
                                              ackSystemIdTarget,
                                              badAlarmInformationIdListTarget);

            if (badAlarmInformationIdListTarget.value != null) {
                BadAlarmInformationId[]
                    badAcknowledgeAlarmInfoArraySource =
                    new BadAlarmInformationId[badAlarmInformationIdListTarget.value.length];
                for (int i = 0; i < badAlarmInformationIdListTarget.value.length; i++) {
                    com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationId
                        badAcknowledgeAlarmInfoTarget =
                        badAlarmInformationIdListTarget.value[i];
                    BadAlarmInformationId
                        BadAlarmInformationIdSource =
                        new BadAlarmInformationId(badAcknowledgeAlarmInfoTarget.alarm_information_reference,
                                                  badAcknowledgeAlarmInfoTarget.reason);
                    badAcknowledgeAlarmInfoArraySource[i] = BadAlarmInformationIdSource;
                }
                badAlarmInformationIdListSource.value = badAcknowledgeAlarmInfoArraySource;
            }
            return Signal.from_int(signalTarget.value());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            LOGGER.error("Fail to unack alarms", e);
            throw new OperationNotSupported();
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.UnacknowledgeAlarms e) {
            LOGGER.error("Fail to unack alarms", e);
            throw new UnacknowledgeAlarms(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            LOGGER.error("Fail to unack alarms", e);
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to unack alarms", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to unack alarms", e);
            throw new UnacknowledgeAlarms(e.getMessage());
        }
    }

    @Override
    public Signal comment_alarms(String[] alarmInformationIdListSource, String commentUserIdSource,
                                 StringTypeOpt commentSystemIdSource, String commentTextSource,
                                 BadAlarmInformationIdSeqHolder badAlarmInformationIdListSource)
        throws ParameterNotSupported, CommentAlarms, InvalidParameter, OperationNotSupported {

        throw new OperationNotSupported();
        //		try {
//			AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();
//
//			String[] alarmInformationIdListTarget = alarmInformationIdListSource;
//			String commentUserIdTarget = commentUserIdSource;
//			com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt commentSystemIdTarget = TypeUtilsForOutterToInternal.parseStringTypeOpt(commentSystemIdSource);
//			String commentTextTarget = commentTextSource;
//			com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder badAlarmInformationIdListTarget = new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();
//
//			com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Signal signalTarget = alarmIRP.comment_alarms(alarmInformationIdListTarget, commentUserIdTarget, commentSystemIdTarget,
//					commentTextTarget, badAlarmInformationIdListTarget);
//
//			BadAlarmInformationId[] badAcknowledgeAlarmInfoArraySource = new BadAlarmInformationId[badAlarmInformationIdListTarget.value.length];
//			for (int i = 0; i < badAlarmInformationIdListTarget.value.length; i++) {
//				com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationId badAcknowledgeAlarmInfoTarget = badAlarmInformationIdListTarget.value[i];
//				BadAlarmInformationId BadAlarmInformationIdSource = new BadAlarmInformationId(badAcknowledgeAlarmInfoTarget.alarm_information_reference, badAcknowledgeAlarmInfoTarget.reason);
//				badAcknowledgeAlarmInfoArraySource[i] = BadAlarmInformationIdSource;
//			}
//			badAlarmInformationIdListSource.value = badAcknowledgeAlarmInfoArraySource;
//			return Signal.from_int(signalTarget.value());
//		} catch (MalformedURLException e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new CommentAlarms("Fail to comment alarms");
//		} catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new OperationNotSupported();
//		} catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.CommentAlarms e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new CommentAlarms("Fail to comment alarms");
//		} catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new ParameterNotSupported(e.getMessage());
//		} catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new InvalidParameter(e.parameter);
//		} catch (Exception e) {
//			LOGGER.error("Fail to comment alarms", e);
//			throw new CommentAlarms(e.getMessage());
//		}
    }

    @Override
    public Signal clear_alarms(String[] alarmInformationIdListSource, String clearUserIdSource,
                               StringTypeOpt clearSystemIdSource,
                               BadAlarmInformationIdSeqHolder badAlarmInformationIdListSource)
        throws ClearAlarms, ParameterNotSupported, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new ClearAlarms(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();

            String[] alarmInformationIdListTarget = alarmInformationIdListSource;
            String clearUserIdTarget = clearUserIdSource;
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                clearSystemIdTarget =
                TypeUtilsForOutterToInternal.parseStringTypeOpt(clearSystemIdSource);
            com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder
                badAlarmInformationIdListTarget =
                new com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationIdSeqHolder();

            String proxyInstanceId = ProxyUtil.getProxyInstanceId();
            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.Signal
                signalTarget =
                alarmIRP
                    .clear_alarms(alarmInformationIdListTarget, clearUserIdTarget, proxyInstanceId, clearSystemIdTarget,
                                  badAlarmInformationIdListTarget);

            if (badAlarmInformationIdListTarget.value != null) {
                BadAlarmInformationId[]
                    badAcknowledgeAlarmInfoArraySource =
                    new BadAlarmInformationId[badAlarmInformationIdListTarget.value.length];
                for (int i = 0; i < badAlarmInformationIdListTarget.value.length; i++) {
                    com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.BadAlarmInformationId
                        badAcknowledgeAlarmInfoTarget =
                        badAlarmInformationIdListTarget.value[i];
                    BadAlarmInformationId
                        BadAlarmInformationIdSource =
                        new BadAlarmInformationId(badAcknowledgeAlarmInfoTarget.alarm_information_reference,
                                                  badAcknowledgeAlarmInfoTarget.reason);
                    badAcknowledgeAlarmInfoArraySource[i] = BadAlarmInformationIdSource;
                }
                badAlarmInformationIdListSource.value = badAcknowledgeAlarmInfoArraySource;
            }

            return Signal.from_int(signalTarget.value());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            LOGGER.error("Fail to clear alarms", e);
            throw new OperationNotSupported(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.ClearAlarms e) {
            LOGGER.error("Fail to clear alarms", e);
            throw new ClearAlarms(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            LOGGER.error("Fail to clear alarms", e);
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to clear alarms", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to clear alarms", e);
            throw new ClearAlarms(e.getMessage());
        }
    }

    @Override
    public StructuredEvent[] get_alarm_list(StringTypeOpt filterSource, DNTypeOpt baseObjectSource,
                                            BooleanHolder flagSource, AlarmInformationIteratorHolder iter)
        throws GetAlarmList,
               ParameterNotSupported, InvalidParameter {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetAlarmList(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            LOGGER.debug("get_alarm_list filter: " + (filterSource.discriminator() ? filterSource.value() : "") +
                    " baseObject: " + (baseObjectSource.discriminator() ? baseObjectSource.value() : ""));
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();

            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                filterTarget =
                TypeUtilsForOutterToInternal.parseStringTypeOpt(filterSource);
            com.nsn.oss.nbi.internal.corba.AlarmIRPConstDefs.DNTypeOpt
                baseObjectTarget =
                AlarmIRPTypeUtils.parseDNTypeOptToInternal(baseObjectSource);
            BooleanHolder flagTarget = new BooleanHolder();
            com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmInformationIteratorHolder
                iterTarget =
                new com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmInformationIteratorHolder();

            String proxyInstanceId = ProxyUtil.getProxyInstanceId();

            StructuredEvent[]
                alarmsTarget =
                alarmIRP.get_alarm_list(filterTarget, baseObjectTarget, proxyInstanceId, flagTarget, iterTarget);
            flagSource.value = flagTarget.value;

            iter.value = createInterator(iterTarget);
            return alarmsTarget;
        } catch (MalformedURLException e) {
            LOGGER.error("Fail to get alarm list", e);
            throw new GetAlarmList(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            LOGGER.error("Fail to get alarm list", e);
            throw new ParameterNotSupported(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.GetAlarmList e) {
            LOGGER.error("Fail to get alarm list", e);
            throw new GetAlarmList(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to get alarm list", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to get alarm list", e);
            throw new GetAlarmList(e.getMessage());
        }
    }

    private AlarmInformationIterator createInterator(
        com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmInformationIteratorHolder iterTarget)
        throws OperationNotSupported, ServantAlreadyActive, WrongPolicy, InvalidName, AdapterInactive, GetAlarmList, WrongAdapter {
        AlarmInformationIteratorImpl iteratorImpl = new AlarmInformationIteratorImpl(iterTarget.value);
        servantStarter.activate(iteratorImpl);

        AlarmInformationIterator alarmInformationIteratorSource;
        int interval = 1000;
        int retryMax = 10;
        int retryNum = 0;
        while (true) {
            try {
                alarmInformationIteratorSource = iteratorImpl._this();
                break;
            } catch (BAD_INV_ORDER e) {
                retryNum++;
                if (retryNum >= retryMax) {
                    throw new GetAlarmList("Can not initialize iterator servant");
                }
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e1) {
                    LOGGER.error(e1);
                }
            }
        }
        return alarmInformationIteratorSource;
    }

    @Override
    public void get_alarm_count(StringTypeOpt filterSource, IntHolder criticalCountSource, IntHolder majorCountSource,
                                IntHolder minorCountSource, IntHolder warningCountSource,
                                IntHolder indeterminateCountSource, IntHolder clearedCountSource)
        throws ParameterNotSupported, GetAlarmCount, InvalidParameter, OperationNotSupported {
        if (!ProxyUtil.isProxyDeployed()) {
            throw new GetAlarmCount(ProxyUtil.REQUEST_REJECT_REASON_WHEN_PROXY_UNDEPLOYED);
        }
        try {
            LOGGER.debug("get_alarm_count filter: " + (filterSource.discriminator() ? filterSource.value() : ""));
            AlarmIRP alarmIRP = InternalServiceServiceLocator.getAlarmIRP();

            com.nsn.oss.nbi.internal.corba.ManagedGenericIRPConstDefs.StringTypeOpt
                filterTarget =
                TypeUtilsForOutterToInternal.parseStringTypeOpt(filterSource);

            alarmIRP.get_alarm_count(filterTarget, criticalCountSource, majorCountSource, minorCountSource,
                                     warningCountSource, indeterminateCountSource, clearedCountSource);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.OperationNotSupported e) {
            LOGGER.error("Fail to get alarm count", e);
            throw new OperationNotSupported(e.getMessage());
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.ParameterNotSupported e) {
            LOGGER.error("Fail to get alarm count", e);
            throw new ParameterNotSupported(e.parameter);
        } catch (com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.GetAlarmCount e) {
            LOGGER.error("Fail to get alarm count", e);
            throw new GetAlarmCount(e.reason);
        } catch (com.nsn.oss.nbi.internal.corba.ManagedGenericIRPSystem.InvalidParameter e) {
            LOGGER.error("Fail to get alarm count", e);
            throw new InvalidParameter(e.parameter);
        } catch (Exception e) {
            LOGGER.error("Fail to get alarm count", e);
            throw new GetAlarmCount(e.getMessage());
        }

    }

}
