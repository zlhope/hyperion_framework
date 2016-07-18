package com.hyperion.framework.test.denali.module.na;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.common.FreeMapModule;


public class NA_FreeMapModule extends FreeMapModule {

    public boolean logic2() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("NA logic2!");
        return true;
    }

    public boolean logic4() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("NA logic4!");
        return true;
    }
}
