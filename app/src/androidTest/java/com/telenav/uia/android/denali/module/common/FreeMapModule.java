package com.telenav.uia.android.denali.module.common;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.ModuleRoot;


public class FreeMapModule extends ModuleRoot {

    public FreeMapModule(TnUIADevice tud)
    {
        super(tud);
    }

    public Boolean waitForMainPage() throws TnUIAObjectNotFoundException {
        if(objExist(common.mapPage,TnUIACommon.WAIT_LONG*3))
        {
            waitForElement(freeMap.oneBoxEditText, TnUIACommon.WAIT_LONG*3);
            waitUtilObjEnabled(freeMap.oneBoxEditText);
            return freeMap.checkScreen();
        }
        return false;
    }

    public boolean logic1() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Common logic1!");
        return true;
    }

    public boolean logic2() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("Common logic2!");
        return true;
    }
}
