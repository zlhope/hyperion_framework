package com.telenav.uia.android.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.TnUIADevice;
import com.android.hyperion.utility.TnUIALog;
import com.android.hyperion.utility.TnUIAObjectNotFoundException;
import com.telenav.uia.android.denali.module.ModuleRoot;

public class SettingModuleExt extends ModuleRoot {
    public SettingModuleExt(TnUIADevice tud)
    {
        super(tud);
    }

    public void logicExt() throws TnUIAObjectNotFoundException {
        diyScreen.checkScreen();
        TnUIALog.addRecordToLog("Module ext run!");
    }
}
