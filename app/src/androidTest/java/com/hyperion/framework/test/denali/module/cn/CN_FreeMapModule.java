package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.common.FreeMapModule;


public class CN_FreeMapModule extends FreeMapModule {

    public boolean logic1() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("CN logic1!");
        return freeMap.checkScreen();
    }

    public void logic3() throws HFObjectNotFoundException {
        diyScreen.checkScreen();
        HFLog.addRecordToLog("CN logic3!");
    }
}
