package com.nsn.oss.nbi;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmIRP;
import com.nsn.oss.nbi.internal.corba.AlarmIRPSystem.AlarmIRPHelper;
import com.nsn.oss.nbi.internal.corba.BasicCmIRPSystem._BasicCmIrpOperations;
import com.nsn.oss.nbi.internal.corba.BasicCmIRPSystem._BasicCmIrpOperationsHelper;
import com.nsn.oss.nbi.internal.corba.CSIRPSystem.CSIRP;
import com.nsn.oss.nbi.internal.corba.CSIRPSystem.CSIRPHelper;
import com.nsn.oss.nbi.internal.corba.EPIRPSystem.EPIRP;
import com.nsn.oss.nbi.internal.corba.EPIRPSystem.EPIRPHelper;
import com.nsn.oss.nbi.internal.corba.FileTransferIRPSystem.FileTransferIRP;
import com.nsn.oss.nbi.internal.corba.FileTransferIRPSystem.FileTransferIRPHelper;
import com.nsn.oss.nbi.internal.corba.KernelCmIRPSystem._KernelCmIrpOperations;
import com.nsn.oss.nbi.internal.corba.KernelCmIRPSystem._KernelCmIrpOperationsHelper;
import com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.NotificationIRP;
import com.nsn.oss.nbi.internal.corba.NotificationIRPSystem.NotificationIRPHelper;

public class InternalServiceServiceLocator {
    //private final static Logger LOGGER = Logger.getLogger(InternalServiceServiceLocator.class);

    private static AlarmIRP alarmIRP;

    private static CSIRP csIRP;
    private static FileTransferIRP ftIRP;
    private static _KernelCmIrpOperations kcmirp;
    private static _BasicCmIrpOperations bcmirp;
    private static NotificationIRP notificationirp;
    private static EPIRP epIRP;

    private static String IOR_FOLDER = "/var/opt/oss/global/NSN-nbi3gc/ior";

    public static String getIORFilder() {
        return IOR_FOLDER;
    }

    protected static String getIOR(String fileName) throws IOException {
        return FileUtils.readFileToString(new File(IOR_FOLDER + File.separator + fileName));
    }

    public static AlarmIRP getAlarmIRP() throws Exception {
        if (alarmIRP == null) {
            try {
                String ior = getIOR("AlarmIRP.ior").trim();
                alarmIRP = AlarmIRPHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return alarmIRP;
    }


    public static void resetAlarmIRP() {
        alarmIRP = null;
    }

    public static void setCSIRP(CSIRP csirp) {
        csIRP = csirp;
    }

    public static void setAlarmIRP(AlarmIRP alarmirp) {
        alarmIRP = alarmirp;
    }

    public static CSIRP getCSIRP() throws Exception {
        if (csIRP == null) {
            try {
                String ior = getIOR("CSIRP.ior").trim();
                csIRP = CSIRPHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return csIRP;
    }

    public static void resetCSIRP() {
        csIRP = null;
    }

    // for FileTransferIRP:
    public static void setFileTransferIRP(FileTransferIRP irp) {
        ftIRP = irp;
    }

    public static FileTransferIRP getFTIRP() throws Exception {
        if (ftIRP == null) {
            try {
                String ior = getIOR("FTIRP.ior").trim();
                ftIRP = FileTransferIRPHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return ftIRP;
    }

    public static void resetFTIRP() {
        ftIRP = null;
    }

    // for KernelCmIrpOperations:
    public static void setKernelCmIrpOperations(_KernelCmIrpOperations irp) {
        kcmirp = irp;
    }

    public static _KernelCmIrpOperations getKcmIRP() throws Exception {
        if (kcmirp == null) {

            try {
                String ior = getIOR("KernelCMIRP.ior").trim();
                kcmirp = _KernelCmIrpOperationsHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return kcmirp;
    }

    public static void resetKcmIRP() {
        kcmirp = null;
    }

    // for BasicCmIrpOperations:
    public static void setBasicCmIrpOperations(_BasicCmIrpOperations irp) {
        bcmirp = irp;
    }

    public static _BasicCmIrpOperations getBasicCmIRP() throws Exception {
        if (bcmirp == null) {

            try {
                String ior = getIOR("BasicCMIRP.ior").trim();
                bcmirp = _BasicCmIrpOperationsHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return bcmirp;
    }

    public static void resetBasicCmIrp() {
        bcmirp = null;
    }

    // for EPIrpOperations
    public static void resetEPIRP() {
        epIRP = null;
    }

    // for EPIRP:
    public static void setEPIRP(EPIRP irp) {
        epIRP = irp;
    }

    public static EPIRP getEPIRP() throws Exception {
        if (epIRP == null) {
            try {
                String ior = getIOR("EPIRP.ior").trim();
                epIRP = EPIRPHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return epIRP;
    }

    // for NotificationIRP:
    public static void setNotificationIRP(NotificationIRP irp) {
        notificationirp = irp;
    }

    public static NotificationIRP getNotificationIRP() throws Exception {
        if (notificationirp == null) {
            try {
                String ior = getIOR("NotificationIRP.ior").trim();
                notificationirp = NotificationIRPHelper.narrow(CorbaUtils.getOrb().string_to_object(ior));
            } catch (Exception e) {
                throw new Exception("Fail to get internal interface", e);
            }
        }
        return notificationirp;
    }

    public static void resetNotificationIRP() {
        notificationirp = null;
    }

}
