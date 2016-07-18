package com.hyperion.framework.test.denali.module;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.screen.ScreenSetsExt;

public class Module extends ScreenSetsExt {

    public boolean commonLogic() throws HFObjectNotFoundException {
        HFLog.addRecordToLog("Parent logic!");
        return freeMap.checkScreen();
    }
}
