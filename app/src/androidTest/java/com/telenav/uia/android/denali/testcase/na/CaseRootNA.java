package com.telenav.uia.android.denali.testcase.na;

/**
 * Created by Johnny Huang on 2016/1/21.
 */

import com.telenav.uia.android.denali.module.na.NavigationModuleNA;
import com.telenav.uia.android.denali.testcase.CaseRoot;
import com.android.hyperion.utility.*;
import com.telenav.uia.android.denali.module.na.FreeMapModuleNA;

public class CaseRootNA extends CaseRoot {
    public FreeMapModuleNA freeMapModule;
    public CaseRootNA() {
        TnUIACommon.REGION = "na";
        freeMapModule=new FreeMapModuleNA(tud);
    }
}
