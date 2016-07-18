package com.hyperion.framework.test.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.library.utils.HFVariables;
import com.hyperion.framework.test.denali.module.Module;


public class FreeMapModule extends Module {

    public Boolean waitForMainPage() throws HFObjectNotFoundException {
        if (objExist(common.mapPage, HFVariables.WAIT_LONG * 3)) {
            waitForElement(freeMap.oneBoxEditText, HFVariables.WAIT_LONG * 3);
            waitUtilObjEnabled(freeMap.oneBoxEditText);
            return freeMap.checkScreen();
        }
        return false;
    }

    public boolean logic1() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Common logic1!");
        return true;
    }

    public boolean logic2() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Common logic2!");
        return true;
    }
}
