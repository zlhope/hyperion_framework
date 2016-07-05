package com.telenav.uia.android.denali.module.cn;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.common.FreeMapModule;


public class FreeMapModuleCN extends FreeMapModule {
    public FreeMapModuleCN(TnUIADevice tud)
    {
        super(tud);
    }
    public boolean logic1() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("CN logic1!");
        return freeMap.checkScreen();
    }

    public void logic3() throws TnUIAObjectNotFoundException {
        diyScreen.checkScreen();
        TnUIALog.addRecordToLog("CN logic3!");
    }
}
