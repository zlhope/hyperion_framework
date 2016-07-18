package com.hyperion.framework.test.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.hyperion.framework.library.utils.HFLog;
import com.hyperion.framework.library.utils.HFObjectNotFoundException;
import com.hyperion.framework.test.denali.module.Module;

public class EXT_SettingModule extends Module {

    public void logicExt() throws HFObjectNotFoundException {
        diyScreen.checkScreen();
        HFLog.addRecordToLog("Module ext run!");
    }
}
