package com.telenav.uia.android.denali.module.na;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.telenav.uia.android.denali.module.common.FreeMapModule;
import com.android.hyperion.utility.*;


public class FreeMapModuleNA extends FreeMapModule {

    public FreeMapModuleNA(TnUIADevice tud)
    {
        super(tud);
    }
    public boolean logic2() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("NA logic2!");
        return true;
    }

    public boolean logic4() throws TnUIAObjectNotFoundException {
        TnUIALog.addRecordToLog("NA logic4!");
        return true;
    }
}
